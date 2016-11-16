package com.sd.uni.labpatologia.resource;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.user.IUserService;

@Path("/user")
@Component
public class UserResource {
	@Autowired
	private IUserService userService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public UserDTO getById(@PathParam("id") Integer userId) throws PatologyException {
		return userService.getById(userId);

	}

	@GET
	@Produces("application/xml")
	public UserResult getAll() throws PatologyException {
		return userService.getAll();
	}

	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public UserResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return userService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public UserResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return userService.find(null, page, maxItems);
	}

	@POST
	public UserDTO save(UserDTO user) {
		return userService.save(user);
	}
	@GET
	@Path("/username/{username}")
	@Produces("application/json")
	public UserDTO getByUsername(@PathParam("username") String username) {
		return userService.getByUsername(username);
	}
}
