package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenship");
    }

    @When("User creates a Citizenship name as {string} short name as {string}")
    public void userCreatesACitizenshipNameAsShortNameAs(String cn, String shortN) {
        dc.findAndClick("add_c");
        dc.findAndSend("name_c",cn);
        dc.findAndSend("shortName",shortN);
        dc.findAndClick("save_c");
    }

    @Then("Already exists message should be displayed")
    public void alreadyExistsMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already exists");
    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        dc.findAndClick("closeDialog");
    }

    @When("User deletes the {string}")
    public void userDeletesThe(String aranan) {
        dc.SearchAndDelete(aranan);
    }
}




