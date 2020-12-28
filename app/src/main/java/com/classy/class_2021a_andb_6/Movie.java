package com.classy.class_2021a_andb_6;

public class Movie {

    private String name = "";
    private String actor = "";
    private boolean inNetflix = false;
    private int year = 0;
    private double rating = 0.0;


    public Movie() { }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public String getActor() {
        return actor;
    }

    public Movie setActor(String actor) {
        this.actor = actor;
        return this;
    }

    public boolean isInNetflix() {
        return inNetflix;
    }

    public Movie setInNetflix(boolean inNetflix) {
        this.inNetflix = inNetflix;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Movie setYear(int year) {
        this.year = year;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Movie setRating(double rating) {
        this.rating = rating;
        return this;
    }
}
