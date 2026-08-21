package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.domain.Movie;

public interface MovieSearchService {

    List<Movie> search(String movieName);
}
