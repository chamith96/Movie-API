package com.spring.moviecatelogservice.service;

import com.spring.moviecatelogservice.model.Catelog;
import com.spring.moviecatelogservice.model.Rating;

public interface MovieService {
    Catelog getMovieDetails(Rating rating);
}
