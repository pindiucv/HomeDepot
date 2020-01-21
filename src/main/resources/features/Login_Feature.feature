
@Login
Feature: Login

  Scenario: Successful login with valid credentials
    Given User is on login page
    And User enters username "appletreeappletree78@gmail.com" and password "automation100"
    Then Verify that user can see "Welcome" after logged in


  Scenario: Unsuccessful login with invalid credentials
    Given User is on login page
    And User enters incorrect username "appletreeappleetree78@gmail.com" and valid password "automation100"
    Then Verify that user cannot successfully logged in