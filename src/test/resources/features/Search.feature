Feature: SearchTest

  Scenario Outline: Verify that the search is working
    Given Open Chrome and launch the application and search
    When I enter a search value "<term>"

    Examples:
      | term   |
      | dish   |
      | fish   |
      | chicken|