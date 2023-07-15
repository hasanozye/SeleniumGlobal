package gun13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class AlertSwitchTo {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public AlertSwitchTo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }

    String url = "https://demoqa.com/alerts";
    By lAlertBtn = By.id("alertButton");
    By lTimerAlertBtn = By.id("timerAlertButton");
    By lConfirmBtn = By.id("confirmButton");
    By lPromtBtn = By.id("promtButton");
    By lConfirmText = By.id("confirmResult");
    By lPromptText = By.id("promptResult");

    @Test
    public void alertButtonTest() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));

        driver.findElement(lAlertBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        driver.quit();


    }

    @Test
    public void alertButtonTest2() {
        driver.get(url);
        driver.findElement(lTimerAlertBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        driver.findElement(lConfirmBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(lConfirmText).getText(), "You selected Cancel");

        WebElement ePromtBtn = driver.findElement(lPromtBtn);
        js.executeScript("arguments[0].scrollIntoView();", ePromtBtn);

        Utils.bekle(2000);

        driver.findElement(lPromtBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hasan Özyer");
        alert.accept();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        Assert.assertTrue(driver.findElement(lPromptText).getText().contains("Hasan Özyer"));
        Utils.bekle(2000);

        driver.quit();


    }


}
