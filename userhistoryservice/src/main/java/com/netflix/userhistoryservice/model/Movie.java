package com.netflix.userhistoryservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

	@JsonProperty("id")
    private long id;
    
	@JsonProperty("title")
    private String title;
	
	@JsonProperty("description")
    private String description;
	
	@JsonProperty("year")
    private int year;
	
	@JsonProperty("likes")
    private int likes;
	
	@JsonProperty("genre")
    private Genre genre;

    public Movie(){}

    public Movie(String title, String description, int year, Genre genre) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
