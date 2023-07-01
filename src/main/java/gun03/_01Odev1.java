package gun03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01Odev1 {
    //1. https://the-internet.herokuapp.com/login  sayfasina gidin
    // 2. Sayfadaki h2 elementinin textinin "Login Page" oldugunu assert edin
    // 3. Formdaki Kullanici ve sifreyi doldurun.
    //    Kullanici: tomsmith
    //    Sifre : SuperSecretPassword!
    // 4. Login butonuna tiklayin
    //5. Login oldugunuzdan
    //    a) h2 elementinin textinin "Secure Area" oldugunu,
    //    b) h4 elementinin icinde "Welcome to the Secure Area" yazisinin oldugunu
    //    assert ederek emin olun

    WebDriver driver;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    String url = "https://the-internet.herokuapp.com/login";
    By tagName = By.tagName("h2");
    By userNameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.className("radius");
    By secureAreaText = By.tagName("h2");
    By mainPagetext = By.tagName("h4");


    @Test
    public void test1() {
        //1. https://the-internet.herokuapp.com/login  sayfasina gidin
        driver.get(url);

        // 2. Sayfadaki h2 elementinin textinin "Login Page" oldugunu assert edin
        WebElement loginPageTag = driver.findElement(tagName);
        String loginPageTagText = loginPageTag.getText();
        Assert.assertEquals(loginPageTagText, "Login Page");

        // 3. Formdaki Kullanici ve sifreyi doldurun.
        WebElement usernameElement = driver.findElement(userNameField);
        usernameElement.sendKeys("tomsmith");

        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys("SuperSecretPassword!");

        // 4. Login butonuna tiklayin
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();

        //5. Login oldugunuzdan
        //    a) h2 elementinin textinin "Secure Area" oldugunu,
        WebElement secureAreaTextElement = driver.findElement(secureAreaText);
        String secureAreaTextStr = secureAreaTextElement.getText();
        Assert.assertEquals(secureAreaTextStr, "Secure Area");

        //    b) h4 elementinin icinde "Welcome to the Secure Area" yazisinin oldugunu
        WebElement mainPageTextElement = driver.findElement(mainPagetext);
        String mainPageTextStr = mainPageTextElement.getText();
        Assert.assertTrue(mainPageTextStr.contains("Welcome to the Secure Area"));
        //    assert ederek emin olun
        driver.quit();


    }


}
