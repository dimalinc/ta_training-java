Feature: Login to Swag Labs

  Scenario 1: Unsuccessful login
    Given A user navigates to saucedemo.com site
    When A user enters no login "<login>" and no password "<password>"
    And clicks log in
    Then the proper error message "<error message>" should be displayed

    Example:
      | login           | password        | error message                 |
      |                 |                 | Username is required          |
