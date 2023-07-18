package gun15;

import gun14.BaseActionsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeForm extends BaseActionsClass {


    String url = "https://demoqa.com/automation-practice-form";
    By lFirstName = By.id("firstName");
    By lLastName = By.id("lastName");
    By lEmail = By.id("userEmail");
    By lFemaleGender = By.xpath("//input[@value='Female']");
    By lMobile = By.id("userNumber");
    By lDoB = By.id("dateOfBirthInput");
    By lDoBDay = By.xpath("(//div[text()='9'])[1]");
    By lDoBMonth = By.cssSelector(".react-datepicker__month-select");
    By lDoBYear = By.cssSelector(".react-datepicker__year-select");
    By lSubjectField = By.id("subjectsContainer");
    By lHobbiesAll = By.xpath("//*[@class='custom-control custom-checkbox custom-control-inline']");
    By lAddress = By.id("currentAddress");
    By lState = By.cssSelector("#state");
    By lCity = By.cssSelector("#city");


    @Test
    public void practiceFrom01() {
        driver.get(url);

        WebElement eState = driver.findElement(lState);
        WebElement eCity = driver.findElement(lCity);
        WebElement eFemaleGender = driver.findElement(lFemaleGender);
        WebElement eSubjectField = driver.findElement(lSubjectField);

        explicitWait(lFirstName);

        sendKeysBySelenium(lFirstName, "Hasan");
        sendKeysBySelenium(lLastName, "Özyer");
        sendKeysBySelenium(lEmail, "hasanozyer08@testcococ.com");

        js.executeScript("arguments[0].scrollIntoView(true);", eFemaleGender);

        clickByActions(driver, lFemaleGender);
        sendKeysBySelenium(lMobile, "0505688555");
        clickByActions(driver, lDoB);

        explicitWait(lDoBYear);

        selectByVisibleText(lDoBMonth, "November");
        selectByValue(lDoBYear, "2003");

        clickBySelenium(lDoBDay);
        sendKeysByActions(driver, eSubjectField, "Soc");
        sendKeysByActions(driver, eSubjectField, Keys.ENTER);

        List<WebElement> elements = driver.findElements(lHobbiesAll);
        elements.forEach(WebElement::click);

        sendKeysBySelenium(lAddress, faker.address().fullAddress());

        clickByActions(driver, lState);
        sendKeysByActions(driver, eState, "Raj");
        sendKeysByActions(driver, eState, Keys.ENTER);

        clickByActions(driver, lCity);
        sendKeysByActions(driver, eCity, Keys.ENTER);

        driver.quit();

    }

    public void explicitWait(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void sendKeysBySelenium(By locator, String msg) {
        WebElement element2 = driver.findElement(locator);
        element2.clear();
        element2.sendKeys(msg);

    }

    public void clickBySelenium(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void sendKeysByActions(WebDriver driver, WebElement element, String sendTxtMsg) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        Action action = actions
                .sendKeys(sendTxtMsg)
                .build();
        action.perform();
    }

    public void sendKeysByActions(WebDriver driver, WebElement element, Keys keys) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        Action action = actions
                .sendKeys(keys)
                .build();
        action.perform();
    }

    public void clickByActions(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(element)
                .click()
                .build();
        action.perform();
    }

    public void clickByJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void selectByVisibleText(By locator, String visibleTextMsg) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleTextMsg);
    }

    public void selectByValue(By locator, String visibleValue) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByValue(visibleValue);
    }

}
