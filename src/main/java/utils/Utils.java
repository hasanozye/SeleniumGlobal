package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    public static void bekle(long milis) {
        try {
            Thread.sleep(milis);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
