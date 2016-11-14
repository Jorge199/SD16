package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.report.IReportService;

@Path("/report")
@Component
public class ReportResource {
	@Autowired
	private IReportService reportService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ReportDTO getById(@PathParam("id") Integer reportId) throws PatologyException {
		return reportService.getById(reportId);
	}

	@GET
	@Produces("application/xml")
	public ReportResult getAll() throws PatologyException {
		return reportService.getAll();
	}

	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public ReportResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return reportService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public ReportResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return reportService.find(null, page, maxItems);
	}
	
	@POST
	public ReportDTO save(ReportDTO report) {
		return reportService.save(report);
	}
}
