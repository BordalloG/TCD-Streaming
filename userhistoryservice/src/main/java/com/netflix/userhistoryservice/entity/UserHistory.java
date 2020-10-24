package com.netflix.userhistoryservice.entity;

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
	private int userId;

	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "watch_date")
	private Date watchDate;
	

	public UserHistory() {
		
	}
	
	public UserHistory(int movieId, int userId, Date watchDate) {
		this.movieId = movieId;
		this.userId = userId;
		this.watchDate = watchDate;
	}
	
	public UserHistory(int id, int movieId, int userId, Date watchDate) {
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

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}
	
	public Date getWatchDate() {
		return watchDate;
	}
}
