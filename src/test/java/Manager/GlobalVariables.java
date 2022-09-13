package Manager;


import utils.PropertiesReader;

public class GlobalVariables {
    public static final long LONG_TIME = 30;
    public static final String BROWSER_NAME = PropertiesReader.getInstance().getBrowser();
    public static final String URL = PropertiesReader.getInstance().getApplicationUrl();

}
