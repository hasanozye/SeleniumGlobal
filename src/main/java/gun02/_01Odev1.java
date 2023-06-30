package gun02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class _01Odev1 {
    /*
        A. Firefox browser ile kullanarak
      1. https://opensource-demo.orangehrmlive.com/web/index.php/auth/login  sayfasina gidin
      2. Sayfa Title'in "OrangeHRM" oldugunu assert edin
      3. CurrentURL'de "auth" kelimesinin gectigini assert edin

     */

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Baslik hatali");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("auth"), "Auth icermemektedir");
        driver.quit();
    }
}