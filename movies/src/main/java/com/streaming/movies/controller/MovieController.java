package com.streaming.movies.controller;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.streaming.movies.model.Genre;
import com.streaming.movies.model.Movie;
import com.streaming.movies.repository.GenreRepository;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.streaming.movies.repository.MovieRepository;
import com.streaming.movies.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MovieController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

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

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getByKeyWord(@RequestParam("keyWord") String keyWord) {
      return ResponseEntity.ok().body(movieRepository.findByTitleContaining(keyWord));
    }

    @PostMapping("/watch")
    public ResponseEntity<String> watch() {
        sendMessage("teste for movieid","movies-movie-watched");
        return ResponseEntity.ok().body("Thanks for watching =]");
    }

    void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
}
