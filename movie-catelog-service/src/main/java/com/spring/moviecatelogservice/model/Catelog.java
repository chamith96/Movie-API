package com.spring.moviecatelogservice.model;


public class Catelog {

    public Catelog() {
    }

    public Catelog(String movieName, String movieDescription, int rating) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.rating = rating;
    }

    private String movieName;
    private String movieDescription;
    private int rating;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String moviDescription) {
        this.movieDescription = moviDescription;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
