package com.netflix.userhistoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.userhistoryservice.entity.UserHistory;
import com.netflix.userhistoryservice.entity.UserHistoryResponse;
import com.netflix.userhistoryservice.repository.UserHistoryRepository;

@Service
public class UserHistoryService {

	@Autowired
	UserHistoryRepository userHistoryRepository;
	
	@Autowired
	UserHistoryRepository userWatchListRepository;
	
	public UserHistoryResponse findHistoryByUserId  (int userId){
		
		List<UserHistory> userHistory = userHistoryRepository.findByUserId(userId);
		UserHistoryResponse historyResponse = new UserHistoryResponse();
		
		return historyResponse;
	}
}
