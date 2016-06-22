package com.mps.iservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Service")
public interface Service {
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/test")
	public String test();
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	@Path("saveOrUpdatesTraveller/{name}/{sex}/{idcard}/{tel}")
	public String saveOrUpdatesTraveller(@PathParam("name")String name, @PathParam("sex") String sex,
								@PathParam("idcard")String idcard, @PathParam("tel") String tel);
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getTravellerByIdCard/{idcard}/{agencyid}")
	public String getTravellerByIdCard(@PathParam("idcard") String idcard, @PathParam("agencyid") int agencyid);
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getTravellerById/{id}")
	public String getTravellerById(@PathParam("id") int id);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getAirLines")
	public String getAirLines(String json);
	
	
}
