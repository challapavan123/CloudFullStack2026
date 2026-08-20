package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.spring.domain.Movie;
import com.myapp.spring.repository.MovieRecommendationRepository;

@Service
public class MovieSearchService {

    
    private MovieRecommendationRepository movieRecommendationRepository;

    @Autowired
    public MovieSearchService(MovieRecommendationRepository movieRecommendationRepository) {
        this.movieRecommendationRepository = movieRecommendationRepository;
    }

    public List<Movie> search(String movieName){
        return movieRecommendationRepository.recommendations(movieName);
    }

}
