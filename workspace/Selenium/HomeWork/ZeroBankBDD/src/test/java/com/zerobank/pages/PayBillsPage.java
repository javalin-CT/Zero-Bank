package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {
    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[.='Pay Bills']")
    public WebElement payBillsTab;

    @FindBy(id = "sp_amount")
    public WebElement amountInput;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "sp_description")
    public WebElement descriptionInput;

    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;

    @FindBy(xpath = "//span[.='The payment was successfully submitted.']")
    public WebElement payConfirmation;



}
