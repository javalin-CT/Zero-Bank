package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "h2[class='board-header']")
        public List<WebElement> accounts;

    @FindBy(xpath = "(//table[@class='table'])[3]//th")
        public List<WebElement> creditAcctColumns;


}
