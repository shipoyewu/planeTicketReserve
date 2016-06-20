package com.mps.iservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
}
