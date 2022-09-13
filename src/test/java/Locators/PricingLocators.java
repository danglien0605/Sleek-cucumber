package Locators;

import java.util.HashMap;
import java.util.Map;

public class PricingLocators {
	public String getXpath(String key){
		Map<String, String> xpath = new HashMap<>();
		xpath.put("btn_learn_more", "//h3[text()='%s']/ancestor::div[@data-element_type='column']//a[@id='home-lets-talk']");
		return xpath.get(key);
	}

}
