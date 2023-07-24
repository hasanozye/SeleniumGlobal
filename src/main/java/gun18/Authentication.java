package gun18;

import gun17.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Authentication {

    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void authentication1() {
        /* Basic Authentication aşma yolu
        1. https://[kullaniciAdi]:[password]@the-internet.herokupapp.com/basic_auth
         */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }


    @Test
    public void authentication2() throws AWTException {
        /*
        2. Javanın Robor class'i
         */
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Basic Auth']")));

    }
}
