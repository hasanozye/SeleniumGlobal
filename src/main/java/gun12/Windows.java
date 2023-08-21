package gun12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Windows {

    WebDriver driver;
    WebDriverWait wait;
    public Windows() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void driverHandle(){
        driver.get("https://demoqa.com/browser-windows");
        System.out.println(driver.getWindowHandle());
        driver.quit();
    }

    @Test
    public void driverHandles(){
        driver.get("https://demoqa.com/browser-windows");
        WebElement eNewTab = driver.findElement(By.id("tabButton"));
        eNewTab.click();
        System.out.println(driver.getWindowHandles());
        driver.quit();
    }


    /*
    driver.getWindowHandle()       : aktif kullandığım window'un handle'ini verir (id)
    driver.getWindowHandles()      : acilmiş olan tüm windowlarin handle'larini set olarak verir
     */


}
