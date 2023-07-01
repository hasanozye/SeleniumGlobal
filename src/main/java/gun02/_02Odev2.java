package gun02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _02Odev2 {
    /*
           B. Chrome browser ile kullanarak
      1. https://demos.bellatrix.solutions/ sayfasina gidin
      2. Sayfa title'inin length'ini, currentURL'i ve pageSource()'u [sayfa kaynak kodlari] consol'a yazdirin.
      3. Title'in uzunlugunun 10'dan büyük oldugunu assert edin.
      4. Current url'in "google" icermedigini assert edin
     */

    static WebDriver driver;

    public static void main(String[] args) {

//        Chrome browser ile kullanarak
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        Sayfa title'inin length'ini, currentURL'i ve pageSource()'u [sayfa kaynak kodlari] consol'a yazdirin.
        driver.get("https://demos.bellatrix.solutions/");
        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();
        System.out.println("title = " + title);
        System.out.println("currentUrl = " + currentUrl);
        System.out.println("pageSource = " + pageSource);

//        Title'in uzunlugunun 10'dan büyük oldugunu assert edin.
        Assert.assertTrue(title.length() > 10, "Title length is not greater then 10.");

//        Current url'in "google" icermedigini assert edin
        Assert.assertFalse(currentUrl.contains("google"));


    }
}
