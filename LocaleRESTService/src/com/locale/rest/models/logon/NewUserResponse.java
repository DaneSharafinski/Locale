package com.locale.rest.models.logon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The response object after a user has made a 
 * new user request
 * 
 * @author Dane
 *
 */ 
@XmlRootElement(name="data")
public class NewUserResponse {

	
	@XmlElement(name = "userName")
	private String userName;

	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
