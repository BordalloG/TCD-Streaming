package com.streaming.movies.controller;

import com.streaming.movies.model.Genre;
import com.streaming.movies.model.Likes;
import com.streaming.movies.model.Movie;
import com.streaming.movies.repository.GenreRepository;
import com.streaming.movies.repository.LikeRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import com.streaming.movies.repository.MovieRepository;
import com.streaming.movies.exception.ResourceNotFoundException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MovieController(KafkaTemplate<String, String> kafkaTemplate, RestTemplateBuilder restTemplateBuilder) {
        this.kafkaTemplate = kafkaTemplate;
        this.restTemplate = restTemplateBuilder.build();
    }
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private LikeRepository likeRepository;
    private final RestTemplate restTemplate;


    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) throws  ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not Found"));
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

    @PostMapping("/movies/{movieId}/watch/user/{userId}")
    public ResponseEntity<String> watch(@PathVariable Long movieId, @PathVariable Long userId) throws JSONException, ResourceNotFoundException {
        if(!userExist(userId)){
            throw new ResourceNotFoundException("user not found");
        };
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new ResourceNotFoundException("movie not found"));
        String jsonString = new JSONObject()
                .put("userId", userId)
                .put("movieId", movieId)
                .toString();

        sendMessage(jsonString,"movies-movie-watched");
        return ResponseEntity.ok().body("Thanks for watching =]");
    }

    @PostMapping("/movies/{movieId}/like/user/{userId}")
    public ResponseEntity<String> like(@PathVariable Long movieId, @PathVariable Long userId) throws  ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new ResourceNotFoundException("movie not found"));
        Likes like = new Likes(movieId, userId);
        likeRepository.save(like);
        return ResponseEntity.ok().body(String.format("Like registered to %s by user %s", movie.getTitle(), like.getUserId()));
    }

    @PostMapping("/movies/{movieId}/watchLater/user/{userId}")
    public ResponseEntity<String> watchLater(@PathVariable Long movieId, @PathVariable Long userId) throws ResourceNotFoundException, JSONException {
         if(!userExist(userId)){
            throw new ResourceNotFoundException("user not found");
         };
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new ResourceNotFoundException("movie not found"));
        String jsonString = new JSONObject()
                .put("userId", userId)
                .put("movieId", movieId)
                .toString();
        sendMessage(jsonString,"movie-watch-later");
        return ResponseEntity.ok().body(String.format("The movie %s was added to user %s watch later list", movie.getTitle(), userId));
    }

    private boolean userExist(long userId) {
        String serviceUri = getUserServiceInstance();
        String requestUri = String.format("%s/v1/user/%s",serviceUri,userId);
        Object response = restTemplate.getForObject(requestUri, Object.class);
        return response != null;

    }
    private String getUserServiceInstance(){
        List<ServiceInstance> instances = discoveryClient.getInstances("userservice");
        if (instances.size() == 0) {
            throw new RuntimeException();
        } else {
            return instances.get(0).getUri().toString();
        }
    }
    void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
}
