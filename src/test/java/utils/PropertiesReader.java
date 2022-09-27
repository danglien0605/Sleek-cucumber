package utils;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader propertiesReader;
    private Properties properties;
    private final String propertyFilePath= "src/test/resources/appconfig.properties";

    public static PropertiesReader getInstance(){
        if (propertiesReader == null)
            propertiesReader = new PropertiesReader();
        return propertiesReader;
    }

    public PropertiesReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("browser not specified in the appconfig.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the appconfig.properties file.");
    }

    public String getApplicationUrl(String urlName) {
        String url = properties.getProperty(urlName);
        if(url != null) return url;
        else throw new RuntimeException(urlName + " not specified in the appconfig.properties file.");
    }

    public String getValue(String key){
        String value = properties.getProperty(key);
        if(value != null) return value;
        else throw new RuntimeException(key + " not specified in the appconfig.properties file.");
    }

}
