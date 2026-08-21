package com.myapp.spring.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.domain.Movie;

@Repository
public class MovieJdbcRepositoryImpl implements MovieJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED)
    public Movie save(Movie movie) {
       String sql = """
               
       INSERT into movies (id,name,genre,description)
       VALUES (?,?,?,?)
               """;
               jdbcTemplate.update(
                sql, movie.id(),movie.name(),movie.genre(),movie.description());
                return movie;
    }

    @Override
    public Movie findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Movie> recommendations(String movieName) {
        // TODO Auto-generated method stub

        String sql = """
                 SELECT id, name, genre, description
            FROM movies
            WHERE LOWER(genre) = (
                SELECT LOWER(genre)
                FROM movies
                WHERE LOWER(name) = LOWER(?)
                LIMIT 1
            )
            AND LOWER(name) <> LOWER(?)
            ORDER BY name

                """;
        //throw new UnsupportedOperationException("Unimplemented method 'recommendations'");

       return List.of(jdbcTemplate.queryForObject(sql, 
        new DataClassRowMapper<Movie>(Movie.class),movieName,movieName));
    }
    

}
