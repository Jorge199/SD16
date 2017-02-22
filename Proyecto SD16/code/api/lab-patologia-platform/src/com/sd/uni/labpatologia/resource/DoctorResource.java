package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.doctor.IDoctorService;


@Path("/doctor")
@Component
public class DoctorResource {

	@Autowired
	private IDoctorService _doctorService;
	
	/* http://localhost:8080/lab-patologia-platform/rest/doctor/1 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DoctorDto getById(@PathParam("id") Integer doctorId) throws PatologyException {
		return _doctorService.getById(doctorId);
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/doctor */
	@GET
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DoctorResult getAll() throws PatologyException {
		return _doctorService.getAll();
	}
	
	@GET
	@Path("/count")
	@Produces("application/xml")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })
	public DoctorResult getCount(){
		return _doctorService.getCount();
	}

	
	/* http://localhost:8080/lab-patologia-platform/rest/doctor/search/textToFind */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DoctorResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _doctorService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DoctorResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _doctorService.find(null, page, maxItems);
	}

	@POST
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DoctorDto save(DoctorDto doctor) {
		return _doctorService.save(doctor);
	}
}
