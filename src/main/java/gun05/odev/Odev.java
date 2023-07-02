package gun05.odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Odev extends BaseClass {

    @Test
    public void scenario_1() {
        /*
        Scenario-1
            1.  sayfasina gidin
            2. "Location for this session:" altinda bulunan kutu icindeki 6 adet linke aralarda 1 sn bekleme vererek tiklayin
         */
        String url = "https://demo.openmrs.org/openmrs/login.htm";
        By link1 = By.cssSelector("#sessionLocation [id='Inpatient Ward']");
        By link2 = By.cssSelector("#sessionLocation [id='Isolation Ward']");
        By link3 = By.cssSelector("#sessionLocation [id='Laboratory']");
        By link4 = By.cssSelector("#sessionLocation [id='Outpatient Clinic']");
        By link5 = By.cssSelector("#sessionLocation [id='Pharmacy']");
        By link6 = By.cssSelector("#sessionLocation [id='Registration Desk']");


        setDriver();
        navigateTo(url);
        click(link1);
        System.out.println(element.getText());
        System.out.println(element.getSize());
        System.out.println(element.getLocation());
        sleep(1000);
        click(link2);
        sleep(1000);
        click(link3);
        sleep(1000);
        click(link4);
        sleep(1000);
        click(link5);
        sleep(1000);
        click(link6);
        quitDriver();

    }

    @Test
    public void test2FindElements() {
        String url = "https://demo.openmrs.org/openmrs/login.htm";
        By linklerLocator = By.xpath("//ul/li");
        setDriver();
        navigateTo(url);

        List<WebElement> linkler = driver.findElements(linklerLocator);

        for (WebElement webElement : linkler) {
            webElement.click();
            sleep(1000);
        }

        quitDriver();

    }

    /*
    driver.findElement                                                    driver.findElements
    locator ile 1 element return eder                                     locator ile tüm elementleri return eder
    elementi bulamaz ise hata verir                                       element yoksa hata vermez, null list return eder
     */

    @Test
    public void test2FindElements2() {
        String url = "https://demo.openmrs.org/openmrs/login.htm";
        By linklerLocator = By.xpath("//ul/li");

        setDriver();
        navigateTo(url);
        List<WebElement> linkler = driver.findElements(linklerLocator);

        if (linkler.size()>0){
            linkler.get(0).click();
        }

        sleep(3000);
        quitDriver();

    }

    @Test
    public void test2FindElements3() {
        String url = "https://demo.openmrs.org/openmrs/login.htm";
        By linklerLocator = By.xpath("//ul/li");

        setDriver();
        navigateTo(url);
        List<WebElement> linkler = driver.findElements(linklerLocator);

        linkler
                .stream()
                .filter(e->e.getText().toLowerCase().contains("o"))
                .collect(Collectors.toList())
                .forEach(e-> System.out.println(e.getText()));

        sleep(3000);
        quitDriver();

    }


}
