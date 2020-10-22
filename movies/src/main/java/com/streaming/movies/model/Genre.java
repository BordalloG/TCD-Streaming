package com.streaming.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genre {

    public Genre() {}
    public Genre( String title) {
        Title = title;
    }

    @Id
    @GeneratedValue
    private long Id;
    private String Title;

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
}
