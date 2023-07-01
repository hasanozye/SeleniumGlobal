package gun03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02Odev2 {
    //1. https://opencart.abstracta.us/index.php?route=account/register     sayfasina gidin
    //        2. id'si logo elementin visible oldugunu assert edin.
    //        3. Eger chrome baglanti güvenlik uyarisi verir ise
    //"Your connection is not private" uyarisi
    //a) alttaki "Advanced" butonuna tiklayin
    //b) en alttaki "Proceed to opencart.abstracta.us (unsafe)" linkine tiklayin ve madde-2'yi yapin

    WebDriver driver;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    By idYourStore = By.id("logo");

    @Test
    public void test1() {
        //1. https://opencart.abstracta.us/index.php?route=account/register     sayfasina gidin
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");

        //        2. id'si logo elementin visible oldugunu assert edin.
        WebElement idYourStoreElement = driver.findElement(idYourStore);
        Assert.assertTrue(idYourStoreElement.isDisplayed(),"It is not displayed.");
        driver.quit();

    }


}
