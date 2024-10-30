Feature: Login to Swag Labs

  Scenario 3: Successful login
    Given A user navigates to saucedemo.com site
    When A user enters a valid login <login> and password <password>
    And A user clicks sign-into
    Then A user is to be successfully logged in



  Example:
| login           | password        | error message                 |
| standard_user   | secret_sauce    | Swag Labs                     |