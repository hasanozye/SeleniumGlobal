package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class _01DriverDefinition {

    // aciklama sayfanin alt kismindadir.

    public static void main(String[] args) {

        // Chrome Driver set edildi
        WebDriverManager.chromedriver().setup();

        // Browser'i kontrol edecek WebDriver instance'i tanimliyoruz
        WebDriver driver = new ChromeDriver();

        // driver'a https://www.google.com adresine git komutu veriyoruz
        driver.get("https://www.google.com");

        // Driver kapatiliyor
        // driver'in actigi browser'i tümü ile kapatir, birden fazla pencere acmis olsa da
        driver.close();

        //  driver'in actigi fazla pencere varsa, aktif pencereyi kapatir
        //driver.close();

    }
}

    /*
            Chrome, Edge, Safari gibi browser'lari kullanabilmek icin
            WebDriver'a ihtiyacimiz vardir.

            Java icin WebDriveri hazirlamak gerekir

            Bir Java projesinde (Maven/Gradle olmayan) browser'i kontrol edebilmek icin
            1.  chromedriver.exe/geckodriver.exe/safaridriver.exe/....
                gibi selenium'un browserlari  kontrol etmesini saglayacak
                exe dosyalarini indirmek,
            2.  Bu dosyalari
                System.setProperty("webdriver.chrome.driver", "c:/../../chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "c:/../../geckodriver.exe");
                seklinde systeme tanitmak gerekmektedir.

            Yukaridaki islemler yerine
            WebDriver Tanimlamak icin WebDriverManager kullanarak asagidaki komutlarla ile kolaylikla yapariz.

            --- Chrome icin
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            ---Firefox icin
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();

            ---Safari icin
            WebDriverManager.safaridriver().setup();
            WebDriver driver = new SafariDriver();


         */