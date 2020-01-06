package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FindTransactionsPage {
    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInput;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInput;

    @FindBy(css = "button[type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td")
    public List<WebElement> tableContents;

    public boolean compareDates(String dateToCheck, String fromDate, String toDate){
        try{
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date fDate = fmt.parse(fromDate);
            java.util.Date tDate = fmt.parse(toDate);
            java.util.Date actualDate = fmt.parse(dateToCheck);

            if(actualDate.compareTo(fDate) >= 0 && actualDate.compareTo(tDate) <= 0){
//                System.out.println("Within date range");
                return true;
            }else{
                throw new Exception("Not within range");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public List<String> datesDisplayed(){
        FindTransactionsPage page = new FindTransactionsPage();
        List<String> contentsDisplayed = new ArrayList<>();
        for(WebElement element : page.tableContents){
            contentsDisplayed.add(element.getText());
        }
        List<String> dates = new ArrayList<>();
        for(int i = 0; i < contentsDisplayed.size(); i+=4){
            dates.add(contentsDisplayed.get(i));
        }
        return dates;
    }
    public List<String> descriptionDisplayed(){
        FindTransactionsPage page = new FindTransactionsPage();
        List<String> contentsDisplayed = new ArrayList<>();
        for(WebElement element : page.tableContents){
            contentsDisplayed.add(element.getText());
        }
        List<String> descriptions = new ArrayList<>();
        for(int i = 1; i < contentsDisplayed.size(); i+=4){
            descriptions.add(contentsDisplayed.get(i));
        }
        return descriptions;
    }

//    public List<String> 



}
