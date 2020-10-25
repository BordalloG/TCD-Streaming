package com.netflix.userhistoryservice.model;

public class MovieViewsCount {

	private String movieName;
	
	private String genre;
	
	private int numberOfViews;
	
	public MovieViewsCount(String movieName, String genre, int numberOfViews)
	{
		this.movieName = movieName;
		this.genre = genre;
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
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
