package pageObjects;

import Locators.CorporateSecretaryLocators;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CorporateSecretaryPage extends BasePage {

    CorporateSecretaryLocators objCorporateSecretaryLocators;

    public CorporateSecretaryPage(WebDriver driver) {
        super(driver);
        objCorporateSecretaryLocators = new CorporateSecretaryLocators();
    }

    public void verifyCorporateSecretaryDetails(String pricePerYear) {
        String displayedValue = getTextElement(objCorporateSecretaryLocators.getXpath("new_amount"));
        assertEquals(displayedValue, pricePerYear);

    }


}
