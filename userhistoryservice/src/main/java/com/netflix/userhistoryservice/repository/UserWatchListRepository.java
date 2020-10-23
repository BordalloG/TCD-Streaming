package com.netflix.userhistoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netflix.userhistoryservice.entity.UserWatchList;

public interface UserWatchListRepository extends JpaRepository<UserWatchList, Integer> {

	public List<UserWatchList> findByUserId(int userId);
	
}