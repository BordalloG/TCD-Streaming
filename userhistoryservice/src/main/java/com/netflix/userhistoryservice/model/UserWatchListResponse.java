package com.netflix.userhistoryservice.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWatchListResponse {

	@JsonProperty("userId")
	private int id;

	@JsonProperty("userName")
	private String userName;

	@JsonProperty("watchList")
	private List<WatchList> watchList;
	
	public UserWatchListResponse(int id, String userName) {
		this.id = id;
		this.userName = userName;
	}
	
	public void addMovieToWatchList(String movieName, Date registryDate) {
		this.watchList.add(new WatchList(movieName, registryDate));	
	}

}
