package com.myapp.spring.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myapp.spring.domain.Movie;

@Configuration
@ComponentScan(basePackages = "com.myapp.spring")
public class AppConfig {

    @Bean
    List<Movie> movies(){
        return List.of(
            new Movie("1", "Inception", "Science Fiction", "A thief enters dreams to steal secrets."),
            new Movie("2", "Interstellar", "Science Fiction", "Explorers search for a new home beyond the stars."),
            new Movie("3", "The Matrix", "Science Fiction", "A hacker discovers the hidden reality of his world."),
            new Movie("4", "The Godfather", "Crime", "The aging head of a crime family passes control to his son."),
            new Movie("5", "Goodfellas", "Crime", "A young man rises through the ranks of an organized crime family.")
    );
    }

}
