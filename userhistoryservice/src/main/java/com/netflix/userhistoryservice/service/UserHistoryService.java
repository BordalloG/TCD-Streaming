package com.netflix.userhistoryservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.userhistoryservice.model.Movie;
import com.netflix.userhistoryservice.model.MovieList;
import com.netflix.userhistoryservice.model.MovieViewsCount;
import com.netflix.userhistoryservice.model.User;
import com.netflix.userhistoryservice.entity.UserHistory;
import com.netflix.userhistoryservice.entity.UserWatchList;
import com.netflix.userhistoryservice.model.UserHistoryResponse;
import com.netflix.userhistoryservice.model.UserWatchListResponse;
import com.netflix.userhistoryservice.repository.UserHistoryRepository;
import com.netflix.userhistoryservice.repository.UserWatchListRepository;

@EnableBinding(Sink.class)
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
		
		MovieList movieList = getMoviesListByGenre(genre);
		
		for(Movie movie : movieList.getMovieList()) {
			
			MovieViewsCount mvc = new MovieViewsCount(movie.getTitle(), 1);	//userHistoryRepository.getMovieViewsCount(movie.getId())
			movieViewsCount.add(mvc);
		}
		
		return movieViewsCount;		
	}
	
	private Movie findMovieById(int movieId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/api/v1/movies/%s", getServiceInstanceURI("movies"), movieId);
		ResponseEntity<Movie> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Movie.class, movieId);
		return restExchange.getBody();	
	}
	
	private MovieList getMoviesListByGenre(int genre){
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/api/v1/movies/genre/%s", getServiceInstanceURI("movies"), genre);
		ResponseEntity<MovieList> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, MovieList.class, genre);

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
		
	@StreamListener(target = Sink.INPUT)
	public void consumerUserHistoryEvent(@Payload UserHistory event) {
		System.out.println("Received a new user history data UserId" + event.getUserId() + " MovieId: " + event.getMovieId());
		userHistoryRepository.save(event);
	}
	
	@StreamListener(target = Sink.INPUT)
	public void consumerUserWatchListEvent(@Payload UserWatchList event) {
		System.out.println("Received a new user watchlist data UserId" + event.getUserId() + " MovieId: " + event.getMovieId());	
		userWatchListRepository.save(event);
	}
}
