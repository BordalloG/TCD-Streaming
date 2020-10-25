package com.netflix.userhistoryservice.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.userhistoryservice.model.Movie;
import com.netflix.userhistoryservice.model.MovieViewsCount;
import com.netflix.userhistoryservice.model.User;
import com.netflix.userhistoryservice.entity.UserHistory;
import com.netflix.userhistoryservice.entity.UserWatchList;
import com.netflix.userhistoryservice.model.UserHistoryResponse;
import com.netflix.userhistoryservice.model.UserWatchListResponse;
import com.netflix.userhistoryservice.repository.UserHistoryRepository;
import com.netflix.userhistoryservice.repository.UserWatchListRepository;

@Service
public class UserHistoryService {

	@Autowired
	UserHistoryRepository userHistoryRepository;
	
	@Autowired
	UserWatchListRepository userWatchListRepository;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public UserHistoryResponse findHistoryByUserId  (int userId){	
		List<UserHistory> userHistory = userHistoryRepository.findByUserId(userId);
		User user = findUserById(userId);
		
		UserHistoryResponse historyResponse = new UserHistoryResponse(user.getId(), user.getName());

		  for(UserHistory u : userHistory) {
			 Movie findedMovie = findMovieById(u.getMovieId());
		  
			 historyResponse.addMovieToHistory(findedMovie.getTitle(), u.getWatchDate());
		  }
		 
		return historyResponse;
	}
	
	public UserWatchListResponse findWatchListByUserId  (int userId){	
		List<UserWatchList> userWatchList = userWatchListRepository.findByUserId(userId);
		User user = findUserById(userId);
		
		UserWatchListResponse watchListResponse = new UserWatchListResponse(user.getId(), user.getName());

		for(UserWatchList u : userWatchList) {		
			Movie findedMovie = findMovieById(u.getMovieId());
		
			watchListResponse.addMovieToWatchList(findedMovie.getTitle(), u.getRegistryDate());				
		}
	
		return watchListResponse;
	}
	
	public List<MovieViewsCount> getMovieViewsCountByGenre(int genre){
		
		List<MovieViewsCount> movieViewsCount = new ArrayList<MovieViewsCount>();
		
		List<Movie> movieList = getMoviesListByGenre(genre);
		
		for(Movie movie : movieList) {					
			int viewsCount = userHistoryRepository.countByMovieId(movie.getId());	
			MovieViewsCount mvc = new MovieViewsCount(movie.getTitle(), movie.getGenre().getTitle(), viewsCount);	
			
			movieViewsCount.add(mvc);
		}
		
		movieViewsCount.sort(Comparator.comparing(MovieViewsCount::getNumberOfViews).reversed());
				
		return movieViewsCount;		
	}
	
	private Movie findMovieById(long movieId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/api/v1/movies/%s", getServiceInstanceURI("movies"), movieId);
		ResponseEntity<Movie> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Movie.class, movieId);
		return restExchange.getBody();	
	}
	
	private List<Movie> getMoviesListByGenre(int genre){
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/api/v1/movies/genre/%s", getServiceInstanceURI("movies"), genre);
		ResponseEntity<List<Movie>> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>(){}, genre);

		return restExchange.getBody();
	}
	
	private User findUserById(int userId) { 
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/user/%s", getServiceInstanceURI("userservice"), userId);
		ResponseEntity<User> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, User.class, userId);
		return restExchange.getBody();	
	}
	
	private String getServiceInstanceURI(String serviceName) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		if (instances.size() == 0) {
			throw new RuntimeException();
		} else {
			return instances.get(0).getUri().toString();
		}
	}
		
    @KafkaListener(id = "movie-watched", topics = "movies-movie-watched")
    public void listenWatchedMovies(String message) throws Exception {
    	JSONObject messsageJson = new JSONObject(message);
    	
    	UserHistory userHistory = new UserHistory(messsageJson.getInt("movieId"), messsageJson.getInt("userId"), new Date());
    	
    	userHistoryRepository.save(userHistory);
    }
    
    @KafkaListener(id = "movie-watch-later", topics = "movie-watch-later")
    public void listenWatchLaterList(String message) throws Exception {
    	System.out.println("Received Event: " + message);
    	JSONObject messsageJson = new JSONObject(message);
    	
    	UserWatchList userWatchList = new UserWatchList(messsageJson.getInt("movieId"), messsageJson.getInt("userId"), new Date());
    	
    	userWatchListRepository.save(userWatchList);
    }
}
