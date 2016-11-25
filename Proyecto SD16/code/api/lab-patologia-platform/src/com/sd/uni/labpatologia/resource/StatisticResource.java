package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.statistic.IStatisticService;

@Path("/statistic")
@Component
public class StatisticResource {
	@Autowired
	private IStatisticService _statisticService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })
	public StatisticDTO getById(@PathParam("id") Integer statisticId) throws PatologyException {
		return _statisticService.getById(statisticId);
	}

	@GET
	@Produces("application/xml")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })
	public StatisticResult getAll() throws PatologyException {
		return _statisticService.getAll();
	}

	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })
	public StatisticResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page,
			@PathParam("max") Integer maxItems) throws PatologyException {
		return _statisticService.find(textToFind, page, maxItems);
	}

	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR", "ROLE_SECRETARIA" })
	public StatisticResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems)
			throws PatologyException {
		return _statisticService.find(null, page, maxItems);
	}

	@POST
	@Secured({ "ROLE_ADMINISTRADOR", "ROLE_DOCTOR" })
	public StatisticDTO save(StatisticDTO statistic) {
		return _statisticService.save(statistic);
	}
}
