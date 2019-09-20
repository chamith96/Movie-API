package com.spring.movieservice.controller;

import com.spring.movieservice.model.Movie;
import com.spring.movieservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    String apiKey;

    @RequestMapping("/{id}")
    public Movie showMovie(@PathVariable("id") String id) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+id+"?api_key="+apiKey,MovieSummary.class);
        return new Movie(id,movieSummary.getTitle(),movieSummary.getOverview());
    }

}
