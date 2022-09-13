package pageObjects;

import Manager.GlobalVariables;
import org.openqa.selenium.WebDriver;
import utils.PropertiesReader;


public class HomePage extends BasePage {
    PropertiesReader objPropertiesReader;

    public HomePage(WebDriver driver) {
        super(driver);
        objPropertiesReader = new PropertiesReader();
    }

    public void openHomePage() {
        driver.get(GlobalVariables.URL);
    }

}
