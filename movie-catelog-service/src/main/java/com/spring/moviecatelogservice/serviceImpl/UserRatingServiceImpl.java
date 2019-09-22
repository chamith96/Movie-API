package com.spring.moviecatelogservice.serviceImpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.moviecatelogservice.model.Rating;
import com.spring.moviecatelogservice.model.UserRating;
import com.spring.moviecatelogservice.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingServiceImpl implements UserRatingService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String userId) {
        UserRating userRaring = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId,UserRating.class);
        return userRaring;
    }

    public UserRating getFallbackUserRating(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserRating(Arrays.asList(
                new Rating("0",userId,0)));
        return userRating;
    }
}
