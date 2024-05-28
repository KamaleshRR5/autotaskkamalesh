package PojoClasses;

import java.util.ArrayList;
import java.util.Date;

public class StarWarsMovies {


    public class Result{
        public String title;
        public int episode_id;
        public String opening_crawl;
        public String director;
        public String producer;
        public String release_date;
        public ArrayList<String> characters;
        public ArrayList<String> planets;
        public ArrayList<String> starships;
        public ArrayList<String> vehicles;
        public ArrayList<String> species;
        public Date created;
        public Date edited;
        public String url;
    }

    public class Root{
        public int count;
        public Object next;
        public Object previous;
        public ArrayList<Result> results;
    }


}
