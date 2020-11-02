package com.streaming.userhistoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streaming.userhistoryservice.entity.UserWatchList;

public interface UserWatchListRepository extends JpaRepository<UserWatchList, Integer> {

	public List<UserWatchList> findByUserId(int userId);
	
}