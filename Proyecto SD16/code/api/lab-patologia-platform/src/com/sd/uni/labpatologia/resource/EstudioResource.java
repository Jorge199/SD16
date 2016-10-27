package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.estudio.EstudioDTO;
import com.sd.uni.labpatologia.dto.estudio.EstudioResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.estudio.IEstudioService;

@Path("/estudio")
@Component
public class EstudioResource {
	@Autowired
	private IEstudioService estudioService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public EstudioDTO getById(@PathParam("id") Integer estudioId) throws PatologyException {
		return estudioService.getById(estudioId);
	}

	@GET
	@Produces("application/xml")
	public EstudioResult getAll() {
		return estudioService.getAll();
	}

	@POST
	public EstudioDTO save(EstudioDTO estudio) {
		return estudioService.save(estudio);
	}
}
