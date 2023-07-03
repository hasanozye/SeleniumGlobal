package gun02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04FindElement {

    WebDriver driver;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test
    public void findElement1() {
        String url = "https://www.saucedemo.com/v1/";
        driver.get(url);

//        WebDriver'in web sayfasi içindeki elementleri görmesi/bulmasi locator'lar ile olur.
//        Locator class'i "By"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean logoGorundu = driver.findElement(By.id("header_container")).isDisplayed();
        Assert.assertTrue(logoGorundu, " logo Görünmedi");
        driver.quit();

    }

    @Test
    public void findElement2() {
        String url = "https://www.saucedemo.com/v1/";
        driver.get(url);

        By userName = By.id("user-name");
        By password = By.id("password");
        By loginButton = By.id("login-button");
        By logo = By.id("header_container");

        String myUsername = "standard_user";
        String myPassword = "secret_sauce";

//        WebDriver'in web sayfasi içindeki elementleri görmesi/bulmasi locator'lar ile olur.
//        Locator class'i "By"
        driver.findElement(userName).sendKeys(myUsername);
        driver.findElement(password).sendKeys(myPassword);
        driver.findElement(loginButton).click();

        boolean logoGorundu = driver.findElement(logo).isDisplayed();
        Assert.assertTrue(logoGorundu, " logo Görünmedi");
        driver.quit();

    }
}
