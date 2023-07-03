package gun02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05WebElement {

    WebDriver driver;
    String url = "https://www.saucedemo.com/v1/";
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By logo = By.id("header_container");

    String myUsername = "standard_user";
    String myPassword = "secret_sauce";

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void webElement1() {
//        WebElemen selenium tarafından findElement ile bulunan web nesneleri.
        driver.get(url);
        WebElement usernameElement = driver.findElement(userName);
        usernameElement.sendKeys(myUsername);
        System.out.println(usernameElement.getAttribute("class"));

        WebElement passwordElement = driver.findElement(password);
        passwordElement.sendKeys(myPassword);
        System.out.println(usernameElement.getAttribute("autocorrect"));

        WebElement loginElement = driver.findElement(loginButton);
        loginElement.click();

        WebElement header = driver.findElement(logo);
        boolean logoDisplayed = header.isDisplayed();
        Assert.assertTrue(logoDisplayed, "Hata mesaji");
        driver.quit();


    }
}
