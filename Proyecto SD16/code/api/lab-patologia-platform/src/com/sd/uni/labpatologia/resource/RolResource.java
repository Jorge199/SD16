package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.rol.RolDTO;
import com.sd.uni.labpatologia.dto.rol.RolResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.rol.IRolService;

@Path("/rol")
@Component
public class RolResource {
	@Autowired
	private IRolService rolService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public RolDTO getById(@PathParam("id") Integer rolId) throws PatologyException {
		return rolService.getById(rolId);
	}

	@GET
	@Produces("application/xml")
	public RolResult getAll() {
		return rolService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public RolResult search(@PathParam("textToFind") String textToFind) {
		return rolService.find(textToFind);
	}

	@POST
	public RolDTO save(RolDTO country) {
		return rolService.save(country);
	}
}
