package com.streaming.userhistoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.userhistoryservice.model.MovieViewsCount;
import com.streaming.userhistoryservice.model.UserHistoryResponse;
import com.streaming.userhistoryservice.model.UserWatchListResponse;
import com.streaming.userhistoryservice.service.UserHistoryService;

@RestController
@RequestMapping(value = "/v1/userhistory")
public class UserHistoryServiceController {

	@Autowired
	UserHistoryService userHistoryService;
	
	@RequestMapping(value = "/history/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> findUserHistoryById(@PathVariable(name = "userId") int userId) {
		UserHistoryResponse userHistory  = userHistoryService.findHistoryByUserId(userId);
		
		return new ResponseEntity<>(userHistory, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/watchlist/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> findUserWatchListById(@PathVariable(name = "userId") int userId) {
		UserWatchListResponse userWatchList  = userHistoryService.findWatchListByUserId(userId);
		
		return new ResponseEntity<>(userWatchList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/movies/viewscount/genre/{genre}", method = RequestMethod.GET)
	public ResponseEntity<?> getMoviesViewsCountByGenre(@PathVariable(name = "genre") int genre) {
		List<MovieViewsCount> moviesViewsCount  = userHistoryService.getMovieViewsCountByGenre(genre);
		
		return new ResponseEntity<>(moviesViewsCount, HttpStatus.OK);
	}
}