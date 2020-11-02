package com.streaming.userhistoryservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_userhistory")
public class UserHistory {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "movie_id")
	private long movieId;
	
	@Column(name = "watch_date")
	private Date watchDate;
	

	public UserHistory() {
		
	}
	
	public UserHistory(long movieId, long userId, Date watchDate) {
		this.movieId = movieId;
		this.userId = userId;
		this.watchDate = watchDate;
	}
	
	public UserHistory(int id, long movieId, long userId, Date watchDate) {
		this.id = id;
		this.movieId = movieId;
		this.userId = userId;
		this.watchDate = watchDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}
	
	public Date getWatchDate() {
		return watchDate;
	}
}
