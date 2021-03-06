package com.streaming.userhistoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streaming.userhistoryservice.entity.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Integer> {

	public List<UserHistory> findByUserId(int userId);
	
	public int countByMovieId(long movieId);
}