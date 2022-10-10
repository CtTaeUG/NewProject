package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _02_CountrySteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to country page")
    public void navigateToCountryPage() {

        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("countries");
    }

    /*
    @When("Create a country")
    public void createACountry() {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", "ulke11");
        dc.findAndSend("codeInput", "1111");
        dc.findAndClick("savebutton");
    }

     */

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage", "success");
    }
}
