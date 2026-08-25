package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myapp.spring.domain.Movie;

public interface MovieJdbcRepository extends JpaRepository<Movie,Long> {

    @Query("""
        SELECT recommendedMovie
            FROM Movie recommendedMovie
            WHERE LOWER(recommendedMovie.genre) = (
                SELECT LOWER(selectedMovie.genre)
                FROM Movie selectedMovie
                WHERE LOWER(selectedMovie.name) = LOWER(:movieName)
            )
            AND LOWER(recommendedMovie.name) <> LOWER(:movieName)
            ORDER BY recommendedMovie.name

                """)
   List<Movie> recommendations(@Param("movieName") String movieName);

   List<Movie> findByGenre(String genre);

}
