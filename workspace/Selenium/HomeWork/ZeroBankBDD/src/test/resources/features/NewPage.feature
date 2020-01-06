@newPage
Feature: Create a new logged in browser
  Background:
    Given The user is on the login page

  Scenario: User should be able to login with valid credentials
    When The user enters valid credentials
    Then The user should be able to log in