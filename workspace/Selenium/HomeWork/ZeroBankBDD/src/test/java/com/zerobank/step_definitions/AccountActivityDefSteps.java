package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivityDefSteps {

    @Given("The user is on the Account Activity Page")
    public void the_user_is_on_the_Account_Activity_Page(){
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
    }

    @Then("The page should display Zero - Account Activity")
    public void the_page_should_display_Zero_Account_activity() {
        String actualTitle = Driver.get().getTitle();

        String expectedTitle = "Zero - Account Activity";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("The default drop down option is Savings")
    public void the_default_drop_down_option_is_Savings() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        String actualFirstOption = accountActivityPage.dropDownFirstOption.getText();
        String expectedFirstOption = "Savings";

        Assert.assertEquals(expectedFirstOption, actualFirstOption);


    }

    @Then("The drop down menu displays Savings, Checking, Loan, Credit Card, and Brokerage")
    public void the_drop_down_menu_displays_Savings_Checking_Loan_Credit_Card_and_Brokerage() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select dropDownMenu = new Select(accountActivityPage.dropDownList);

        List<String> dropDownItems = new ArrayList<>();
        for(WebElement element : dropDownMenu.getOptions()){
            dropDownItems.add(element.getText());
        }
        List<String> expectedList = new ArrayList<>();
        expectedList.addAll(Arrays.asList("Savings", "Checking",
                "Loan", "Credit Card", "Brokerage"));
        Assert.assertEquals(expectedList, dropDownItems);
    }

    @Then("The Transactions table displays Date, Description, Deposit, and Withdrawal")
    public void the_Transactions_table_displays_Date_Description_Deposit_and_Withdrawal() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualTableColumns = new ArrayList<>();
        for(WebElement element: accountActivityPage.tableColumns){
            actualTableColumns.add(element.getText());
        }
        List<String> expectedTableColumns = new ArrayList<>();
        expectedTableColumns.addAll(Arrays.asList("Date", "Description","Deposit",
                "Withdrawal"));

        Assert.assertEquals(expectedTableColumns, actualTableColumns);

    }
}
