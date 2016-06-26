package com.mps.iservice;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mps.model.Flight;
import com.mps.model.Orders;


@Path("/Service")
public interface Service {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/test")
	public String test();
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getAirLines")
	public String getAirLines(String json);
	
	//liushuo
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getFlight")
	//@Produces({MediaType.TEXT_PLAIN})
    public List<Flight> getFlight();
	
}
