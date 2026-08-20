package com.myapp.spring.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.myapp.spring.domain.Movie;

@Repository
public class MovieRecommendationRepositoryImpl implements MovieRecommendationRepository{

    private final List<Movie> movies = List.of(
            new Movie("1", "Inception", "Science Fiction", "A thief enters dreams to steal secrets."),
            new Movie("2", "Interstellar", "Science Fiction", "Explorers search for a new home beyond the stars."),
            new Movie("3", "The Matrix", "Science Fiction", "A hacker discovers the hidden reality of his world."),
            new Movie("4", "The Godfather", "Crime", "The aging head of a crime family passes control to his son."),
            new Movie("5", "Goodfellas", "Crime", "A young man rises through the ranks of an organized crime family.")
    );

    @Override
    public List<Movie> recommendations(String movieName) {
      return movies.stream().filter(movie -> movie.name().equalsIgnoreCase(movieName))
            .findFirst().map(selectedMovie -> 
                movies.stream().filter(movie -> 
                    movie.genre().equalsIgnoreCase(selectedMovie.genre())).toList())
                    .orElse(List.of());
       
    }

    

}
