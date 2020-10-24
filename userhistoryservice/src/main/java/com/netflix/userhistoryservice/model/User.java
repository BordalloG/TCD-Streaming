package com.netflix.userhistoryservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("createdDate")
	private Date createdDate;
	
	@JsonProperty("status")
	private int status;
	
	public User() {
		
	}

	public User(int id, String name, String password, Date createdDate, int status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.createdDate = createdDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}
