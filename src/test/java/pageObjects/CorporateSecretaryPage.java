package pageObjects;

import Locators.CorporateSecretaryLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class CorporateSecretaryPage extends BasePage {

    CorporateSecretaryLocators objCorporateSecretaryLocators;

    public CorporateSecretaryPage(WebDriver driver) {
        super(driver);
        objCorporateSecretaryLocators = new CorporateSecretaryLocators();
    }

    public void verifyCorporateSecretaryDetails(String pricePerYear) {
        WebElement displayedValue = driver.findElement(By.xpath("//div[@id='text_new_amount']"));
        assertEquals(displayedValue.getText(), pricePerYear);

    }


}
