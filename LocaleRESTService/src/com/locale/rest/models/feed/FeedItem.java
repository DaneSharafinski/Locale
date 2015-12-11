package com.locale.rest.models.feed;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The object which contains a user's Locale (their post).
 * 
 * @author Dane
 *
 */ 
@XmlRootElement(name="feedItem")
public class FeedItem {

	
	private String displayName;
	
	private Integer userId;
	
	private Timestamp timeStamp;

	
	
	
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
