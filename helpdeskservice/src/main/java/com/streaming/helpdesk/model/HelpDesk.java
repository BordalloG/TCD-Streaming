package com.streaming.helpdesk.model;

import javax.persistence.*;

@Entity
@Table
public class HelpDesk {
	
	 @Id
	 @GeneratedValue
	 private long id;
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
