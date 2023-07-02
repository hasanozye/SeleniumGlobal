package gun04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02LoginKontrol {
    //0.  Driver tanimlama
    //1.  https://automationexercise.com/  git
    //2.  Sayfani acildigini assert edin.
    //3.  Sign up / Login linkine tikla
    //4.  Login sayfasi oldugunu assert edin
    //5.  eMail ve sifre girin, eMail: aaaa@aa.com, pass: 123456
    //6.  Hata mesajinin ciktigini assert edin
    //7.  browser'i kapatin
    WebDriver driver;

    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test01() {
        //0.  Driver tanimlama
        driverSetup();

        //1.  https://automationexercise.com/  git
        driver.get("https://automationexercise.com/");

        //2.  Sayfani acildigini assert edin.
        WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());

        //3.  Sign up / Login linkine tikla
        WebElement signupElement = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signupElement.click();

        //4.  Login sayfasi oldugunu assert edin
        WebElement pageText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(pageText.isDisplayed());

        //5.  eMail ve sifre girin, eMail: aaaa@aa.com, pass: 123456
        WebElement loginEmailElement = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmailElement.sendKeys("aaaa@aa.com");

        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-qa ='login-password']"));
        passwordElement.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //6.  Hata mesajinin ciktigini assert edin
        WebElement redText = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(redText.isDisplayed());

        driver.quit();


    }


}


