package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountSummaryStepDefs {
    @Given("The user is on the Account Summary page")
    public void the_user_is_on_the_Account_Summary_page() {
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

    @Then("The page title should be {string}")
    public void the_page_title_should_be(String string) {
        Assert.assertTrue(Driver.get().getTitle().equals("Zero - Account Summary"));
    }

    @Then("The page should display Cash, Investment, Credit, and Loan accounts")
    public void the_page_should_display_Cash_Investment_Credit_and_Loan_accounts( ) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> accounts = new ArrayList<>();
        for(WebElement element : accountSummaryPage.accounts){
            accounts.add(element.getText());
        }
        List<String> expectedAccounts = new ArrayList<>();
        expectedAccounts.addAll(Arrays.asList("Cash Accounts", "Investment Accounts",
                "Credit Accounts", "Loan Accounts"));

        Assert.assertEquals(expectedAccounts, accounts);
    }
    @Then("The Credit Accounts table should display {string} {string} {string}")
    public void the_table_should_display(String string1, String string2, String string3) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> columns = new ArrayList<>();
        for(WebElement element : accountSummaryPage.creditAcctColumns){
            columns.add(element.getText());
        }
        List<String> expectedColumns = new ArrayList<>();
        expectedColumns.addAll(Arrays.asList("Account", "Credit Card", "Balance"));
        Assert.assertEquals(expectedColumns, columns);
    }
}
