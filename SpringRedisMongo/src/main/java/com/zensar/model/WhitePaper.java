package com.zensar.model;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//@Data //Not working as of now - research on it
public class WhitePaper {//implements  Serializable{



		@Id
		//@JsonIgnore
	    private String id;
		
	    @Indexed
	    private String title;
	    
		private String author;
	    private String description;
	    
	    
	    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return "["+title+" "+author+" "+description+" ]";
	}
	

}
