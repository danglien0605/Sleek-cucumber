package stepDefinitions;


import Manager.DriverManager;
import Manager.GlobalVariables;
import Manager.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;



import java.time.Duration;

public class Hooks {

    @Before
    public static void beforeScenario(){
        Log.info("----------------------START TEST------------------");
        DriverManager.initDriver(GlobalVariables.BROWSER_NAME);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.LONG_TIME));
        DriverManager.getDriver().manage().window().maximize();
    }

    @After
    public void afterScenario(){
        DriverManager.quitDriver();
    }

}
