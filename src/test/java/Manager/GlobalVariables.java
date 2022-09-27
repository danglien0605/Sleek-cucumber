package Manager;


import utils.PropertiesReader;

public class GlobalVariables {
    public static final long LONG_TIME = 30;
    public static final String BROWSER_NAME = PropertiesReader.getInstance().getBrowser();
    public static final String URL = PropertiesReader.getInstance().getApplicationUrl();
    public static final String EXCEL_PATH = PropertiesReader.getInstance().getValue("excel_path");
    public static final String EXCEL_SHEET = PropertiesReader.getInstance().getValue("excel_sheet");

}
