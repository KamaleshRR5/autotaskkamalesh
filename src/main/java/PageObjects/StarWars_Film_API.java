package PageObjects;

import PojoClasses.StarWarsMovies;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class StarWars_Film_API {

    private static  ResponseBody body;
    private static StarWarsMovies.Root responseBody;


    public String hitFilmAPIAndVerifyCount(String strBaseURL, String strFilmCount){
    RestAssured.baseURI = strBaseURL;
    // Get the RequestSpecification of the request to be sent to the server.
    RequestSpecification httpRequest = RestAssured.given();
    // specify the method type (GET) and the parameters if any.
    Response response = httpRequest.request(Method.GET, "");
    // Print the status and message body of the response received from the server
     body = response.getBody();
    responseBody = body.as( StarWarsMovies.Root.class);

    System.out.println("Total count of the movies " + responseBody.count);
    int MoviesCount = responseBody.count;
    String strMovieCount = String.valueOf(MoviesCount);
    return strMovieCount;
}

public ArrayList<String> getAllMoviesTitle(){
        //get all movie title
    ArrayList<String> AllTitles = new ArrayList<>();
    for (int i=0;i<6;i++){
        AllTitles.add(responseBody.results.get(i).title);
    }
    return AllTitles;

}

public String getMovieDirector(){
        //get movie director name
    //we can also make it as dynamic by passing index of the film
    String strdirector = responseBody.results.get(2).director;
    return strdirector;
}

    public String getProducer(){
        //get movie producer name
        //we can also make it as dynamic by passing index of the film
        String strProducer = responseBody.results.get(4).producer;
        return strProducer;
    }

}
