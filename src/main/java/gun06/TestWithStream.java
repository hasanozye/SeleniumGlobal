package gun06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestWithStream {
    WebDriver driver;
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test01(){
        driver.get("https://www.saucedemo.com/v1/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.clear();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.clear();
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector(".btn_action"));
        loginBtn.click();

        By productTitle = By.xpath("//div[text()='Products']");
        Assert.assertTrue(driver.findElement(productTitle).isDisplayed());

        By products = By.xpath("//div[@class='inventory_item_name' or @class = 'inventory_item_price']");

        List<WebElement> list = driver.findElements(products);
        list.forEach(e-> System.out.println(e.getText()));


        System.out.println("-".repeat(34));

        list.stream()
                .filter(e->e.getText().contains("$"))
                .toList()
                .forEach(e-> System.out.println(e.getText().replace("$","").concat(" TL")));

        driver.quit();














    }



}
