package com.netflix.userhistoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netflix.userhistoryservice.entity.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Integer> {

}