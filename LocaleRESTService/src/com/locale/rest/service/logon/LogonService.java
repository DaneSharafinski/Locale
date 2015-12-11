package com.locale.rest.service.logon;


import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.locale.dao.LogonDAO;
import com.locale.rest.models.error.JSONErrorResponse;
import com.locale.rest.models.logon.NewUserRequest;
import com.locale.rest.models.logon.NewUserResponse;



@Path("/logon")
public class LogonService {
/*
	@Context  //injected response proxy supporting multiple threads
	private HttpServletResponse response;
*/
	
	LogonDAO logonDao = new LogonDAO();
	
	
	/**
	 * Gets the information to be displayed on user (id)'s feed.
	 * @param userId - The unique id of the user.
	 * @throws AccessDeniedException 
	 */
	@POST 
	@Path("new")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Response createNewUser(NewUserRequest newUserReq, @Context final HttpServletResponse response)  {
		
		NewUserResponse r = new NewUserResponse();
		
		r.setUserName(newUserReq.getUserName());
		
		// Get the data from the request payload
		String userName = newUserReq.getUserName();
		String userPwd = newUserReq.getUserPwd();
		
		// Check string for malicious characters
		//if userName.contains()
		
		// Verify unique
		Integer userId = logonDao.getUserIdByLogonName(userName);
		 

		if (userId != null) {
			JSONErrorResponse erp = new JSONErrorResponse();
			erp.setMessage("Requested username not unique");
			return  Response.status(Response.Status.CONFLICT.getStatusCode()).entity(erp).build();
		}
		// else create the user
		else {
			Integer rowsUpd = logonDao.createUserLogonName(userName, userPwd);
			if (rowsUpd != 1) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
			}
		}
		
		return Response.ok().build();

	}
	
	
	
	
	
	
}
