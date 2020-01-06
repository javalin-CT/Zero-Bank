package com.zerobank.step_definitions;

import com.google.common.collect.Ordering;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindTransactionsStepDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
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

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.accountActivityTab.click();

        accountActivityPage.findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        FindTransactionsPage page = new FindTransactionsPage();
        page.fromDateInput.sendKeys(fromDate);
        page.toDateInput.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
       FindTransactionsPage page = new FindTransactionsPage();
       page.submitBtn.click();
    }

    @Then("the results table should show only transaction dates between {string} to {string}")
    public void the_results_table_should_show_only_transaction_dates_between_to(String fromDate, String toDate) {
        FindTransactionsPage page = new FindTransactionsPage();

        for(String each : page.datesDisplayed()){
            page.compareDates(each, fromDate, toDate);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        FindTransactionsPage page = new FindTransactionsPage();
        boolean list = Ordering.natural().reverse().isOrdered(page.datesDisplayed());
        Assert.assertTrue(list);

    }
    @Then("the results table should only show transaction dates between {string} to {string}")
    public void results_table_should_only_show_transaction_dates_between_to(String fromDate, String toDate) {
        FindTransactionsPage page = new FindTransactionsPage();

        for(String each : page.datesDisplayed()){
            page.compareDates(each, fromDate, toDate);
        }
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        String string = str.toUpperCase();
        FindTransactionsPage page = new FindTransactionsPage();
        page.descriptionInput.sendKeys(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String str) throws Exception {
        FindTransactionsPage page = new FindTransactionsPage();
        for(int i = 0; i < page.descriptionDisplayed().size(); i++){
            if(!page.descriptionDisplayed().get(i).startsWith(str)){
                throw new Exception("Wrong description type");
            }
        }
    }
    @Then("the results table should show at least one result under Deposit")
    public void the_results_table_should_show_at_least_one_result_under_Deposit() {

    }

    @Then("the results table should show at least one result under Withdrawal")
    public void the_results_table_should_show_at_least_one_result_under_Withdrawal() {


    }
}