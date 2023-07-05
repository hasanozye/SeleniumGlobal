package gun07;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class DropDown {

    WebDriver driver;

    @Test
    public void select1(){

        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

        By linkWebForm = By.linkText("Web form");
        driver.findElement(linkWebForm).click();



        By select = By.name("my-select");
        driver.findElement(select).click();
        Utils.bekle(3000);
        driver.quit();
    }

    @Test
    public void select2(){

        driver = Utils.getChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

        By linkWebForm = By.linkText("Web form");
        driver.findElement(linkWebForm).click();



        By select = By.name("my-select");
        Select selectMenu = new Select(driver.findElement(select));
        selectMenu.selectByIndex(1);
        Utils.bekle(1000);
        selectMenu.selectByVisibleText("Three");
        Utils.bekle(1000);
        selectMenu.selectByValue("2");

        for (WebElement option : selectMenu.getOptions()){
            System.out.println("Value: "+ option.getAttribute("value") + ", Text:" + option.getText());
        }

        Utils.bekle(2000);
        driver.quit();

    }

    @Test
    public void ebay(){
        driver = Utils.getChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        By search = By.xpath("//select[@aria-label='Select a category for search']");
        WebElement searchElement = driver.findElement(search);

        Select select = new Select(searchElement);
        select.selectByVisibleText("Baby");
        Utils.bekle(2000);

        By submitBtn = By.xpath("//input[@type='submit']");
        WebElement submitBtnElement = driver.findElement(submitBtn);
        submitBtnElement.click();

        By babyAssert = By.xpath("//span[text()='Baby' and ./ancestor::a[@class='seo-breadcrumb-text']]");
        WebElement babyAssertElement = driver.findElement(babyAssert);

        Assert.assertEquals(babyAssertElement.getText(),"Baby");

        driver.quit();

    }

    @Test
    public void toolsQA(){

        driver = Utils.getChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;


        By alertPage = By.xpath("(//div[@class='avatar mx-auto white'])[3]");
        WebElement alertPageElement = driver.findElement(alertPage);
        js.executeScript("window.scrollBy(0,500)");
        alertPageElement.click();


        Utils.bekle(2000);
        js.executeScript("window.scrollBy(0,500)");
        By modalDialogs = By.xpath("//*[text()='Modal Dialogs']");
        WebElement modalDialogsElement = driver.findElement(modalDialogs);
        modalDialogsElement.click();

        By smallModal = By.cssSelector("#showSmallModal");
        WebElement smallModalElement = driver.findElement(smallModal);
        smallModalElement.click();
        Utils.bekle(2000);

        By textSmallModal = By.xpath("//*[text()='This is a small modal. It has very less content']");
        WebElement textSmallModalElement = driver.findElement(textSmallModal);
        String textStringModalElement = textSmallModalElement.getText();
        Assert.assertEquals(textStringModalElement,"This is a small modal. It has very less content");


        By closeBtn = By.cssSelector("#closeSmallModal");
        WebElement closeBtnElement = driver.findElement(closeBtn);
        closeBtnElement.click();

        Utils.bekle(2000);
        try{
            Assert.assertFalse(closeBtnElement.isDisplayed(),"it is displayed");
        }catch(Exception e){
            System.out.println("The window is closed.");

        }

        driver.quit();






    }

}
