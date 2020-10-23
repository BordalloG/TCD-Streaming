package com.netflix.userhistoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.userhistoryservice.entity.UserHistoryResponse;
import com.netflix.userhistoryservice.entity.WatchHistory;
import com.netflix.userhistoryservice.service.UserHistoryService;

@RestController
@RequestMapping(value = "/v1/userhistory")
public class UserHistoryServiceController {

	@Autowired
	UserHistoryService userHistoryService;
	
	@RequestMapping(value = "/history/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable(name = "userId") int userId) {
		UserHistoryResponse userHistory  = userHistoryService.findHistoryByUserId(userId);
		
		return new ResponseEntity<>(userHistory, HttpStatus.OK);
	}

}