package com.spring.ratingservice.repository;

import com.spring.ratingservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "ratings", path = "ratings")
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> getAllByUserId(String userId);
}
