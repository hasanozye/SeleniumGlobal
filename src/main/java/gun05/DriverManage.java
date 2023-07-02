package gun05;

import gun05.odev.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

public class DriverManage extends BaseClass {
    String url = "https://demoblaze.com/";

    @Test
    public void driverManage() {
        setDriver();
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());

        driver.manage().window().maximize();
        navigateTo(url);
        sleep(2000);
        driver.manage().window().minimize();
        sleep(2000);
        quitDriver();

    }

    @Test
    public void driverManageSet() {
        setDriver();
        driver.manage().window().setPosition(new Point(100, 10));
        driver.manage().window().setSize(new Dimension(500, 700));

        navigateTo(url);

        sleep(2000);
        quitDriver();

    }

    @Test
    public void driverNavigate() {
        setDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demowebshop.tricentis.com/login"); //driver.get(url)
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        sleep(2000);
        driver.navigate().back();
        sleep(2000);
        driver.navigate().forward();
        sleep(2000);
        driver.navigate().refresh();
        sleep(2000);
        quitDriver();

    }


}
