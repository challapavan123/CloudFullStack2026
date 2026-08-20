package com.myapp.spring.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.myapp.spring.domain.Movie;

@Repository
public class MovieRecommendationRepositoryImpl implements MovieRecommendationRepository{

    private final List<Movie> movies;

    public MovieRecommendationRepositoryImpl(List<Movie> movies) {
        this.movies = movies;
    }





    @Override
    public List<Movie> recommendations(String movieName) {
      return movies.stream().filter(movie -> movie.name().equalsIgnoreCase(movieName))
            .findFirst().map(selectedMovie -> 
                movies.stream().filter(movie -> 
                    movie.genre().equalsIgnoreCase(selectedMovie.genre())).toList())
                    .orElse(List.of());
       
    }

    

}
