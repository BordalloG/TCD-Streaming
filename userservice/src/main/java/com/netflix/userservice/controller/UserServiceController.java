package com.netflix.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.userservice.service.UserService;

@RestController
@RequestMapping(value = "/v1/productservice")
public class UserServiceController {

	@Autowired
	UserService userService;

}