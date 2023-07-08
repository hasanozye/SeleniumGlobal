package gun09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class _01ShadowRoot {
    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void shadowRoot() {
        By lHeader = By.cssSelector(".container > h3");
        By linput = By.id("editField");
        By lgenerateButton = By.id("buttonGenerate");

        driver.get("http://www.uitestingplayground.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");
        click(driver, By.xpath("//a[text()='Shadow DOM']"));

        wait.until(ExpectedConditions.textToBe(lHeader, "Shadow DOM"));

        /*
        Shadow root isminde
        Shadow root elementini bulunur. Bunu Web Element olarak alırız.
        Alinan elementte .getShadowRoot() metodu ile ShadowRoot çözülür.
        istenilen element findElement ile bu çözülen element altinda aranir.

         */

        By lShadowRoot = By.tagName("guid-generator");
        WebElement eShadowRoot = driver.findElement(lShadowRoot);
        eShadowRoot.getShadowRoot().findElement(linput).sendKeys("shadow");
        Utils.bekle(2000);
        eShadowRoot.getShadowRoot().findElement(lgenerateButton).click();
        Utils.bekle(1000);

        driver.quit();


    }


    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void click(WebDriver driver, int seconds, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void click(WebDriver driver, By locator) {
        click(driver, 10, locator);
    }


}
