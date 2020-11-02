package com.streaming.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streaming.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findById(int id);
}