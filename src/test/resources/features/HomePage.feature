@web
  Feature: HomePage Feature
    Background:
    Given I am on Darksky HomePage

      @home

      Scenario: Verify min and max temnperature
        When I click on today area on homepage
        And  I get temperatures on homepage
        And I get min temperatures on homepage
        And I get max temperatures on homepage
        Then I verify min temperature on homepage
        Then I verify max temperature on homepage