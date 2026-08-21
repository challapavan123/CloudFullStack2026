package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.domain.Movie;

public interface MovieJdbcRepository {

    Movie save(Movie movie);
    Movie findById(String id);
    List<Movie> recommendations(String movieName);

}
