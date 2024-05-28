Feature: Starwars Testing Scenarios


@starwars
  Scenario Outline: User launches star wars and verify the sorting functionality

    Given : User Launch Chrome browser and load the star wars application
    And : User sort the movies by "<Column>" and verify the last movie as "<lastMovie>"
    Then : User clicks the movie "The Empire Strikes Back" and vefify the species has "Wookie"
    And : User verify that "Planets", "Camino" is not part of "<lastMovie>"

    Examples:
      | Column   | lastMovie          |
      | Title    | The Phantom Menace  |





