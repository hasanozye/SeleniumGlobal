package gun08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class _02ImplicitlyWait {

    WebDriver driver;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void loadingImg() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        By loadingImg = By.xpath("//*[text()='Loading images']");
        WebElement loadingImgElement = driver.findElement(loadingImg);
        loadingImgElement.click();
        By pustularImg = By.id("compass");
        WebElement pustularImgElement = driver.findElement(pustularImg);
        Assert.assertTrue(pustularImgElement.isDisplayed());

        driver.quit();

//        istenilen element geç olujştuğu için driver.findElement() hata verir.
//


        /*
         * Seleniumda 2 tür bekleme var
         * 1. Imlplicit Wait
         * driver'a aittir, driver'da belirtilir.
         * driver.findElement ile aranan tüm elementler oluşuncaya(create) kadar standart bekleme süresidir.
         * driver element buluncaya kadar ya da maximum bekleme süresince bekler
         * bu bekleme süresi içinde elementi bulan ise hata verir:
         * 2. Explicit Wait
         * elemente aittir, driver yürütür
         * element visible oluncaya kadar, rengi kirmizi oluncaya kadar, invisible oluncaya kadar gibi özellikler için*/


    }

    @Test
    public void loadingImgWithWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        By loadingImg = By.xpath("//*[text()='Loading images']");
        WebElement loadingImgElement = driver.findElement(loadingImg);
        loadingImgElement.click();

//        Implicitly wait sadece elementin precesence olmasını max belirtilen süre kadar bekler.
//        tüm driver.findElement işlem iiçin standart bekleme süresidir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By pustularImg = By.id("landscape");
        WebElement pustularImgElement = driver.findElement(pustularImg);
        Assert.assertTrue(pustularImgElement.isDisplayed());

        driver.quit();

    }


    @Test
    public void ajaxData(){
        driver.get("http://www.uitestingplayground.com/");
        By ajaxData = By.xpath("//*[text()='AJAX Data']");
        WebElement ajaxDataElement = driver.findElement(ajaxData);
        ajaxDataElement.click();

        By ajaxButton = By.cssSelector("#ajaxButton");
        WebElement ajaxButtonElement = driver.findElement(ajaxButton);
        ajaxButtonElement.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        By verifyAjax = By.xpath("//*[text()='Data loaded with AJAX get request.']");
        WebElement verifyAjaxElement = driver.findElement(verifyAjax);
        String verifyAjaxCss =verifyAjaxElement.getCssValue("background-color");
        String hexValue = Color.fromString(verifyAjaxCss).asHex();

        Assert.assertEquals(hexValue,"#28a745","the hex values are not equal!");

        driver.quit();



    }









}
