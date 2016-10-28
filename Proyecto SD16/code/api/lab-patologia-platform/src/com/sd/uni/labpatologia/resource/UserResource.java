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
import com.sd.uni.labpatologia.service.user.IUserService;

@Path("/user")
@Component
public class UserResource {
	@Autowired
	private IUserService userService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public UserDTO getById(@PathParam("id") Integer usuarioId) {
		return userService.getById(usuarioId);
	}

	@GET
	@Produces("application/xml")
	public UserResult getAll() {
		return userService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public UserResult search(@PathParam("textToFind") String textToFind) {
		return userService.find(textToFind);
	}

	@POST
	public UserDTO save(UserDTO user) {
		
		return userService.save(user);
	}
}
