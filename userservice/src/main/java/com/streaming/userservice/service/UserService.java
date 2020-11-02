package com.streaming.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streaming.userservice.entity.User;
import com.streaming.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findByUserId(int userId) {
		User user = userRepository.findById(userId);
		
		return user;
	}
	
}
