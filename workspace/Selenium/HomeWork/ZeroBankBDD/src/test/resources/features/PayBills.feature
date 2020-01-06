@payBills
  Feature: Pay Bills Page

    Background:
      Given The user is on the Pay Bills page

    Scenario: The Pay Bills page should have the title Zero - Pay Bills
      Then The title is Zero - Pay Bills

    Scenario: Confirmation message displayed "The payment was successfully submitted." when completing a Pay operation
      When The user enters valid information to complete a pay operation
      Then The confirmation message should be displayed

    Scenario: Error message "Please fill our this field!" message displayed when entering no ammount
      When The user enters no amount
      Then The error message should be displayed

    Scenario: Error message "Please fill our this field!" message displayed when entering no ammount
      When The user enters no date
      Then The error message should be displayed

    Scenario: Amount field should not accept alphabetical or special characters
      When The user enters alphabetical or special characters into the Amount field
      Then The error message should be displayed

    Scenario: Date field should not accept alphabetical characters
      When The user enters alpabetical characters into the Date field
      Then The error message should be displayed

