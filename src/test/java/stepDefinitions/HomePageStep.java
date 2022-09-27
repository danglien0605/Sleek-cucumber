package stepDefinitions;

import Locators.HomePageLocators;
import Manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.HomePage;
import  Manager.Log;

public class HomePageStep{
  WebDriver driver;
  HomePage objHomePage;
  BasePage objBasePage;
  HomePageLocators objHomePageLocators;
  Log logger;

  private final String CONTEXT = "home page";

  public HomePageStep() {
    driver = DriverManager.getDriver();
    objBasePage = new BasePage(driver);
    objHomePage = new HomePage(driver);
    objHomePageLocators = new HomePageLocators();
    logger = new Log();
  }
  @Given("I go to the Sleek SG Home page")
  public void iGoToTheSleekSGHomePage() {
    objHomePage.openHomePage();
  }

  @When("I click on the {string} link")
  public void iClickOnTheLink(String link) {
    objBasePage.clickElement(objHomePageLocators.getXpath(link));


  }

  @When("I enter data from excel file into {string} field on " + CONTEXT)
  public void iEnterDataFromExcelFileIntoFieldOnHomePage(String fieldName) {
    objHomePage.enterTextFromExcelFile(objHomePageLocators.getXpath(fieldName), "company name");

  }
}
