package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public RequestDTO getById(@PathParam("id") Integer requestId) throws PatologyException{
		return requestService.getById(requestId);
	}

	@GET
	@Produces("application/xml")
	public RequestResult getAll() {
		return requestService.getAll();
	}

	@POST
	public RequestDTO save(RequestDTO request) {
		return requestService.save(request);
	}
	
	@GET
	@Path("/search/{textToFind}")
	@Produces("application/xml")
	public RequestResult search(@PathParam("textToFind") String textToFind) throws PatologyException{
		return requestService.find(textToFind);
	}
}

