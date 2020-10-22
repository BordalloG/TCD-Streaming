package com.netflix.userhistoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.userhistoryservice.repository.UserHistoryRepository;

@Service
public class UserHistoryService {

	@Autowired
	UserHistoryRepository userHistoryRepository;
	
}
