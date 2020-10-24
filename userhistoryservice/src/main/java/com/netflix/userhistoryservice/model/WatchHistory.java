package com.netflix.userhistoryservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WatchHistory {

	@JsonProperty("movie")
	private String movie;

	@JsonProperty("watchDate")
	private Date watchDate;	
	
	public WatchHistory(String movieName, Date watchDate) {
		this.movie = movieName;
		this.watchDate = watchDate;
	}
		
	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	public Date getWatchDate() {
		return watchDate;
	}

	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}
}
