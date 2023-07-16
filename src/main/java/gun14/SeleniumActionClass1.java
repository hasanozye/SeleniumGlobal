package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Utils;

import java.util.List;

public class SeleniumActionClass1 extends BaseActionsClass {
    String url = "https://opencart.abstracta.us";


    @Test
    public void actions1() {
        //action class
        driver.get(url);

        By sLi1 = By.cssSelector("ul.nav > li:nth-of-type(1)");
        By sLi2 = By.cssSelector("ul.nav > li:nth-of-type(2)");
        WebElement eLi1 = driver.findElement(sLi1);
        WebElement eLi2 = driver.findElement(sLi2);

        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(eLi1)
                .pause(1000)
                .moveToElement(eLi2)
                .pause(1000)
                .build();

        action.perform();
        Utils.bekle(2000);
        driver.quit();

    }

    @Test
    public void actions2() {
        driver.get(url);
        By sLi = By.xpath("//ul[@class='nav navbar-nav']/li");
        List<WebElement> eLi = driver.findElements(sLi);

        eLi.forEach(n -> {
            new Actions(driver)
                    .moveToElement(n)
                    .build()
                    .perform();


        });
        driver.quit();
    }

    @Test
    public void actions3() {
        driver.get("https://demoqa.com/auto-complete");
        WebElement eFirstField = driver.findElement(By.id("autoCompleteMultipleContainer"));

        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(eFirstField)
                .click(eFirstField)
                .sendKeys("a")
                .pause(2000)
                .sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER))
                .build();
        action.perform();

        driver.quit();


    }

}
