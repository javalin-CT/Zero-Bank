package com.zerobank.step_definitions;


import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        HomePage homePage = new HomePage();
        homePage.signInBtn.click();

    }
    //positive login
    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();


    }
    //positive login
    @Then("The user should be able to log in")
    public void the_user_should_be_able_to_log_in() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
    }
    //negative login
    @When("The user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        String username = ConfigurationReader.get("fakeUsername");
        String password = ConfigurationReader.get("fakePassword");

        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();
    }
    //negative login
    @Then("The user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }
    //blank credentials
    @When("The user enters no credentials")
    public void the_user_enters_no_credentials() {
        String username = " ";
        String password = " ";

        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();
    }
}
