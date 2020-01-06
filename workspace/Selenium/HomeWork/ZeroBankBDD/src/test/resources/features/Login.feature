@login
Feature: Users should be able to login

  Background:
    Given The user is on the login page

  Scenario: User should be able to login with valid credentials
    When The user enters valid credentials
    Then The user should be able to log in

  Scenario: User should not be able to login with invalid credentials
    When The user enters invalid credentials
    Then The user should not be able to login

  Scenario: User should not be able to login with blank credentials
    When The user enters no credentials
    Then The user should not be able to login