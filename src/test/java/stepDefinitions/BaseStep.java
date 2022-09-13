package stepDefinitions;

import Manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import pageObjects.*;

public class BaseStep {
  WebDriver driver;
  BasePage objBasePage;

  public BaseStep() {
    driver = DriverManager.getDriver();
    objBasePage = new BasePage(driver);

  }

  @Given("I am on the Sleek SG {string} page")
  public void iAmOnTheSleekSGPage(String pageName) {
   objBasePage.openPage(pageName);

  }

  @Then("I should be navigated to the Sleek SG {string} page")
  public void iShouldBeNavigatedToTheSleekSGPage(String pageName) {
    objBasePage.verifyLandingPage(pageName);
  }

}
