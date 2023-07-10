package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class _01Wait1 extends BaseGun10{


    @Test
    public void test1(){
        driver.get("http://opencart.abstracta.us/");

        By lMyAccount =By.xpath("//a//span[.='My Account']");
        By lLoginLink = By.xpath("//a[text()='Login']");
        By lEmail = By.id("input-email");
        By lPassword = By.id("input-password");
        By lLoginButton = By.xpath("//input[@value='Login']");

        click(lMyAccount);

        waitForVisibilityOf(lLoginLink);
        click(lLoginLink);

        sendKeys(lEmail,"deneme@deneme.com");
        sendKeys(lPassword,"deneme");

        click(lLoginButton);

        waitForVisibilityOf(By.xpath("//aside//a[text()='Logout']"));

        driver.quit();


    }

    @Test
    public void test2(){

    }

}
