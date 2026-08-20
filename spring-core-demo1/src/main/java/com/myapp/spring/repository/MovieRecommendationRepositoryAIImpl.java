package com.myapp.spring.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.myapp.spring.domain.Movie;

@Repository
//@Primary
public class MovieRecommendationRepositoryAIImpl implements MovieRecommendationRepository{


    private final List<Movie> movies;

   // @Autowired
    public MovieRecommendationRepositoryAIImpl(@Qualifier("movies1") List<Movie> movies) {
        this.movies = movies;
    }

    // Singleton
    // Prototype
    // Request
    // Session
    // Application
    // WebSocket





    @Override
    public List<Movie> recommendations(String movieName) {
      return movies.stream().filter(movie -> movie.name().equalsIgnoreCase(movieName))
            .findFirst().map(selectedMovie -> 
                movies.stream().filter(movie -> 
                    movie.genre().equalsIgnoreCase(selectedMovie.genre())).toList())
                    .orElse(List.of());
       
    }

    

}
