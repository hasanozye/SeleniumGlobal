package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SeleniumActionClass2 extends BaseActionsClass {

    String url = "https://www.snapdeal.com/";
    By lSearchBox = By.id("inputValEnter");
    By lFirstWatch = By.id("652415109752");
    By lImg = By.id("bx-slider-left-image-panel");

    @Test
    public void actionPractice() {
        driver.get(url);

        WebElement eSearchBox = driver.findElement(lSearchBox);

        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(eSearchBox)
                .click()
                .sendKeys("watch")
                .sendKeys(Keys.ENTER)
                .build();
        action.perform();

        WebElement eFirstWatch = driver.findElement(lFirstWatch);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lFirstWatch));
        js.executeScript("arguments[0].scrollIntoView();", eFirstWatch);
        new Actions(driver).click(eFirstWatch).build().perform();

        String mainWin = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (var n : windowHandles) {
            if (!n.equalsIgnoreCase(mainWin)) {
                driver.switchTo().window(n);
                break;
            }
        }


        WebElement eImg = driver.findElement(lImg);
        /*hoverActions(eImg, -50, -20);
        hoverActions(eImg, -20, -10);
        hoverActions(eImg, 0, 0);
        hoverActions(eImg, 20, 20);
        hoverActions(eImg, 50, 50);*/

        int height = eImg.getSize().height;
        for (int i = -height / 2; i < height / 2; i+=50) {
            hoverActions(eImg, 0, i);

        }

        driver.quit();


    }

    public void hoverActions(WebElement element, int xOffSet, int yOffSet) {
        new Actions(driver)
                .moveToElement(element, xOffSet, yOffSet)
                .pause(Duration.ofSeconds(2))
                .build()
                .perform();
    }

}
