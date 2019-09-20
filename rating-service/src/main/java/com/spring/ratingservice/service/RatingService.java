package com.spring.ratingservice.service;

import com.spring.ratingservice.model.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllByUserId(String userId);
}
