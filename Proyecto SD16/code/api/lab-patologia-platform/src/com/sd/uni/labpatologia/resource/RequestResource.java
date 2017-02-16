package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.request.IRequestService;

@Path("/request")
@Component
public class RequestResource {
	@Autowired
	private IRequestService requestService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })

	public RequestDTO getById(@PathParam("id") Integer requestId) throws PatologyException {
		return requestService.getById(requestId);
	}

	@GET
	@Produces("application/xml")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })
	public RequestResult getAll() throws PatologyException {
		return requestService.getAll();
	}
	
	@GET
	@Path("/count")
	@Produces("application/xml")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })
	public RequestResult getCount(){
		return requestService.getCount();
	}

	@POST
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public RequestDTO save(RequestDTO request) {
		return requestService.save(request);
	}

	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public RequestResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page,
			@PathParam("max") Integer maxItems) throws PatologyException {
		return requestService.find(textToFind, page, maxItems);
	}

	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public RequestResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems)
			throws PatologyException {
		return requestService.find(null, page, maxItems);
	}
}
