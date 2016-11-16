package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.study_type.IStudyTypeService;

@Path("/study_type")
@Component
public class StudyTypeResource {
	@Autowired
	private IStudyTypeService studyTypeService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public StudyTypeDTO getById(@PathParam("id") Integer estudioId) throws PatologyException {
		return studyTypeService.getById(estudioId);
	}

	@GET
	@Produces("application/xml")
	public StudyTypeResult getAll() throws PatologyException {
		return studyTypeService.getAll();
	}
	
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public StudyTypeResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return studyTypeService.find(textToFind, page, maxItems);
	}

	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public StudyTypeResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return studyTypeService.find(null, page, maxItems);
	}
	
	@POST
	public StudyTypeDTO save(StudyTypeDTO estudio) {
		return studyTypeService.save(estudio);
	}
}
