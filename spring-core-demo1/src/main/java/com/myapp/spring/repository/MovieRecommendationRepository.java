package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.domain.Movie;

public interface MovieRecommendationRepository {

    List<Movie> recommendations(String movie);

}


//postgresql://neondb_owner:npg_2sMvn7LRIdti@ep-withered-leaf-au1dxeid.c-10.us-east-1.aws.neon.tech/neondb?sslmode=require