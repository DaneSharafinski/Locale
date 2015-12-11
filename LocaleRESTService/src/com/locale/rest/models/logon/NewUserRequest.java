package com.locale.rest.models.logon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The request object which contains credentials for a new
 * request
 * 
 * @author Dane
 *
 */ 
@XmlRootElement(name="data")
public class NewUserRequest {

	
	@XmlElement(name="userName")
	private String userName;

	
	@XmlElement(name="userPwd")
	private String userPwd;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	
}
