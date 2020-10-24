package com.streaming.movies.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Likes {

    public long getId() {
        return id;
    }
    public Likes(){}
    public Likes(long movieId, long userId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue
    private long id;
    private long movieId;
    private long userId;

}
