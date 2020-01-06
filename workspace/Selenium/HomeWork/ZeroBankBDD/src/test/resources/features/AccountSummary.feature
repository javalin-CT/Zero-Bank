@accountSummary
Feature: Account Summary Page

  Background:
    Given The user is on the Account Summary page

  Scenario: The Account Summary page should have the title "Zero - Account Summary"
    Then The page title should be "Zero - Account Summary"

  Scenario: The Account Summer page should display four account types
    Then The page should display Cash, Investment, Credit, and Loan accounts

  Scenario: The Credit Accounts must have columns "Account" "Credit Card" "Balance"
    Then The Credit Accounts table should display "Account" "Credit Card" "Balance"

