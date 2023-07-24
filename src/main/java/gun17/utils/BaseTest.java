package gun17.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void click(By locator){
        // aldigi locator'a tiklayacak
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    protected void click(WebElement element){
        // aldigi elemente tiklayacak
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeys(By locator, String text){
        // aldigi locator'a gelen text'i send edecek
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    protected void sendKeys(WebElement element, String text){
        // aldigi elemente gelen text'i send edecek
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    protected void hover(WebElement element){
        // aldigi elemente hover edecek
        new Actions(driver).moveToElement(element).perform();

    }

    protected void actionWait(long milis){
        // aldigi dege kadar bekleyecek
        new Actions(driver).pause(Duration.ofMillis(milis)).perform();
    }

    protected void waitForPresence(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}