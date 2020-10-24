package com.netflix.userhistoryservice.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WatchList {

	@JsonProperty("movie")
	private String movie;

	@JsonProperty("registryDate")
	private Date registryDate;	
	
	public WatchList(String movieName, Date registryDate) {
		this.movie = movieName;
		this.registryDate = registryDate;
	}
		
	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	public Date getRegistryDate() {
		return registryDate;
	}

	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}
}
