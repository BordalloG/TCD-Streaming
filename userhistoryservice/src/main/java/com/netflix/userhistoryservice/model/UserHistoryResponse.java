package com.netflix.userhistoryservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHistoryResponse {

	@JsonProperty("userId")
	private int id;

	@JsonProperty("userName")
	private String userName;

	@JsonProperty("history")
	private List<WatchHistory> history;
	
	public UserHistoryResponse(int id, String userName) {
		this.id = id;
		this.userName = userName;
		this.history = new ArrayList<>();
	}
	
	public void addMovieToHistory(String movieName, Date watchDate) {

		this.history.add(new WatchHistory(movieName, watchDate));	
	}

}
