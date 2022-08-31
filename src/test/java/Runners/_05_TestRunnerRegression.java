package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // or olduğunda herhangi bir tanesi varsa;
        // and olduğunda her ikisinin de bulundugu senaryoları çalıştırır.

        tags = "@Regression or @SmokeTest", // hangi senaryolarda varsa
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}  // Browser tipi vermek için, rapora ek parametre eklemek için sonra kullanacağız
