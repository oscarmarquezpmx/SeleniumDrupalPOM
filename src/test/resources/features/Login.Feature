Feature: LoginTest

  Scenario Outline: Verify that an Admin can login to Drupal
    Given Open Chrome and launch the application
    When I enter Username as "<username>" and Password as "<password>"

    Examples:
      | username | password |
      | oscar    | 12345    |
      | oscar    | 12345    |
      | xsd      | asdad    |
