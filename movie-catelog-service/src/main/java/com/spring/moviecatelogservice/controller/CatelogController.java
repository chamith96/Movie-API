package com.spring.moviecatelogservice.controller;

import com.spring.moviecatelogservice.model.Catelog;
import com.spring.moviecatelogservice.model.UserRating;
import com.spring.moviecatelogservice.service.MovieService;
import com.spring.moviecatelogservice.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatelogController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserRatingService userRatingService;

    @RequestMapping("/user/{userId}")
    public List<Catelog> getUserRating(@PathVariable("userId") String userId) {
        UserRating userRaring = userRatingService.getUserRating(userId);
       return userRaring.getUserRating().stream()
               .map(rating -> movieService.getMovieDetails(rating))
               .collect(Collectors.toList());
    }
}
