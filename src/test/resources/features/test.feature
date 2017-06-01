Feature: mantis test
  Scenario: tester reports bugs
    Given User enters as "tester1"
    And reports an bug
    When user fills the report form with "tester1_issue"
    And sends bug
    Then user opens the bug table
    And user finds the "assigned (dev1)" issue
    And logs out
    Given User enters as "dev1"
    And user opens the bug table
    When user opens the "assigned (dev1)" issue
    And checks fields in the issue
    And user makes the issue resolved
    Then user opens the bug table
    And user finds the "resolved (dev1)" issue
    And logs out
    Given User enters as "lead1"
    And user opens the bug table
    When user opens the "resolved (dev1)" issue
    And user makes the issue closed
    Then user opens the bug table
    And user turns off the filters
    And user finds the "closed (lead1)" issue

