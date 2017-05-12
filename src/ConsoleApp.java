
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TuX
 */
public class ConsoleApp implements DL_Manager
{
    Scanner oku = new Scanner(System.in);
    
    
    public ConsoleApp()
    {
        try
        {
            CoreApp ca = new CoreApp(this);
        } catch (Exception e) { e.printStackTrace(); }
        
    }
    
    public static void main(String[] args)
    {
        new ConsoleApp();
    }

    public String getURL()
    {
        System.out.println("İndirilecek Dosyanın Adresini Girin : ");
        return oku.nextLine();
    }

    public String getFilePath()
    {
        System.out.println("Dosya Nereye Kaydedilsin");
        return oku.next();
    }

    public void showProgress(double percent)
    {
        System.out.println("Tamamlanan %"+percent);
    }

    public void downloadCompleted()
    {
        System.out.println("İndirme Tamamlandır");
    }

    public void showError(String msg)
    {
        System.out.println("İndirme Hatası : "+msg);
    }
    
}
