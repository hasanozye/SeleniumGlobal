package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class _03Assert {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        // Assert TestNG'nin parcasidir
        // Assert false return ederse message ekrana yazilir ve Assertion Exception firlatilir
        // Assert false return ederse cikti olarak hic birsey üretmez.
        Assert.assertEquals(driver.getTitle(), "Swag Labs11", "Hata Mesaji");

        // yukaridaki Assert ile yapilan bir ölcüde asagidaki kontrol islemidir.
        if (!driver.getTitle().equals("Swag Labs")){
            throw new AssertionError("Hata Mesaji");
        }

        driver.quit();
    }


    void assertAciklamalari(){

        // Assert bir textNG ya da jUnit methodudur

        // condition'un true olmasi beklenir
        Assert.assertTrue(true);
        Assert.assertTrue(true, "Conditionun False olmasi durumunda mesaj");

        // condition'un false olmasi beklenir
        Assert.assertFalse(false);
        Assert.assertFalse(false, "Conditionun True olmasi durumunda mesaj");

        // degerlerin esit olmasi beklenir
        Assert.assertEquals(1,1);
        Assert.assertEquals(1,1,"Degerlerin esit olmamasi durumunda mesaj");

        // direkt Assertion error firlatir
        Assert.fail();

        // degerlerin farkli olmasi beklenir
        Assert.assertNotEquals(1,2);
        Assert.assertNotEquals(1,2, "Degerlerin esit olmasi durumunda mesaj");

        // Obje'nin null olmamasi beklenir
        Assert.assertNotNull(new Object());
        Assert.assertNotNull(new Object(), "Objenin Null olmasi drumunda mesaj");

        // iki objenin ayni olmasi beklenir
        Assert.assertSame(new Object(), new Object());
        Assert.assertSame(new Object(), new Object(), "Farkli obje olmalari durumunda mesaj");

        // iki objenin ayni olmamasi beklenir
        Assert.assertNotSame(new Object(), new Object());
        Assert.assertNotSame(new Object(), new Object(), "Ayni obje olmalari durumunda mesaj");
    }
}