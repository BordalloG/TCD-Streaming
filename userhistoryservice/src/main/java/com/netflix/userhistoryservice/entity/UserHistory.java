package com.netflix.userhistoryservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_userhistory")
public class UserHistory {

	@Id
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "view_date")
	private Date viewDate;
	

	public UserHistory() {
		
	}
	
	public UserHistory(int id, int movieId, int userId, Date viewDate) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.userId = userId;
		this.viewDate = viewDate;

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
	
	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	
	public Date getViewDate() {
		return viewDate;
	}
}
