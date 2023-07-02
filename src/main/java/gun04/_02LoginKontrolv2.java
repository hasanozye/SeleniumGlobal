package gun04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class _02LoginKontrolv2 {

    WebDriver driver;

    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        //0.  Driver tanimlama
        setupDriver();

        //1.  https://automationexercise.com/  git
        driver.get("https://automationexercise.com/");

        //2.  Sayfani acildigini assert edin.
        Assert.assertTrue(driver.findElement(By.xpath("//li/a[contains(text(), 'Home')]")).isDisplayed());

        //3.  Sign up / Login linkine tikla
        driver.findElement(By.xpath("//li/a[contains(text(), 'Login')]")).click();

        //4.  Login sayfasi oldugunu assert edin
        boolean h2Visible = driver.findElement(By.cssSelector(".login-form > h2")).isDisplayed();
        Assert.assertTrue(h2Visible);

        //5.  eMail ve sifre girin, eMail: aaaa@aa.com, pass: 123456
        driver.findElement(By.cssSelector(".login-form input[name='email']")).sendKeys("aaa@aa.com");
        driver.findElement(By.cssSelector(".login-form input[name='password']")).sendKeys("aaa");
        driver.findElement(By.cssSelector(".login-form button")).click();

        //6.  Hata mesajinin ciktigini assert edin
        boolean error = driver.findElement(By.xpath("//p[contains(text(),'incorrect!') and contains(@style, 'red')]")).isDisplayed();
        Assert.assertTrue(error);
        Utils.bekle(3000);
        //7.  browser'i kapatin
        driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }


}


