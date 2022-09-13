package Locators;

import java.util.HashMap;
import java.util.Map;

public class HomePageLocators {
	public String getXpath(String key){
		Map<String, String> xpath = new HashMap<>();
		xpath.put("Pricing", "//div[@class='elementor-section-wrap']/section[@id='stickyheaders']//a[text()='Pricing']");
		return xpath.get(key);
	}

}
