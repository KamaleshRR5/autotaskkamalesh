package StepDefinitions;
import PageObjects.StarWars_Film_API;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StarWars_API {

    StarWars_Film_API starWarsApi;
    @Given(": User hits the starwars {string} and verify the count is {string}")
    public void user_hits_the_starwars_and_verify_the_count_is(String strBaseURL, String strMovieCount) {
         starWarsApi = new StarWars_Film_API();
       String totalMovieCount = starWarsApi.hitFilmAPIAndVerifyCount(strBaseURL, strMovieCount);
       Assert.assertEquals(totalMovieCount,strMovieCount);
    }
    @And(": User also gets all list of movies and its title from the api")
    public void user_also_gets_all_list_of_movies_and_its_title_from_the_api() {
       ArrayList<String> AllMovieTitle = starWarsApi.getAllMoviesTitle();
        System.out.println("Got All movies Name as "+AllMovieTitle.stream().collect(Collectors.joining(" ")));
    }
    @Then(": User gets {string} movie and verify the director is {string}")
    public void user_gets_movie_and_verify_the_director_is(String string, String strDirectorName) {
        String strDirector = starWarsApi.getMovieDirector();
        System.out.println("Director name of 3 rd movie is "+strDirector);
        Assert.assertEquals(strDirector,strDirectorName);
    }
    @And(": User gets {string} movie and verify the producer is not  {string}, {string}")
    public void user_gets_movie_and_verify_the_producer_is_not(String string, String producer1, String producer2) {
        // Write code here that turns the phrase above into concrete actions
        String strProducer = starWarsApi.getProducer();
        System.out.println("Producer name of 5 th movie is "+strProducer);
        Assert.assertNotEquals(strProducer,producer1);
        Assert.assertNotEquals(strProducer,producer2);
    }


}
