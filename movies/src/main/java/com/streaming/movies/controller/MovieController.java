package com.streaming.movies.controller;

import com.streaming.movies.model.Genre;
import com.streaming.movies.model.Movie;
import com.streaming.movies.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.streaming.movies.repository.MovieRepository;
import com.streaming.movies.exception.ResourceNotFoundException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;
    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) throws  ResourceNotFoundException {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not Found"));
        return ResponseEntity.ok().body(movie);
    }
      @GetMapping("/movies/genre/{genreId}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable Long genreId) throws  ResourceNotFoundException {
        Genre genre = genreRepository.findById(genreId).orElseThrow(()-> new ResourceNotFoundException("Genre not found"));
          List<Movie> movies = movieRepository.findByGenre(genre);
        return ResponseEntity.ok().body(movies);
    }
}
