package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02DriverMethodlari {

    /*
        chromedriver ile
        www.saucedemo.com adresine git
        sayfanin title'ini ve currentURL'ini consola yazdir
        sayfayi kapat
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");


        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.quit();

    }

    void driverMethodlari(){
        WebDriver driver = new ChromeDriver();

        // browser verilen adrese gider. http ya da https olmalidir
        driver.get("https://www.google.com");

        // browser'in o anki title'ini return eder
        driver.getTitle();

        // browser'in o anki url'ini return eder
        driver.getCurrentUrl();

        // browser'in o anki sayfasinin kaynak html kodlarini return eder
        driver.getPageSource();

        // driver'in actigi browser'i tümü ile kapatir, birden fazla pencere acmis olsa da
        driver.quit();

        // driver'in actigi fazla pencere varsa, aktif pencereyi kapatir
        driver.close();

        // driver.get() ile ayni islemi yapar
        driver.navigate().to("https://www.google.com");

        // browser'i refresh eder
        driver.navigate().refresh();

        // geri tusuna basar
        driver.navigate().back();

        // ileri tusuna basar
        driver.navigate().forward();

        // browser'i maximize yapar
        driver.manage().window().maximize();

        // browser'i minimize yapar
        driver.manage().window().minimize();

        // browser'i fullscreen yapar. (Her isletim sistemi desteklemeyebilir)
        driver.manage().window().fullscreen();

        // browser'in boyutlarini Dimention türünden return eder
        driver.manage().window().getSize();

        // browser'in sol üst noktasini return eder
        driver.manage().window().getPosition();

        // browser'i 500x600 boyutlarinda ayarlar
        driver.manage().window().setSize(new Dimension(500, 600));

        // browser'in sol üst kösesini (10, 30) noktasina tasir
        driver.manage().window().setPosition(new Point(10,30));

        // aktif window'un ID sini return eder
        driver.getWindowHandle();

        // acik olan tüm windowlarin ID'lerini Set<String> olarak return eder
        driver.getWindowHandles();

        // window, frame, TAB, alert arasi gecisler
        driver.switchTo().frame(1);
        driver.switchTo().window("ISTNF123");
        driver.switchTo().activeElement();
        driver.switchTo().alert();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        // element bulma methodlari, "By" locator classidir

        /* driver.findElement yalniz 1 element return eder.
           element bulunmazsa hata return eder.
           By ile aranan elementten birden fazla varsa, ilkini return eder
         */
        driver.findElement(By.id("element Id"));
        driver.findElement(By.className("element className"));
        driver.findElement(By.name("element name"));
        driver.findElement(By.tagName("tagName"));
        driver.findElement(By.linkText("linkin texti"));
        driver.findElement(By.partialLinkText("linkin textinin bir kismi"));
        driver.findElement(By.cssSelector("cssSelector"));
        driver.findElement(By.xpath("xpath"));

        /* driver.findElement'e ait bazi methodlar asagidadir
         */

        //input ve textarea'ya text yazar, ya da özel karakterlere basar
        driver.findElement(By.xpath("xpath")).sendKeys("gönderilecek text");
        driver.findElement(By.xpath("xpath")).sendKeys(Keys.ENTER);

        // input ve textarea'yi temizler
        driver.findElement(By.xpath("xpath")).clear();

        // clickable olan elementlere click yapar
        driver.findElement(By.xpath("xpath")).click();

        // form da <input type="submit"> butonu varsa, submit islemi yapar
        driver.findElement(By.xpath("xpath")).submit();

        // aranan element görünür mü
        driver.findElement(By.xpath("xpath")).isDisplayed();

        // aranan element enabled mi
        driver.findElement(By.xpath("xpath")).isEnabled();

        // aranan element secili mi
        driver.findElement(By.xpath("xpath")).isSelected();

        // aranan elementin text'ini verir, texti olan elementler icin
        // ancak input, radio, checkbox, button, textarea
        // gibi form elementlerinin text'i yoktur value'si vardir
        driver.findElement(By.xpath("xpath")).getText();

        // aranan elementin istenilen attributu'unu verir
        driver.findElement(By.xpath("xpath")).getAttribute("attributeName");

        // aranan elementin  size'ini Dimension olarak verir
        driver.findElement(By.xpath("xpath")).getSize();

        // aranan elementin location'unu Point verir
        driver.findElement(By.xpath("xpath")).getLocation();


        /* driver.findElements "By" aranan tüm elementleri List olarak return eder
           element bulunmazsa hata vermez, null list return eder.
         */
        driver.findElements(By.id("element Id"));
        driver.findElements(By.className("element className"));
        driver.findElements(By.name("element name"));
        driver.findElements(By.tagName("tagName"));
        driver.findElements(By.linkText("linkin texti"));
        driver.findElements(By.partialLinkText("linkin textinin bir kismi"));
        driver.findElements(By.cssSelector("cssSelector"));
        driver.findElements(By.xpath("xpath"));


    }
}