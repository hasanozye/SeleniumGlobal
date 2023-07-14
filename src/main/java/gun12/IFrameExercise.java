package gun12;

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

public class IFrameExercise {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://the-internet.herokuapp.com/frames";

    public IFrameExercise(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By lIFrameLink = By.xpath("//a[text()='iFrame']");
    By lIFrameBox = By.xpath("//iframe[@title='Rich Text Area']");
    By lIFrameContentArea = By.tagName("body");


    @Test
    public void herokuAppIframes() {
        driver.get(url);
        click(lIFrameLink);
        WebElement eIFrameBox = driver.findElement(lIFrameBox);
        driver.switchTo().frame(eIFrameBox);
        sendKeys(lIFrameContentArea, "Hasan Özyer");
        driver.quit();

    }

    By lNestedFramesLink = By.xpath("//a[text()='Nested Frames']");

    @Test
    public void herokuAppNestedFrames() {
        driver.get(url);
        click(lNestedFramesLink);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


        driver.quit();
    }

    By lContentArea = By.cssSelector("p");
    @Test
    public void herokupAppFramesExercise(){
        driver.get(url);
        click(lIFrameLink);
        driver.switchTo().frame("mce_0_ifr");
        WebElement eContentArea = driver.findElement(lContentArea);
        eContentArea.sendKeys(Keys.LEFT_CONTROL + "A");
        eContentArea.sendKeys(Keys.DELETE);

        driver.quit();
    }

    By lFileBtn = By.xpath("//span[text()='File']");
    By lNewDocumentBtn = By.xpath("//div[text()='New document']");
    By lBoldBtn = By.xpath("//button[@title='Bold']");
    By lItalicBtn = By.xpath("//button[@title='Italic']");

    @Test
    public void herokupAppFramesExercise2(){
        driver.get(url);
        click(lIFrameLink);
        click(lFileBtn);
        click(lNewDocumentBtn);
        click(lBoldBtn);
        click(lItalicBtn);
        driver.switchTo().frame("mce_0_ifr");
        WebElement eContentArea = driver.findElement(lContentArea);
        eContentArea.sendKeys("Hasan");

        driver.quit();


    }


    private void click(By locator) {
        WebElement element = driver.findElement(locator);
        click(element);
    }

    private void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    private void sendKeys(By locator, String msg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        sendKeys(element, msg);
    }

    private void sendKeys(WebElement element, String message) {
        element.clear();
        element.sendKeys(message);
    }


}
