package pageObjects;

import Manager.GlobalVariables;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.time.Duration;


public class BasePage {

    WebDriver driver;
    PropertiesReader objPropertiesReader;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        objPropertiesReader = new PropertiesReader();
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
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.LONG_TIME));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void verifyLandingPage(String pageName) {
        if ("Pricing".equals(pageName)) {
            assertThat(driver.getTitle(), containsString("All Services - Sleek"));
        }
    }

    public void openPage(String pageName) {
        driver.get(objPropertiesReader.getApplicationUrl(pageName));
        logger.info("Navigated to {}", pageName);
    }

    public void clickElement(String elementLocator) {
        WebElement element = driver.findElement(By.xpath(elementLocator));
        waitForElementClickable(elementLocator);
        element.click();
        logger.info("Clicked on {}", elementLocator);
    }

    public String getTextElement(String elementLocator) {
        WebElement element = driver.findElement(By.xpath(elementLocator));
        waitForElementClickable(elementLocator);
        logger.info("Clicked on {}", elementLocator);
        return element.getText();
    }

    public void selectDropdown(String drpLocator, String option) {
        Select se = new Select(driver.findElement(By.xpath(drpLocator)));
        se.selectByVisibleText(option);
        logger.info("Selected option: {}", option);
    }

}
