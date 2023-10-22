package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/FeatureFiles",
        glue = {"stepDefinitions", "Utilities"},
        monochrome=true,
        tags = "@newsValidation",
        plugin= {"pretty","html:target/cucumber.html"})


public class Runner extends AbstractTestNGCucumberTests {
}
