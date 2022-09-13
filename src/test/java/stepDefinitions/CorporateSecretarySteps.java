package stepDefinitions;

import Locators.CorporateSecretaryLocators;
import Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.CorporateSecretaryPage;

import java.time.Duration;


public class CorporateSecretarySteps {
    WebDriver driver;
    CorporateSecretaryPage objCorporateSecretaryPage;
    CorporateSecretaryLocators objCorporateSecretaryLocators;
    BasePage objBasePage;

    public CorporateSecretarySteps() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objCorporateSecretaryPage = new CorporateSecretaryPage(driver);
        objCorporateSecretaryLocators = new CorporateSecretaryLocators();
        objBasePage = new BasePage(driver);
    }

    @Then("Verify corporate secretary details are correct: {string} {string}")
    public void verifyCorporateSecretaryDetailsAreCorrect(String noShareholders, String pricePerYear) {
        objCorporateSecretaryPage.verifyCorporateSecretaryDetails(pricePerYear);
    }

    @And("I select {string} in dropdown {string} on corporate secretary page")
    public void iSelectInDropdownOnCorporateSecretaryPage(String value, String drpName) {
        objCorporateSecretaryPage.selectDropdown(objCorporateSecretaryLocators.getXpath(drpName), value);
    }
}
