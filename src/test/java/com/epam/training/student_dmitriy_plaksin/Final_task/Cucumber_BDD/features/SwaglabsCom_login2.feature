Feature: Login to Swag Labs

  Scenario 2: Unsuccessful login
    Given A user navigates to saucedemo.com site
    When A user enters a valid login <login> and empty password <password>
    And clicks sign in
    Then the proper error message <error message> should be displayed



Example:
| login           | password        | error message                 |
| validUser       |                 | Password is required          |
