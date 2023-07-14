package gun11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedIframes {

    WebDriver driver;
    WebDriverWait wait;

    By lFirstFrameId = By.id("frame1");
    By lFirstFrameText = By.xpath("//*[text()='Parent frame']");
    By lSecondFrameId = By.tagName("iframe");
    By lSecondFrameText = By.xpath("//*[text()='Child Iframe']");
    By lMainText = By.xpath("//*[text()='Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.']");

    @Test
    public void testFrame2() {
        //ana penceredeyiz
        setupDriver();
        driver.get("https://demoqa.com/nestedframes");

        //body ana penceretenin body'si
//        System.out.println(driver.findElement(By.cssSelector("body")).getText());

        //frame1'e atladik
        driver.switchTo().frame("frame1");

        //body frame1'in body'si
        //frame1 içinde driver.findElement(By) ile aranan tüm selectorler frame1 içinde aranır
        // ne paerntframe de ne de child iframe içinde aranmaz
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

        //frame1 içinde yalnız 1 adet iframe var. index kullanılabilir. i frame element olarak da tanımlanabilir.
        WebElement childFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childFrame);

        System.out.println(driver.findElement(By.cssSelector("p")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.cssSelector("#framesWrapper>div")).getText());

        tearDown();
    }

    void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    void tearDown() {
        driver.quit();
    }
}

