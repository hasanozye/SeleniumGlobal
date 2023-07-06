package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class _03ExplicitWait {
    WebDriver driver;
    WebDriverWait wait;     //explicit wait için kullanılacak

    @Test
    public void dialogProcess(){
        driver = Utils.getChromeDriver();

//        Bu wait işlemini driver yapacak, bekleme süresi 10 sn.
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showSmallModal")).click();

//        driver.findElement(By.id("closeSmallModal")).click();

//        locator'a verilen element visible oluncaya kadar bekle
//        sonucta WebElement return eder, o nedenle .click emthodu kullanılabilir.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeSmallModal"))).click();

//        locator'ı verilen elementing invisible olmasını bbekler.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("closeSmallModal")));

        driver.quit();



    }


}

/*
* ELEMENTE ÖZEL DURUMLAR İÇİN BKELEME SÜRESİ
* ayri bir WebDriverWait ranimlanir.
* Element durumlari, (WebElement, By)
* visible
* clickable
* attribute
* invisible
* element size
* .....
*
*
* Eğer hem implict wait hem explicit wait beraber kullanılırsa,
* element presence olmama durumunda cok fazla bekleme süresi olur.
* Önce implicit wait calisir sonra explicit wait calisir.
*
* wait.Until(ExpectedConditions.presenceOfElementLocated(By)) ->Implicit wait gibi
* wait.Until(ExpectedConditions.presenceOfElementLocated(WebElement)) ->Implicit wait gibi
* */
