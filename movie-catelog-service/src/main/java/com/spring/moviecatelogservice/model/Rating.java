package com.spring.moviecatelogservice.model;

public class Rating {
    public Rating() {
    }

    public Rating(String movieId, String userId, int rating) {
        this.movieId = movieId;
        this.userId = userId;
        this.rating = rating;
    }

    private String movieId;
    private String userId;
    private int rating;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
