package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.stock_mov.StockDTO;
import com.sd.uni.labpatologia.dto.stock_mov.StockResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.stock_mov.IStockService;


@Path("/stock")
@Component
public class StockResource {

	@Autowired
	private IStockService _stockService;
	
	/* http://localhost:8080/lab-patologia-platform/rest/stock/1 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public StockDTO getById(@PathParam("id") Integer stockId) throws PatologyException {
		return _stockService.getById(stockId);
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/stock */
	@GET
	@Produces("application/xml")
	@Secured({"SUPERUSER"})
	public StockResult getAll() throws PatologyException {
		return _stockService.getAll();
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/stock/search/textToFind */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public StockResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _stockService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public StockResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _stockService.find(null, page, maxItems);
	}
	
	@POST
	public StockDTO save(StockDTO art) {
		return _stockService.save(art);
	}

}
