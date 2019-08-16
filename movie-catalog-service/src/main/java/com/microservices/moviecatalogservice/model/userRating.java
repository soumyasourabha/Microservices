package com.microservices.moviecatalogservice.model;

import java.util.List;

public class userRating {
    private List<rating> userRating;

    public List<rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<rating> userRating) {
        this.userRating = userRating;
    }
}
