package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountActivityNavigationPage {
    public AccountActivityNavigationPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=1']")
    public WebElement firstSavingsLink;

    @FindBy(id = "aa_accountId")
    public WebElement dropDownList;

    @FindBy(css = "option[value='1']")
    public WebElement dropDownSavings;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerageLink;

    @FindBy(css = "option[value='6']")
    public WebElement dropDownBrokerage;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=2']")
    public WebElement checkingLink;

    @FindBy(css = "option[value='2']")
    public WebElement dropDownChecking;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCardLink;

    @FindBy(css = "option[value='5']")
    public WebElement dropDownCreditCard;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=4']")
    public WebElement loanLink;

    @FindBy(css = "option[value='4']")
    public WebElement dropDownLoan;

}
