package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.SendEmail;

import java.util.Set;

public class SendEmailSteps extends BasePage {

    SendEmail SingleEmail = new SendEmail(driver);

    @Given("I click on staff emails button")
    public void iClickOnStaffEmailsButton() throws InterruptedException {
        SingleEmail.ClickOnStaffEmailsButton();
    }

    /*@And("I close amy mail alert popup")
    public void iCloseAmyMailAlertPopup() throws InterruptedException {
        SingleEmail.CloseAmyMailAlert();
    }*/

    @When("I click on compose button")
    public void iClickOnComposeButton() throws InterruptedException {
        SingleEmail.ClickOnComposeButton();
    }

    @And("I click on single email button")
    public void iClickOnSingleEmailButton() throws InterruptedException {
        SingleEmail.ClickOnSingleEmailButton();
    }

    @And("I enter {string} in the To field")
    public void iEnterInTheToField(String emailid) throws InterruptedException {
        SingleEmail.EnterToAddress(emailid);
    }


    @And("I click on send button")
    public void iClickOnSendButton() throws InterruptedException {
        SingleEmail.ClickOnSendButton();
    }

    @And("I click on send button in the popup")
    public void iClickOnSendButtonInThePopup() {

    }

    @Then("I should see email is sent successfully")
    public void iShouldSeeEmailIsSentSuccessfully() {
    }

}
