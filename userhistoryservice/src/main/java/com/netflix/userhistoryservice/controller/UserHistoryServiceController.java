package com.netflix.userhistoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.userhistoryservice.service.UserHistoryService;

@RestController
@RequestMapping(value = "/v1/productservice")
public class UserHistoryServiceController {

	@Autowired
	UserHistoryService userHistoryService;

}