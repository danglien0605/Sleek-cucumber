package Locators;

import java.util.HashMap;
import java.util.Map;

public class CorporateSecretaryLocators {
	public String getXpath(String key){
		Map<String, String> xpath = new HashMap<>();
		xpath.put("Number of shareholders", "//select[@id='no_of_shareholders']");
		xpath.put("new_amount", "//div[@id='text_new_amount']");
		return xpath.get(key);
	}

}
