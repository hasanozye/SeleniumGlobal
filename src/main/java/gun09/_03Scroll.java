package gun09;

import com.github.javafaker.Faker;
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
import java.util.List;

import static gun09.MyLocatorsClass.*;

public class _03Scroll {

    WebDriver driver;
    WebDriverWait wait;
    Faker faker;
    JavascriptExecutor js;

    public _03Scroll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        faker = new Faker();
        js = (JavascriptExecutor) driver;
    }

    /*
    Bir element ile interaction oalcak sie ve o element, başka bir element ile örtülüyorsa,
    alttaki element ile işlem yapilamaz.
    Bu durumda sayfanın aşağı doğru scroll edilmesi gerekir.
    Scroll işlemini Javascript yapar.
     */

    @Test
    public void testFillTheForm() {
        driver.get("https://demoqa.com/text-box");
        js.executeScript("window.scrollBy(0,250)");

        sendKey(lName, faker.name().firstName());
        sendKey(lEmail, faker.internet().emailAddress());
        sendKey(lCAdress, faker.address().fullAddress());
        sendKey(lPAddress, faker.address().secondaryAddress());

        /*
        lSubmit görününceye kadar 200 px aşşağı kaydır.
         */

        click(lSubmit);

//        js.executeScript("alert('Bitti')");


    }


    /*
    JavascriptExecutor ile kullanilacak basit 3 script;

    1. mevcut noktadan 0 birim saga, 300 birim asagi git.
    js.executeScript(window.scrollBy(0,300)");

    2. ekranda x=300 ve y=300 noktasina git.
    js.executeScript("window.scrollTo(300,300)");

    3. element'e kadar scroll et
    js.executeScript("arguments[0].scrollIntoView();", element);
    js.executeScript("arguments[1].scrollIntoView();", element0, element1);

     */

    @Test
    public void testScrollIntoView(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        By p = By.xpath("//p[contains(text(),'Curae era')]");

        WebElement elementP = wait.until(ExpectedConditions.presenceOfElementLocated(p));

        js.executeScript("arguments[0].scrollIntoView();",elementP);
        Utils.bekle(2000);

        // false aranan elementin üst sınırı sayfanın üstünde olacak
        js.executeScript("arguments[0].scrollIntoView(false);",elementP);
        Utils.bekle(2000);

        // true aranan elementin üst sınırı sayfanın üstünde olacak
        js.executeScript("arguments[0].scrollIntoView(true)",elementP);
        Utils.bekle(2000);


         driver.quit();


    }


    void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    void sendKey(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

}
