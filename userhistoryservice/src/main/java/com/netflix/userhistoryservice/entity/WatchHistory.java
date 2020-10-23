package com.netflix.userhistoryservice.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WatchHistory {

	@JsonProperty("movie")
	private String movie;

	@JsonProperty("watchDate")
	private Date watchDate;	
	
	@JsonProperty("history")
	private List<WatchHistory> history;
}
