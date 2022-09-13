package pageObjects;

import Locators.HomePageLocators;
import Manager.DriverManager;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
	HomePageLocators objHomePageLocator;

	public HomePage(WebDriver driver){
		super(driver);
	}

	public void openHomePage (){
		this.driver = DriverManager.getDriver();
		driver.get("https://sleek.com/sg/");
		objHomePageLocator = new HomePageLocators();
	}

}
