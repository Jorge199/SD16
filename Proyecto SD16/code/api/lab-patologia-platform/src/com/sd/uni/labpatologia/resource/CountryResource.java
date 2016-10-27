package com.sd.uni.labpatologia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.country.CountryDTO;
import com.sd.uni.labpatologia.dto.country.CountryResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.country.ICountryService;

@Path("/country")
@Component
public class CountryResource {
	@Autowired
	private ICountryService countryService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public CountryDTO getById(@PathParam("id") Integer countryId) throws PatologyException {
		return countryService.getById(countryId);
	}

	@GET
	@Produces("application/xml")
	public CountryResult getAll() {
		return countryService.getAll();
	}

	@POST
	public CountryDTO save(CountryDTO country) {
		return countryService.save(country);
	}
}
