package com.classy.class_2021a_andb_6;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DataGenerator {


    public static ArrayList<Movie> generateMockMovies() {
        // ArrayList<Movie> movies = DataGenerator.generateMockMovies();
        // String json = new Gson().toJson(movies);

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie()
                .setKey("m001")
                .setName("Inglourious Basterds")
                .setActor("Brad Pitt")
                .setInNetflix(true)
                .setRating(4.15)
                .setYear(2009)
        );

        movies.add(new Movie()
                .setKey("m002")
                .setName("Bad Boys")
                .setActor("Will Smith")
                .setInNetflix(false)
                .setRating(3.2)
                .setYear(1995)
        );

        movies.add(new Movie()
                .setKey("m003")
                .setName("JamesBond")
                .setActor("Daniel")
                .setInNetflix(true)
                .setRating(3.8)
                .setYear(1968)
        );

        movies.add(new Movie()
                .setKey("m004")
                .setName("The Grinch Who Stole Christmas")
                .setActor("Jim Carrey")
                .setInNetflix(true)
                .setRating(4.5)
                .setYear(2000)
        );

        movies.add(new Movie()
                .setKey("m005")
                .setName("Cinderalla")
                .setActor("Jennifer Aniston")
                .setInNetflix(true)
                .setRating(3.5)
                .setYear(1950)
        );

        movies.add(new Movie()
                .setKey("m006")
                .setName("World War Z")
                .setActor("Brad Pitt")
                .setInNetflix(false)
                .setRating(3.5)
                .setYear(2013)
        );

        movies.add(new Movie()
                .setKey("m007")
                .setName("The Lord of the Rings: The Fellowship of the Ring")
                .setActor(" Elijah Wood")
                .setInNetflix(true)
                .setRating(4.5)
                .setYear(2001)
        );

        movies.add(new Movie()
                .setKey("m008")
                .setName("Forrest Gump")
                .setActor("Tom Hanks")
                .setInNetflix(true)
                .setRating(4.2)
                .setYear(1994)
        );

        movies.add(new Movie()
                .setKey("m009")
                .setName("Jony English")
                .setActor("Rowan Atkinson")
                .setInNetflix(false)
                .setRating(4.2)
                .setYear(2003)
        );

        movies.add(new Movie()
                .setKey("m010")
                .setName("Avengers End Game")
                .setActor("Robert Downey Jr.")
                .setInNetflix(false)
                .setRating(8.4)
                .setYear(2019)
        );

        return movies;
    }
}
