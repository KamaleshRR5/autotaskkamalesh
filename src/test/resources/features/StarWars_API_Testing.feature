Feature: Starwars API Testing Scenarios
  @API
Scenario Outline: User tests the API for star wars application

Given : User hits the starwars "<filmApi>" and verify the count is "6"
And : User also gets all list of movies and its title from the api
Then : User gets "3" movie and verify the director is "Richard Marquand"
And : User gets "5" movie and verify the producer is not  "Gary Kurtz", "George Lucas"

    Examples:
    |filmApi                      |
    |https://swapi.dev/api/films   |