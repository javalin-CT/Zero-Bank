package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[.='Account Activity']")
    public WebElement accountActivityTab;

    @FindBy(id = "aa_accountId")
    public WebElement dropDownList;

    @FindBy(css = "option[value='1']")
    public WebElement dropDownFirstOption;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> tableColumns;

    @FindBy(css = "a[href='#ui-tabs-2']")
    public WebElement findTransactionsTab;

}
