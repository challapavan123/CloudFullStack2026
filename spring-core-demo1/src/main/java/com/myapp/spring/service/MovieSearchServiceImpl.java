package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myapp.spring.domain.Movie;
import com.myapp.spring.repository.MovieRecommendationRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Scope("prototype")
public final  class MovieSearchServiceImpl implements MovieSearchService{

    
    private MovieRecommendationRepository movieRecommendationRepository;

    @PostConstruct
    public void initialize(){
        System.out.println("Inside Init");
    }

    @PreDestroy
    public void destroy(){
         System.out.println("Inside Destroy");
    }

    @Autowired
    public MovieSearchServiceImpl( MovieRecommendationRepository movieRecommendationRepository) {
        this.movieRecommendationRepository = movieRecommendationRepository;
    }

    public List<Movie> search(String movieName){
        return movieRecommendationRepository.recommendations(movieName);
    }

}
