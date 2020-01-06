@findTransactions
  Feature: Find Transactions in Account Activity

    Background:
      Given the user accesses the Find Transactions tab

    Scenario: Search date range "2012-09-01" to "2010-09-06"
      When the user enters date range from "2012-09-01" to "2012-09-06"
      And clicks search
      Then the results table should show only transaction dates between "2012-09-01" to "2012-09-06"
      And the results should be sorted by most recent date

    Scenario: Search date range "2012-09-02" to "2010-09-06"
      When the user enters date range from "2012-09-02" to "2012-09-06"
      And clicks search
      Then the results table should only show transaction dates between "2012-09-02" to "2012-09-06"
      Then the results table should show only transaction dates between "2012-09-02" to "2012-09-06"

    Scenario: Search description ONLINE
      When the user enters description "ONLINE"
      And clicks search
      Then results table should only show descriptions containing "ONLINE"

    Scenario: Search description OFFICE
      When the user enters description "OFFICE"
      And clicks search
      Then results table should only show descriptions containing "OFFICE"

    Scenario: Search description case insensitive "ONLINE"
      When the user enters description "online"
      And clicks search
      Then results table should only show descriptions containing "ONLINE"

    @wip
    Scenario: Type
      And clicks search
      Then the results table should show at least one result under Deposit
      Then the results table should show at least one result under Withdrawal

