package com.spring.ratingservice.model;

import java.util.List;

public class UserRating {

    private List<Rating> ratings;

    public List<Rating> getUserRating() {
        return ratings;
    }

    public void setUserRating(List<Rating> userRating) {
        this.ratings = userRating;
    }
}
