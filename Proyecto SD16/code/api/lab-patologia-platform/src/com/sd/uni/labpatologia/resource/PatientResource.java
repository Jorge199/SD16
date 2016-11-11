package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
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
	public PatientDTO getById(@PathParam("id") Integer patientId) throws PatologyException {
		return _patientService.getById(patientId);
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/patient */
	@GET
	@Produces("application/xml")
	public PatientResult getAll() {
		return _patientService.getAll();
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/patient/search/textToFind */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public PatientResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _patientService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public PatientResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _patientService.find(null, page, maxItems);
	}

	@POST
	public PatientDTO save(PatientDTO patient) {
		return _patientService.save(patient);
	}
}
