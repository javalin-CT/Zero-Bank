@accountActivity
Feature: Account Activity Page

  Background:
    Given The user is on the Account Activity Page

  Scenario: The Account Activity page should have title "Zero - Account activity"
    Then The page should display Zero - Account Activity

  Scenario: The default drop down option should be Savings
    Then The default drop down option is Savings

  Scenario: The drop down menu should display Savings, Checking, Loan, Credit Card, Brokerage
    Then The drop down menu displays Savings, Checking, Loan, Credit Card, and Brokerage

  Scenario: The Transactions table should have columns Date, Description, Deposit, and Withdrawal
    Then The Transactions table displays Date, Description, Deposit, and Withdrawal

