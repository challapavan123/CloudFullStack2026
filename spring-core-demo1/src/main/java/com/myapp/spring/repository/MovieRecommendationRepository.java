package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.domain.Movie;

public interface MovieRecommendationRepository {

    List<Movie> recommendations(String movie);

}
