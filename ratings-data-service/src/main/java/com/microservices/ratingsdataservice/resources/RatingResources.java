package com.microservices.ratingsdataservice.resources;

import com.microservices.ratingsdataservice.models.rating;
import com.microservices.ratingsdataservice.models.userRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResources {
    @RequestMapping("/{movieId}")
    public rating getRating(@PathVariable("movieId") String movieId) {

        return new rating(movieId, 5);
    }

    @RequestMapping("/users/{userId}")
    public userRating getUserRating(@PathVariable("userId") String userId) {
        List<rating> ratings = Arrays.asList(
                new rating("BANG456", 3),
                new rating("super333", 4)
        );
        userRating userRating = new userRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
