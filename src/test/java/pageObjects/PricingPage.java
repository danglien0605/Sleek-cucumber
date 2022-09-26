package pageObjects;

import Locators.PricingLocators;
import Manager.Log;
import org.openqa.selenium.WebDriver;


public class PricingPage extends BasePage{
	PricingLocators objPricingLocators;



	public PricingPage(WebDriver driver){
		super(driver);
		objPricingLocators = new PricingLocators();

	}

	public void clickButtonLearnMore(String section){
		String btn_learnMore = String.format(objPricingLocators.getXpath("btn_learn_more"), section);
		clickElement(btn_learnMore);


	}

}
