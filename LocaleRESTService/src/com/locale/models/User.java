package com.locale.models;

public class User {

	
	private Integer userId;
	private String displayName;
	private String userName;
	private Integer isFacebook;
	private String latToken;
	
	
	
	
	public boolean isFacebook() {
		return this.isFacebook == 1 ? true : false;
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	public String getLatToken() {
		return latToken;
	}
	public void setLatToken(String latToken) {
		this.latToken = latToken;
	}
	
	
	
	
}
