package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.patient.IPatientService;

@Path("/patient")
@Component
public class PatientResource {

	@Autowired
	private IPatientService _patientService;

	/* http://localhost:8080/lab-patologia-platform/rest/patient/1 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public PatientDTO getById(@PathParam("id") Integer patientId) throws PatologyException {
		return _patientService.getById(patientId);
	}

	/* http://localhost:8080/lab-patologia-platform/rest/patient */
	@GET
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA","ROLE_TECNICO"})
	public PatientResult getAll() throws PatologyException {
		return _patientService.getAll();
	}

	/*
	 * http://localhost:8080/lab-patologia-platform/rest/patient/search/
	 * textToFind
	 */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public PatientResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page,
			@PathParam("max") Integer maxItems) throws PatologyException {
		return _patientService.find(textToFind, page, maxItems);
	}

	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public PatientResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems)
			throws PatologyException {
		return _patientService.find(null, page, maxItems);
	}

	@POST
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public PatientDTO save(PatientDTO patient) {
		return _patientService.save(patient);
	}
}
