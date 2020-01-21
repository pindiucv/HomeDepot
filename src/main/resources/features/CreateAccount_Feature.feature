Feature: Create new Account

 @CreateNewAccount
 Scenario: User creates new account
  Given User is on login page
  And User clicks on Create Account button
  And User fills out account creation form
  Then Verify that user created an account