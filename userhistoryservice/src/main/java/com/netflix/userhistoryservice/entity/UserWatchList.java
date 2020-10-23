package com.netflix.userhistoryservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_userwatchlist")
public class UserWatchList {

	@Id
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "registry_date")
	private Date registryDate;
	

	public UserWatchList() {
		
	}
	
	public UserWatchList(int id, int movieId, int userId, Date registryDate) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.userId = userId;
		this.registryDate = registryDate;
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
	
	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}
	
	public Date getRegistryDate() {
		return registryDate;
	}
}
