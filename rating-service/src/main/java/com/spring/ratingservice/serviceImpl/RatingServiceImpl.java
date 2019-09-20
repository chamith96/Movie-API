package com.spring.ratingservice.serviceImpl;

import com.spring.ratingservice.model.Rating;
import com.spring.ratingservice.repository.RatingRepository;
import com.spring.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public List<Rating> getAllByUserId(String userId){
        return ratingRepository.getAllByUserId(userId);
    }
}
