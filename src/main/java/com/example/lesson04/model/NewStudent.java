package com.example.lesson04.model;

import java.util.Date;

public class NewStudent {
   private int id;
   private String name;
   private int phoneNumber;
   private String email;
   private String dreamJob;
   private Date createdAt;
   private Date updatedAt;

   
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDreamJob() {
		return dreamJob;
	}
	public void setDreamJob(String dreamJob) {
		this.dreamJob = dreamJob;
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
   
   
   
}
