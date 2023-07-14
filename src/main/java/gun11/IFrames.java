package gun11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class IFrames {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://demoqa.com/frames";
    By sampleText = By.id("sampleHeading");
    String frame1Id = "frame1";


    @Test
    public void testFrame1() {
        setupDriver();
        driver.get(url);


        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        WebElement sT = wait.until(ExpectedConditions.visibilityOfElementLocated(sampleText));
        System.out.println(sT.getText());

        driver.switchTo().parentFrame();

        String mainText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText();
        System.out.println("mainText = " + mainText);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Element);

        WebElement sT2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sampleText));
        System.out.println(sT2.getText());

        driver.switchTo().parentFrame();
        String mainText2 = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText();
        System.out.println("mainText2 = " + mainText2);

        tearDown();
    }

    /*
    Her iFrame ayri birere web sayfasidir
    iframe ile islem yaparken, driver'in iframe içine atlaması sarttir.
    Aksi halde driver iFrame içerisindeki elementleri görmez.
    driver.switchTo().frame( name | id | WebElemenet)

    iFrame dişındaki elementleri görmesi çin de iFrame'den çıkması gerekmetkerdir.
    driver.switchTo().parentFrame();
     */
    By lFirstFrameId = By.id("frame1");
    By lFirstFrameText = By.xpath("//*[text()='Parent frame']");
    By lSecondFrameId = By.tagName("iframe");
    By lSecondFrameText = By.xpath("//*[text()='Child Iframe']");
    By lMainText = By.xpath("//*[text()='Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.']");

    @Test
    public void testFrame2(){
        setupDriver();
        driver.get("https://demoqa.com/nestedframes");

        WebElement eIFrameFirst = driver.findElement(lFirstFrameId);
        driver.switchTo().frame(eIFrameFirst);

        WebElement eFirstFrameText = driver.findElement(lFirstFrameText);

        String textFirstFrame = eFirstFrameText.getText();
        System.out.println("textFirstFrame = " + textFirstFrame);

        WebElement eIFrameSecond = driver.findElement(lSecondFrameId);
        driver.switchTo().frame(eIFrameSecond);

        WebElement eSecondFrameText = driver.findElement(lSecondFrameText);

        String textSecondFrame = eSecondFrameText.getText();
        System.out.println("textSecondFrame = " + textSecondFrame);

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        WebElement eMainText = driver.findElement(lMainText);
        String mainText = eMainText.getText();
        System.out.println("mainText = " + mainText);

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
