package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                "src/test/java/FeatureFiles/_02_Country.feature"},
        glue = {"StepDefinitions"},
        dryRun = false // testi calistirir.
        // dryRun = true olduğunda ise sadece feature lara ait stepleri check eder.


)
public class _02_SpecificFeatureFiles extends AbstractTestNGCucumberTests {
}
