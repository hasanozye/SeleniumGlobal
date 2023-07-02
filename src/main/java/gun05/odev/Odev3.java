package gun05.odev;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Odev3 extends BaseClass {
    /*
        Scenario-3
        1. https://automationexercise.com/ sayfasina gidin
        2. Menüde Products'a tiklayin
        3. Acilan sayfada Search Product inputbox'ina "Men Tshirt" send edin
        4. Input box yanindaki button'a tiklayin
        5. Arama sonucunda listelenen ürünün
             a. kodunun "Rs. 400"
             b. adinin "Men Tshirt"
           oldugunu assert edin. (AssertEquals)
     */
    String url = "https://automationexercise.com/";
    By productsButton = By.xpath("//a[text()=' Products']");
    By searchArea = By.cssSelector("div #search_product");
    By searchButton = By.cssSelector("div #submit_search");
    By displayedProduct = By.xpath("//div[@class='productinfo text-center']//h2[text()='Rs. 400']");
    By displayedProductTextArea = By.xpath("//div[@class='productinfo text-center']//p[text()='Men Tshirt']");
    @Test
    public void test03() {

        setDriver();
        navigateTo(url);
        String text = driver.findElement(displayedProduct).getText();
        String text1 = driver.findElement(displayedProductTextArea).getText();
        click(productsButton);
        sleep(3000);
        sendKeys(searchArea, "Men Tshirt");
        click(searchButton);
        Assert.assertEquals(text, "Rs. 400");
        Assert.assertEquals(text1,"Men Tshirt");


    }


}
