package com.streaming.helpdesk.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class HelpDesk {
	
	 @Id
	 @GeneratedValue
	 @JsonProperty("id")
	 private long id;
	 @JsonProperty("descricao")
	 private String descricao;
	 
	 public HelpDesk ()
	 {}
	 
	 public HelpDesk (String descricao)
	 {
		 this.descricao = descricao;
	 }
	 
	 public long getId() {
	        return id;
	    }
	 
	 public void setId(long id) {
	        this.id = id;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	

         }
}
