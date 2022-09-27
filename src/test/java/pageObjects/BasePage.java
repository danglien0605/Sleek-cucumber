package pageObjects;

import Manager.GlobalVariables;
import Manager.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import java.util.List;



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
        Log.INFO("navigate {}", pageName);
    }

    public void clickElement(String elementLocator) {
        WebElement element = driver.findElement(By.xpath(elementLocator));
        waitForElementClickable(elementLocator);
        element.click();
        //logger.info("Clicked on {}", elementLocator);
        Log.INFO("clicked on {}", elementLocator);
    }

    public String getTextElement(String elementLocator) {
        WebElement element = driver.findElement(By.xpath(elementLocator));
        waitForElementClickable(elementLocator);
        logger.info("Clicked on {}", elementLocator);
        return element.getText();
    }

    public void selectDropdown(String drpLocator, String option) {
        driver.findElement(By.xpath(drpLocator)).click();
        List<WebElement> allOptions = driver.findElements(By.xpath(drpLocator + "//option"));
        for (int i = 0; i <= allOptions.size() - 1; i++) {
            if (allOptions.get(i).getText().contains(option)) {
                allOptions.get(i).click();
                break;
            }
        }
    }

    public void waitForElementVisibility(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.LONG_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void enterText(String locator, String text) {
        waitForElementVisibility(locator);
        driver.findElement(By.xpath(locator)).sendKeys(text);
        Log.INFO("Entered {}", text);
    }

}
