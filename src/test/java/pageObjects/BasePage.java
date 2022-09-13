package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    WebDriver driver;
    private static Logger logger = LogManager.getLogger(BasePage.class);
    protected static long longTime = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sleepInSecond(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollToElement(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", By.xpath(locator));
    }

    public void waitForElementClickable(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void verifyLandingPage(String pageName) {
        switch (pageName) {
            case ("Pricing"):
                assertThat(driver.getTitle(), containsString("All Services - Sleek"));
        }
    }

    public void openPage(String pageName) {
        switch (pageName) {
            case ("Pricing"):
                driver.get("https://sleek.com/sg/all-services/");
        }
        logger.info("Navigated to {}", pageName);
    }

    public void clickElement(String elementLocator) {
        WebElement element = driver.findElement(By.xpath(elementLocator));
        waitForElementClickable(elementLocator);
        element.click();
        logger.info("Clicked on {}", elementLocator);
    }

    public void selectDropdown(String drpLocator, String option) {
        String optionLocator = String.format("%s//option[text()='%s']", drpLocator, option);
        clickElement(drpLocator);
        clickElement(optionLocator);
    }

}
