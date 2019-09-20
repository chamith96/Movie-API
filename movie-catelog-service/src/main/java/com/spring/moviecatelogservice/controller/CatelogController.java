package com.spring.moviecatelogservice.controller;

import com.spring.moviecatelogservice.model.Catelog;
import com.spring.moviecatelogservice.model.Movie;
import com.spring.moviecatelogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatelogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/{userId}")
    public List<Catelog> getUserRating(@PathVariable("userId") String userId) {
        UserRating userRaring = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId,UserRating.class);
       return userRaring.getUserRating().stream()
               .map(rating -> {
                   Movie movie =  restTemplate.getForObject("http://MOVIE-SERVICE/movies/"+rating.getMovieId(), Movie.class);
                   return new Catelog(movie.getName(),movie.getDescription(),rating.getRating());
               })
               .collect(Collectors.toList());
    }

}
