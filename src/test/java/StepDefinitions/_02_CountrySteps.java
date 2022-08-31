package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("countries");
    }
    @When("Create a country")
    public void createACountry() {
        String randomGenName = RandomStringUtils.randomAlphabetic(8);
        String randomGenCode = RandomStringUtils.randomNumeric(4);

        dc.findAndClick("add_c");
        dc.findAndSend("name_c",randomGenName);
        dc.findAndSend("code_c", randomGenCode);
        dc.findAndClick("save_c");
    }
    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","successfully");
    }
    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {

        dc.findAndClick("add_c");
        dc.findAndSend("name_c", name);
        dc.findAndSend("code_c", code);
        dc.findAndClick("save_c");

    }
}
