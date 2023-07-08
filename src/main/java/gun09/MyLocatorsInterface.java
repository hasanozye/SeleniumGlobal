package gun09;

import org.openqa.selenium.By;

public interface MyLocatorsInterface {
    By lName = By.cssSelector("#userName");
    By lEmail = By.id("userEmail");
    By lCAdress = By.cssSelector("#currentAddress");
    By lPAddress = By.id("permanentAddress");
    By lSubmit = By.id("submit");

}
