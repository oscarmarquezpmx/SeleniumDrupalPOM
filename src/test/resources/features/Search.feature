Feature: SearchTest

  Scenario Outline: Verify that the search is working
    Given Open browser and launch the application
    When I enter a search value "<term>"

    Examples:
      | term   |
      | dish   |
      | fish   |
      | chicken|