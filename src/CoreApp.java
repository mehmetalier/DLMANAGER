
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class CoreApp
{
    public int dlSize = 0;
    public int toplamIndirilen = 0;
    public URLConnection uc;
    public URL u;
    public File f;
    
    public CoreApp(DL_Manager dlm) throws Exception
    {
        String adr = dlm.getURL();
        
        f = new File(dlm.getFilePath());
        
        u = new URL(adr);
        uc = u.openConnection();
        dlSize = uc.getContentLength();
        toplamIndirilen = 0;
        
        new Thread()
        {
            public void run()
            {
                try
                {
                    
                    byte[] chunk = new byte[16384];
                    InputStream is = uc.getInputStream();
                    FileOutputStream fos = new FileOutputStream(f);
                    int okunan = 0;
                    
                    while ((okunan = is.read(chunk)) != -1)
                    {
                        System.out.println("Okunan Byte Sayısı : "+okunan);
                        toplamIndirilen += okunan;
                        fos.write(chunk,0, okunan);
                        double yuzde = (toplamIndirilen * 100.0) / dlSize;
                        
                        dlm.showProgress(yuzde);
                    }
                    
                    fos.close();
                    dlm.downloadCompleted();
                } catch (Exception e) 
                {
                    dlm.showError(e.toString());
                }
            }
        }.start();
    }
}
