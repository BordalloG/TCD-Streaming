package com.netflix.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.userservice.entity.User;
import com.netflix.userservice.service.UserService;

@RestController
@RequestMapping(value = "/v1/user")
public class UserServiceController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
		User userResult  = userService.findById(id);
		
		return new ResponseEntity<>(userResult, HttpStatus.OK);
	}

}