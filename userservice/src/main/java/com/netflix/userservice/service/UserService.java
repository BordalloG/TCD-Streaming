package com.netflix.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.userservice.entity.User;
import com.netflix.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findById(int id) {
		User user = userRepository.findById(id);
		
		return user;
	}
	
}
