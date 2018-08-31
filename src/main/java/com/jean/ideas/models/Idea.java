package com.jean.ideas.models;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.Size;



@Entity
@Table(name= "ideas")
public class Idea {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Size(min=1, message="Idea cannot be empty")
	 private String ideaname;
	 private String creator;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User users;
	 
	 public Idea() {

		}
	 
	 



	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getIdeaname() {
		return ideaname;
	}





	public void setIdeaname(String ideaname) {
		this.ideaname = ideaname;
	}





	public String getCreator() {
		return creator;
	}





	public void setCreator(String creator) {
		this.creator = creator;
	}





	public Date getCreatedAt() {
		return createdAt;
	}





	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	public Date getUpdatedAt() {
		return updatedAt;
	}





	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}





	public User getUsers() {
		return users;
	}





	public void setUsers(User users) {
		this.users = users;
	}





	@PrePersist
	 protected void onCreate(){
	 this.createdAt = new Date();
	 }
	 

	@PreUpdate
	 protected void onUpdate(){
	        this.updatedAt = new Date();
	 }
}
	 

