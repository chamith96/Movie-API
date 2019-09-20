package com.spring.movieservice.model;

public class Movie {

    public Movie() {
    }

    public Movie(String movieId,String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    private String movieId;

    private String name;

    private String description;

    public String getmovieId() {
        return movieId;
    }

    public void setmovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
