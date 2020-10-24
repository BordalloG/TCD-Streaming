package com.netflix.userhistoryservice.model;

public class MovieViewsCount {

	private String movieName;
	
	private int numberOfViews;
	
	public MovieViewsCount(String movieName, int numberOfViews)
	{
		this.movieName = movieName;
		this.numberOfViews = numberOfViews;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(int numberOfViews) {
		this.numberOfViews = numberOfViews;
	}
	
}
