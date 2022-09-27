package stepDefinitions;


import Manager.DriverManager;
import Manager.GlobalVariables;
import Manager.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;




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
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){

                Log.INFO("Scenario {} is failed", scenario.getName() );
                final byte[] screenshot  = ((TakesScreenshot ) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot  , "image/png", "Bartholomew and the Bytes of the Oobleck");
        }
      //  DriverManager.quitDriver();
    }

}
