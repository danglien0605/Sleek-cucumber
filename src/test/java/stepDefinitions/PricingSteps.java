package stepDefinitions;

import Locators.PricingLocators;
import Manager.DriverManager;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import java.time.Duration;

public class PricingSteps{
    WebDriver driver;
    PricingPage objPricingPage;
    PricingLocators objPricingLocators;
    BasePage objBasePage;

    public PricingSteps() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objPricingPage = new PricingPage(driver);
        objPricingLocators = new PricingLocators();
        objBasePage = new BasePage(driver);
    }


    @When("I click learn more button for {string} on pricing page")
    public void iClickLearnMoreButtonFor(String section) {
        objPricingPage.clickButtonLearnMore(section);
    }
}
