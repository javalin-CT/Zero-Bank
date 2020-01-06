package com.zerobank.step_definitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class PayBillsStepDefs {
    @Given("The user is on the Pay Bills page")
    public void the_user_is_on_the_Pay_Bills_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        HomePage homePage = new HomePage();
        homePage.signInBtn.click();

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payBillsTab.click();
    }

    @Then("The title is Zero - Pay Bills")
    public void the_title_is_Zero_Pay_Bills() {
        PayBillsPage payBillsPage = new PayBillsPage();
        String expectedTitle = "Zero - Pay Bills";
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("The user enters valid information to complete a pay operation")
    public void the_user_enters_valid_information_to_complete_a_pay_operation() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amountInput.sendKeys("1.00");
        payBillsPage.dateInput.sendKeys("2020-01-01");
        payBillsPage.descriptionInput.sendKeys("test");
        payBillsPage.payBtn.click();

    }

    @When("The user enters no amount")
    public void the_user_enters_no_amount() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.dateInput.sendKeys("2020-01-01");
        payBillsPage.descriptionInput.sendKeys("test");
        payBillsPage.payBtn.click();


    }

    @When("The user enters no date")
    public void the_user_enters_no_date() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amountInput.sendKeys("1.00");
        payBillsPage.descriptionInput.sendKeys("test");
        payBillsPage.payBtn.click();

    }
    @When("The user enters alphabetical or special characters into the Amount field")
    public void the_user_enters_alphabetical_or_special_characters_into_the_Amount_field() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amountInput.sendKeys("A@#!B");
        payBillsPage.dateInput.sendKeys("2020-01-01");
        payBillsPage.descriptionInput.sendKeys("test");
        payBillsPage.payBtn.click();
    }
    @When("The user enters alpabetical characters into the Date field")
    public void the_user_enters_alpabetical_characters_into_the_Date_field() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amountInput.sendKeys("1.00");
        payBillsPage.dateInput.sendKeys("202A-2B-0I");
        payBillsPage.descriptionInput.sendKeys("test");
        payBillsPage.payBtn.click();
    }

    @Then("The error message should be displayed")
    public void the_error_message_should_be_displayed() throws Exception {
        PayBillsPage payBillsPage = new PayBillsPage();
        String errorMessage = payBillsPage.amountInput.getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field.";

        Assert.assertEquals(expectedMessage, errorMessage);

        if(payBillsPage.payConfirmation.isDisplayed()){
            throw new Exception("Error message should be displayed");
        }

    }

    @Then("The confirmation message should be displayed")
    public void the_confirmation_message_should_be_displayed() {
        PayBillsPage payBillsPage = new PayBillsPage();
        Assert.assertTrue(payBillsPage.payConfirmation.isDisplayed());
    }


}
