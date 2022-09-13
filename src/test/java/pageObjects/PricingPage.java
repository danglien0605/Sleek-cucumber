package pageObjects;

import Locators.PricingLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class PricingPage extends BasePage{
	PricingLocators objPricingLocators;
	private static Logger logger = LogManager.getLogger(BasePage.class);

	public PricingPage(WebDriver driver){
		super(driver);
		objPricingLocators = new PricingLocators();
	}

	public void clickButtonLearnMore(String section){
		String btn_learnMore = String.format(objPricingLocators.getXpath("btn learn more"), section);
		clickElement(btn_learnMore);
		logger.info("Clicked on Learn More button at {}",section);

	}

}
