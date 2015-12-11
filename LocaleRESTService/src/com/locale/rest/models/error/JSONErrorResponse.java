package com.locale.rest.models.error;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The object which contains error related details.
 * 
 * @author Dane
 *
 */ 
@XmlRootElement(name="error")
public class JSONErrorResponse {

	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
