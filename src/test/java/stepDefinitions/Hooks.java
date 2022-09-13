package stepDefinitions;


import Manager.DriverManager;
import Manager.GlobalVariables;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {
    @Before
    public static void beforeScenario(){
        DriverManager.initDriver("chrome");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.LONG_TIME));
        DriverManager.getDriver().manage().window().maximize();
    }

    @After
    public void afterScenario(){
        DriverManager.quitDriver();
    }
}




//package stepDefinitions;
//
//import Manager.DriverManager;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.UnreachableBrowserException;
//
//import java.util.logging.Logger;
//
//public class Hooks {
//    private static WebDriver driver;
//    private static final Logger log = Logger.getLogger(Hooks.class.getName());
//
//    @Before
//    public synchronized static WebDriver openAndQuitBrowser() {
//        String browser = System.getProperty("BROWSER");
//        System.out.println("Browser name run by command line = " + browser);
//
//        if (driver == null) {
//                if (browser == null) {
//                    browser = System.getenv("BROWSER");
//                    if (browser == null) {
//                        browser = "chrome";
//                    }
//                }
//                DriverManager.initDriver("chrome");
//            log.info("------------- Started the browser -------------");
//        }
//        return driver;
//    }
//
//    public static void close() {
//        try {
//            if (driver != null) {
//                openAndQuitBrowser().quit();
//                log.info("------------- Closed the browser -------------");
//            }
//        } catch (UnreachableBrowserException e) {
//            System.out.println("Can not close the browser");
//        }
//    }
//
//    private static class BrowserCleanup implements Runnable {
//        @Override
//        public void run() {
//            close();
//        }
//    }
//}
