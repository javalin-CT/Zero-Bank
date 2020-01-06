package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityNavigationPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefs {
    @Given("The user is logged in")
    public void the_user_is_logged_in() {
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

    }

    @When("the user clicks on Savings link on the Account Summary Page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_Page() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        page.firstSavingsLink.click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.get().getTitle().equals("Zero - Account Activity"));
    }

    @Then("Account drop down should have savings selected")
    public void account_drop_down_should_have_savings_selected() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        String actualFirstOption = page.dropDownSavings.getText();
        String expectedFirstOption = "Savings";

        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        page.brokerageLink.click();
    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        String actualFirstOption = page.dropDownBrokerage.getText();
        String expectedFirstOption = "Brokerage";
        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        page.checkingLink.click();
    }

    @Then("Account drop down should have checking selected")
    public void account_drop_down_should_have_checking_selected() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        String actualFirstOption = page.dropDownChecking.getText();
        String expectedFirstOption = "Checking";

        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on Credit card link on the Account Summary Page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_Page() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        page.creditCardLink.click();
    }


    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        String actualFirstOption = page.dropDownCreditCard.getText();
        String expectedFirstOption = "Credit Card";

        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        page.loanLink.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        AccountActivityNavigationPage page = new AccountActivityNavigationPage();
        String actualFirstOption = page.dropDownLoan.getText();
        String expectedFirstOption = "Loan";

        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }
}
