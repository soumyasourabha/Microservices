package com.microservices.moviecatalogservice.resources;


import com.microservices.moviecatalogservice.model.CatalogItem;
import com.microservices.moviecatalogservice.model.movie;
import com.microservices.moviecatalogservice.model.rating;
import com.microservices.moviecatalogservice.model.userRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    @LoadBalance
    private RestTemplate restTemplate;


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        userRating ratings = restTemplate.getForObjeWct("http://localhost:8083/ratings/users/" + userId, userRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), movie.class);


            return new CatalogItem(movie.getName(), "DESC", rating.getRating());
        }).collect(Collectors.toList());

    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}


//            movie movie = webClientBuilder.build()
//                            .get()
//                            .uri("http://localhost:8082/movies/"+rating.getMovieId())
//                            .retrieve()
//                            .bodyToMono(movie.class)
//                            .block();
