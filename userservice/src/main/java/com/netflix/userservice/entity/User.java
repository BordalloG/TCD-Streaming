package com.netflix.userservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "status")
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
