package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
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
	public LaboratoryDto getById(@PathParam("id") Integer laboratoryId) throws PatologyException {
		return _laboratoryService.getById(laboratoryId);
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/laboratory */
	@GET
	@Produces("application/xml")
	public LaboratoryResult getAll() {
		return _laboratoryService.getAll();
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/laboratory/search/textToFind */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public LaboratoryResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _laboratoryService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public LaboratoryResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _laboratoryService.find(null, page, maxItems);
	}

	@POST
	public LaboratoryDto save(LaboratoryDto laboratory) {
		return _laboratoryService.save(laboratory);
	}
}
