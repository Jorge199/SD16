package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticDto;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.diagnostic.IDiagnosticService;


@Path("/diagnostic")
@Component
public class DiagnosticResource {

	@Autowired
	private IDiagnosticService _diagnosticService;
	
	/* http://localhost:8080/lab-patologia-platform/rest/diagnostic/1 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DiagnosticDto getById(@PathParam("id") Integer diagnosticId) throws PatologyException {
		return _diagnosticService.getById(diagnosticId);
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/diagnostic */
	@GET
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DiagnosticResult getAll() throws PatologyException {
		return _diagnosticService.getAll();
	}

	
	/* http://localhost:8080/lab-patologia-platform/rest/diagnostic/search/textToFind */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DiagnosticResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _diagnosticService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DiagnosticResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _diagnosticService.find(null, page, maxItems);
	}

	@POST
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA"})
	public DiagnosticDto save(DiagnosticDto diagnostic) {
		return _diagnosticService.save(diagnostic);
	}
}
