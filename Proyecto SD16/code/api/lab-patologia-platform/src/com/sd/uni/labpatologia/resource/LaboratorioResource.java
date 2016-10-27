package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioDto;
import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioResult;
import com.sd.uni.labpatologia.service.laboratorio.ILaboratorioService;


@Path("/laboratory")
@Component
public class LaboratorioResource {

	@Autowired
	private ILaboratorioService _labService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public LaboratorioDto getById(@PathParam("id") Integer laboratoryId) {
		return _labService.getById(laboratoryId);
	}

	@GET
	@Produces("application/xml")
	public LaboratorioResult getAll() {
		return _labService.getAll();
	}
	
	@GET
	@Path("/search/{textToFind}")
	@Produces("application/xml")
	public LaboratorioResult search(@PathParam("textToFind") String textToFind) {
		return _labService.find(textToFind);
	}

	@POST
	public LaboratorioDto save(LaboratorioDto lab) {
		return _labService.save(lab);
	}
}
