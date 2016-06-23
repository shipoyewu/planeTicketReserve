package com.mps.iservice;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mps.model.Agency;
import com.mps.model.Team;

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
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/getListTeam/{agencyid}")
	public List<Team> getListTeam(@PathParam("agencyid")int agencyid);
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/getAgencyInfoByAgencyid/{agencyid}")
	public Agency getAgencyInfoByAgencyid(@PathParam("agencyid")int agencyid);
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/updateAgencyInfo/{pwd}/{agencyname}/{address}/{contacts}/{phonenumber}")
	public void updateAgencyInfo(@PathParam("pwd")String pwd,@PathParam("agencyname")String agencyname,
			@PathParam("address")String address,@PathParam("contacts")String contacts,
			@PathParam("phonenumber")String phonenumber);

}
 