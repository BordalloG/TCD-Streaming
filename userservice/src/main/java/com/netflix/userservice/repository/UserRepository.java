package com.netflix.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netflix.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {


}