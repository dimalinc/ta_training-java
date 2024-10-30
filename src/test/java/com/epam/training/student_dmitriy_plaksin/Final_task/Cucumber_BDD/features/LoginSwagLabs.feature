Feature: various logins to Swag Labs

  Scenario Outline: Test Login form with various credentials
    Given User open the Swag Labs login page
    When User enter the username "<username>" and the password "<password>"
    Then User should see the expected message "<expectedMessage>"

    Examples:
      | username        | password        | expectedMessage               |
      |                 |                 | Username is required          |
      | validUser       |                 | Password is required          |
      | standard_user   | secret_sauce    | Swag Labs                     |