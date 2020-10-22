package com.streaming.movies.model;

import javax.persistence.*;


@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue
    private long Id;
    private String Title;
    private String Description;
    private int Year;
    @ManyToOne(optional = false)
    private Genre Genre;

    public com.streaming.movies.model.Genre getGenre() {
        return Genre;
    }

    public void setGenre(com.streaming.movies.model.Genre genre) {
        Genre = genre;
    }

    public Movie(){
        super();
    }

    public Movie(String title, String description, int year, Genre genre) {
        Title = title;
        Description = description;
        Year = year;
        this.Genre = genre;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
