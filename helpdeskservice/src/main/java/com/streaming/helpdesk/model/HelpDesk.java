package com.streaming.helpdesk.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class HelpDesk {
	
	 @Id
	 @GeneratedValue
	 @JsonProperty("id")
	 private Long id;
	 @JsonProperty("title")
	 private String title;
	 @JsonProperty("description")
	 private String description;
	 @JsonProperty("user")
	 private String user;
	 
	 public HelpDesk ()
	 {}
	 
	 public Long getId() {
	        return id;
	    }
	 
	 public void setId(Long id) {
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

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}
}
