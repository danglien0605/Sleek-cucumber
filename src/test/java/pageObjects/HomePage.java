package pageObjects;

import Manager.GlobalVariables;
import org.openqa.selenium.WebDriver;
import utils.ExcelHelper;
import utils.PropertiesReader;


public class HomePage extends BasePage {
    PropertiesReader objPropertiesReader;
    ExcelHelper excelHelper;
    private String sheetName = "HomePage";

    public HomePage(WebDriver driver) {
        super(driver);
        objPropertiesReader = new PropertiesReader();
        excelHelper = new ExcelHelper();

    }

    public void openHomePage() {
        driver.get(GlobalVariables.URL);
    }

    public void enterTextFromExcelFile (String locator, String columnName ){
        excelHelper.setExcelFile(GlobalVariables.EXCEL_PATH, sheetName);
        enterText(locator, excelHelper.getCellData(columnName, 1));

    }

}
