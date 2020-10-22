package com.streaming.movies.repository;

import com.streaming.movies.model.Genre;
import com.streaming.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByGenre(Genre genre);
}
