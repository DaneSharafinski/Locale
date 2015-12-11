package com.locale.rest.service.feed;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.locale.dao.FeedDAO;
import com.locale.rest.models.feed.FeedItem;

@Path("/feed")
public class FeedService {

	FeedDAO dao = new FeedDAO();
	
	/**
	 * Gets the information to be displayed on user (id)'s feed.
	 * @param userId - The unique id of the user.
	 */
	@GET 
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<FeedItem> feedById(@PathParam("id") String userId,
									@HeaderParam("LAT") String latToken) {
		
		// Authenticate the User with the LAT
		
		
		return dao.findByUserId(Integer.parseInt(userId));
	}
	
	
	
}
