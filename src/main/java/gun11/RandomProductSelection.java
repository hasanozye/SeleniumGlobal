package gun11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RandomProductSelection {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://www.saucedemo.com/v1/";
    By lUsername = By.id("user-name");
    By lPassword = By.id("password");
    By lProducts = By.cssSelector(".inventory_item");


    @Test
    public void selectRandomProduct() {
        setupDriver();
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername)).sendKeys("standard_user");
        driver.findElement(lPassword).sendKeys("secret_sauce" + Keys.ENTER);
//        driver.findElement(lPassword).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.numberOfElementsToBe(lProducts, 6));
        List<WebElement> eProducts = driver.findElements(lProducts);

        int rndmNumber = new Random().nextInt(eProducts.size());
        WebElement selectedProd = eProducts.get(rndmNumber);

        String pName = selectedProd
                .findElement(By.cssSelector(".inventory_item_name"))
                .getText();

        String pPrice = selectedProd
                .findElement(By.cssSelector(".inventory_item_price"))
                .getText()
                .replaceAll("[^0-9.]", "");

        System.out.println("Name Price\n" + pName + ", " + pPrice);

        selectedProd.findElement(By.cssSelector(".inventory_item_name")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_details_back_button")));

        WebElement container = driver.findElement(By.id("inventory_item_container"));

        Assert.assertTrue(container.getText().contains(pName));
        Assert.assertTrue(container.getText().contains(pPrice));


        tearDown();

    }

    void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    void tearDown() {
        driver.quit();
    }


}
