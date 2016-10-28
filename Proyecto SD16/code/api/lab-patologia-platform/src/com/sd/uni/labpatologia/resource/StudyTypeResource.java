package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.study_type.IStudyTypeService;

@Path("/estudio")
@Component
public class StudyTypeResource {
	@Autowired
	private IStudyTypeService estudioService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public StudyTypeDTO getById(@PathParam("id") Integer estudioId) throws PatologyException {
		return estudioService.getById(estudioId);
	}

	@GET
	@Produces("application/xml")
	public StudyTypeResult getAll() {
		return estudioService.getAll();
	}

	@POST
	public StudyTypeDTO save(StudyTypeDTO estudio) {
		return estudioService.save(estudio);
	}
}
