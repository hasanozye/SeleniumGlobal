package gun05.odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev2 extends BaseClass {

    @Test
    public void odev2() {
        /*
            Scenario-2
            1. https://demoblaze.com/  sayfasina gidin
            2. "Log in" butonuna tiklayin
            3. Dialog icindeki "Log in" butonunun visible oldugunu assert edin.
            5. "x" butonu ile dialog'u kapatin
            6. Dialogun kapandigini "Close" butonunun visibility'sine bakarak assert edin
         */
        String url = "https://demoblaze.com/";
        setDriver();
        navigateTo(url);


        By loginLink = By.xpath("//div[@id='navbarExample']//a[text()='Log in']");
        click(loginLink);

        By dialogLoginButton = By.xpath("//div[@id='logInModal']//button[text()='Log in']");
        sleep(1000);
        Assert.assertTrue(driver.findElement(dialogLoginButton).isDisplayed());

        By xButton = By.cssSelector("#logInModal span");
        click(xButton);
        sleep(100);
        Assert.assertFalse(driver.findElement(xButton).isDisplayed());

        By closeButton = By.xpath("//div[@id='logInModal']//button[text()='Close']");
        Assert.assertFalse(driver.findElement(closeButton).isDisplayed());


    }


}
