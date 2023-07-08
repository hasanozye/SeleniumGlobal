package gun08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewTask {
    WebDriver driver;
    WebDriverWait wait;
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void uiTestAutomation(){
        driver.get("http://www.uitestingplayground.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");

        click(driver,By.xpath("//a[text()='Shadow DOM']"));





    }


    private void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void click(WebDriver driver, int seconds, By locator){
        new WebDriverWait(driver,Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void click(WebDriver driver, By locator){
        click(driver,10,locator);
    }





}
