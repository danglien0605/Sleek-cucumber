package stepDefinitions;

import Locators.HomePageLocators;
import Manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.HomePage;

public class HomePageStep{
  WebDriver driver;
  HomePage objHomePage;
  BasePage objBasePage;
  HomePageLocators objHomePageLocators;

  public HomePageStep() {
    driver = DriverManager.getDriver();
    objBasePage = new BasePage(driver);
    objHomePage = new HomePage(driver);
    objHomePageLocators = new HomePageLocators();
  }
  @Given("I go to the Sleek SG Home page")
  public void iGoToTheSleekSGHomePage() {
    objHomePage.openHomePage();
  }

  @When("I click on the {string} link")
  public void iClickOnTheLink(String link) {
    objBasePage.clickElement(objHomePageLocators.getXpath(link));
  }
}
