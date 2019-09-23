package com.spring.moviecatelogservice.serviceImpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.moviecatelogservice.model.Catelog;
import com.spring.moviecatelogservice.model.Movie;
import com.spring.moviecatelogservice.model.Rating;
import com.spring.moviecatelogservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackMovieDetails",
            commandProperties = {
                @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
                @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),
                @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),
                @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")
            })
    public Catelog getMovieDetails(Rating rating) {
        Movie movie =  restTemplate.getForObject("http://MOVIE-SERVICE/movies/"+rating.getMovieId(), Movie.class);
        return new Catelog(movie.getName(),movie.getDescription(),rating.getRating());
    }

    public Catelog getFallbackMovieDetails(Rating rating) {
        return new Catelog("Not found","Not found",rating.getRating());
    }

}
