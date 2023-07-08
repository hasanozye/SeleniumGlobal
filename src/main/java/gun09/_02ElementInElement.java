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

import java.time.Duration;
import java.util.List;
import static gun09.MyLocatorsClass.*;

public class _02ElementInElement {

    WebDriver driver;
    WebDriverWait wait;
    Faker faker;
    JavascriptExecutor js;

    public _02ElementInElement() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        faker = new Faker();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void elementInElement() {
        driver.get("https://demoqa.com/text-box");

        WebElement eFirstRow = driver.findElement(By.xpath("(//div[@class='row'])[1]"));

//        element içinde element aranabilir.
//        xpath de alt element aranirken ikinci xpath (.) (current Element) ile başlamali
//        diğer selectorler için böyle bir sarta ihtiyac yok
        eFirstRow.findElement(By.xpath("./div"));

        driver.quit();

    }

    @Test
    public void test2WriteIds() {
        driver.get("https://demoqa.com/text-box");
        By lForm = By.id("userForm");
        WebElement eForm = wait.until(ExpectedConditions.presenceOfElementLocated(lForm));

        List<WebElement> elements = eForm.findElements(By.xpath(".//input | .//textArea"));
//        List<WebElement> elements = eForm.findElements(By.cssSelector("input, textarea"));

        for (var element : elements) {
            System.out.println(element.getAttribute("id"));
        }

        driver.quit();
    }

    @Test
    public void testFillTheForm() {
        driver.get("https://demoqa.com/text-box");
        js.executeScript("window.scrollBy(0,250)");

        sendKey(lName, faker.name().firstName());
        sendKey(lEmail, faker.internet().emailAddress());
        sendKey(lCAdress, faker.address().fullAddress());
        sendKey(lPAddress, faker.address().secondaryAddress());
        click(lSubmit);


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
