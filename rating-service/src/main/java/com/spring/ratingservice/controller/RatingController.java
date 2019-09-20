package com.spring.ratingservice.controller;

import com.spring.ratingservice.model.Rating;
import com.spring.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @RequestMapping("/user/{userId}")
    public List<Rating> getUserMovies(@PathVariable("userId") String uid){
       return ratingService.getAllByUserId(uid);
    }
}
