
public interface DL_Manager
{
    // 1- Kullanıcıdan İndirilecek Yolun Adresini Al
    public String getURL();
    
    // 2 - Kaydedilecek Dosyanın Yolunu Almam Lazım
    public String getFilePath();
    
    // 3 - Dosyayı İndirirken İlerlemeyi Göstermem Lazım
    public void showProgress(double percent);
    
    // 4 - Dosya İndirme Tamamlandığı Zaman Kullanıcıyı Bilgilendirmem Lazım
    public void downloadCompleted();
    
    
    // 5- Bir Hata Olusursa, Hatayı Kullanıcıya Göstermem Lazım
    public void showError(String msg);
}
