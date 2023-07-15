package gun13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowSwitchTo {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public WindowSwitchTo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }


    String url = "https://demoqa.com/browser-windows";
    By lTabButton = By.id("tabButton");
    By lWindowButton = By.id("windowButton");
    By lText = By.id("sampleHeading");

    @Test
    public void switchToWin1() {
        driver.get(url);
        driver.findElement(lTabButton).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWin = driver.getWindowHandle();
        Set<String> wins = driver.getWindowHandles();


        wins.forEach(n -> {
            if (!n.equalsIgnoreCase(mainWin)) {
                driver.switchTo().window(n);

            }
        });
        /*for (String win : wins) {
            if (!win.equalsIgnoreCase(mainWin)) {
                driver.switchTo().window(win);
                break;
            }
        }*/
        System.out.println(driver.findElement(lText).getText());

        driver.close(); //pencereyi kapatır
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));

        /*
        wait.until(driver -> {
            try {
                driver.findElement(lText);
                return false;
            } catch (Exception e) {
                return true;
            }
        });

         */
        /*
        if (driver.findElements(lText).size()<= 0){

        }
         */

        /*
        try {
            driver.findElement(lText);
            System.err.println("Hata");
            System.exit(1);
        } catch (Exception ignored) {

        }
         */


        driver.switchTo().window(mainWin);
        driver.findElement(lTabButton).click();

        Utils.bekle(2000);


        driver.quit();


    }

    @Test
    public void switchToWin2() {
        driver.get(url);
        driver.findElement(lWindowButton).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWin = driver.getWindowHandle();
        Set<String> wins = driver.getWindowHandles();
        for (String win : wins) {
            if (!win.equalsIgnoreCase(mainWin)) {
                driver.switchTo().window(win);
                break;
            }
        }

        System.out.println(driver.findElement(lText).getText());

        driver.close();

        wait.until(n -> {
            if (driver.getWindowHandles().size() == 1) {
                return true;
            } else {
                return false;
            }
        });
        driver.switchTo().window(mainWin);

        driver.quit();

    }

    By lMyAccountLogoO = By.xpath("//a[@title='My Account']");
    By lLoginLogoO = By.xpath("//a[text()='Login']");
    By lEmailO = By.id("input-email");
    By lPasswordO = By.id("input-password");
    By lLoginBtnO = By.xpath("//input[@value='Login']");
    By lAddressBook = By.xpath("//li//a[text()='Address Book']");
    By lNewAddress = By.xpath("//a[text()='New Address']");
    By lFirstName = By.id("input-firstname");
    By lLastName = By.id("input-lastname");
    By lCompany = By.id("input-company");
    By lAddress = By.id("input-address-1");
    By lCity = By.id("input-city");
    By lPostCode = By.id("input-postcode");
    By lCountry = By.id("input-country");
    By lRegion = By.id("input-zone");
    By lRadioBtnYes = By.xpath("//input[@value='1']");
    By lContinueBtn = By.xpath("//input[@value ='Continue']");
    By lSuccessfulAddressText = By.xpath("//*[text()=' Your address has been successfully added']");

    @Test
    public void openCartUs() {
        driver.get("https://opencart.abstracta.us/");
        driver.findElement(lMyAccountLogoO).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginLogoO));
        driver.findElement(lLoginLogoO).click();
        driver.findElement(lEmailO).sendKeys("deneme@deneme.com");
        driver.findElement(lPasswordO).sendKeys("deneme");
        driver.findElement(lLoginBtnO).click();
        Assert.assertEquals(driver.getTitle(), "My Account");
        driver.findElement(lAddressBook).click();

        WebElement eNewAddress = driver.findElement(lNewAddress);
        js.executeScript("arguments[0].scrollIntoView();", eNewAddress);
        eNewAddress.click();

        driver.findElement(lFirstName).sendKeys("Hasan");
        driver.findElement(lLastName).sendKeys("Özyer");
        driver.findElement(lCompany).sendKeys("AbroadCompany");
        driver.findElement(lAddress).sendKeys("Çukurambar Next Level Ofis");
        driver.findElement(lCity).sendKeys("Ankara");
        driver.findElement(lPostCode).sendKeys("06600");

        WebElement eRegion = driver.findElement(lRegion);
        WebElement eCountry = driver.findElement(lCountry);
        js.executeScript("arguments[0].scrollIntoView(true);", eRegion);

        Select countrySelect = new Select(eCountry);
        countrySelect.selectByVisibleText("Macau");

        Utils.bekle(1000);

        eRegion.click();
        eRegion.sendKeys("Cathet"+ Keys.ENTER);

        driver.findElement(lRadioBtnYes).click();
        driver.findElement(lContinueBtn).click();

        Assert.assertEquals(driver.findElement(lSuccessfulAddressText).getText(),"Your address has been successfully added");

        driver.quit();





    }


}
