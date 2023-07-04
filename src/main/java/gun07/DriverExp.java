package gun07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverExp {

    WebDriver driver;

    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


    @Test
    public void test01(){
        driver = getDriver();

        driver.get("https://");

        driver.getCurrentUrl();

        driver.manage().window().maximize();

        driver.manage().window().minimize();

        //pencerenin sol üst köşe noktasi, soldan 10, yukaridan 20 birim aşağida
        driver.manage().window().setPosition(new Point(10,20));

        //Window site 500x600, width x height
        driver.manage().window().setSize(new Dimension(500,600));

//        driver.findElement();
        By.id("");
        By.name("");
        By.className("");

        By.linkText("");
        By.partialLinkText("Railly");

        By.cssSelector("");
        By.xpath("");

        //action
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).clear();
        driver.findElement(By.id("")).sendKeys("text");

        //conditions
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isSelected();
        driver.findElement(By.id("")).isEnabled();

        //bilgi
        driver.findElement(By.id("")).getText();














    }


}
