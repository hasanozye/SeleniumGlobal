package gun17.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {
        if (driver == null) {
            switch (browser) {
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }
                case SAFARI -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            }

        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }


}
