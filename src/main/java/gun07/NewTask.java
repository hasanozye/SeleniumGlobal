package gun07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Utils;

import java.util.List;
import java.util.Set;

public class NewTask {
    WebDriver driver;



    @Test
    public void bonigarcia1() {
        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

        By webForm = By.xpath("//a[text()='Web form']");
        WebElement link = driver.findElement(webForm);
        link.click();
        List<WebElement> elements = driver.findElements(By.xpath("//input"));
        System.out.println("elements.size() = " + elements.size());

        driver.quit();

    }

    @Test
    public void bonigarcia2(){
        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

        By webForm = By.xpath("//a[text()='Web form']");
        WebElement link = driver.findElement(webForm);
        link.click();

        By disabled = By.xpath("//input[@class='form-control' and @name='my-disabled']");

        String attribute = driver.findElement(disabled).getAttribute("class");
        String attribute2 = driver.findElement(disabled).getAttribute("type");
        String attribute3 = driver.findElement(disabled).getAttribute("placeholder");
        System.out.println("Class attribute = " + attribute);
        System.out.println("attribute2 = " + attribute2);
        System.out.println("attribute3 = " + attribute3);





    }


}
