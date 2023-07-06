package gun08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class _01GetCss {

    WebDriver driver;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkBgColor() {

//        get into the site
        driver.get("http://www.uitestingplayground.com/");

//        js to go a little bit down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

//        click the click link
        By clickLink = By.xpath("//a[text()='Click']");
        WebElement clickLinkElement = driver.findElement(clickLink);
        clickLinkElement.click();

//        locate the button before clicking
        By colorBeforeClick = By.id("badButton");
        WebElement colorBeforeClickElement = driver.findElement(colorBeforeClick);

//        get css value of the button before clicking, and converting it to hex for assertion
        String blueCssValue = colorBeforeClickElement.getCssValue("background-color");
        String hexBlue =Color.fromString(blueCssValue).asHex();


//        assertion of the hex value with original one
        Assert.assertEquals(hexBlue, "#007bff", "it is not equal!");

//        click and wait a bit
        colorBeforeClickElement.click();
        Utils.bekle(2000);

//        Get the css value and convert it to hex value for assertion after clicking
        String greenCssValue = colorBeforeClickElement.getCssValue("background-color");
        String hexGreen = Color.fromString(greenCssValue).asHex();

//        assertion
        Assert.assertEquals(hexGreen, "#218838", "it is not equal!");

        driver.quit();


    }

    @Test
    public void loadingImg(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        By loadingImg = By.xpath("//*[text()='Loading images']");
        WebElement loadingImgElement = driver.findElement(loadingImg);
        loadingImgElement.click();

        Utils.bekle(4000);

        By pusulaImg = By.id("compass");
        WebElement pusulaImgElement = driver.findElement(pusulaImg);
        Assert.assertTrue(pusulaImgElement.isDisplayed());

        driver.quit();

    }


}
