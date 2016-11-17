package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService;


@Path("/laboratory")
@Component
public class LaboratoryResource {

	@Autowired
	private ILaboratoryService _laboratoryService;
	
	/* http://localhost:8080/lab-patologia-platform/rest/laboratory/1 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR"})
	public LaboratoryDto getById(@PathParam("id") Integer laboratoryId) throws PatologyException {
		return _laboratoryService.getById(laboratoryId);
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/laboratory */
	@GET
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA","ROLE_TECNICO"})
	public LaboratoryResult getAll() throws PatologyException {
		return _laboratoryService.getAll();
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/laboratory/search/textToFind */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR"})
	public LaboratoryResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _laboratoryService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR"})
	public LaboratoryResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _laboratoryService.find(null, page, maxItems);
	}

	@POST
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR"})
	public LaboratoryDto save(LaboratoryDto laboratory) {
		return _laboratoryService.save(laboratory);
	}
}
