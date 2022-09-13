package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/pricing.feature",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {

}
