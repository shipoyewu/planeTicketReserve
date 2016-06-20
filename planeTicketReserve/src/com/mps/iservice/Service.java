package com.mps.iservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

aram;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.annotations.Param;

import org.jboss.logging.annotations.Param;public interface Service {
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/test")
	public void test();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("saveTraveller/{name}/{sex}/{idcard}/{tel}")
	public String saveOrUpdatesTraveller(@PathParam("name")String name, @PathParam("sex") String sex,
								@PathParam("idcard")String idcard, @PathParam("tel") String tel);
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("saveTraveller/{name}/{sex}/{idcard}/{tel}")
	public String saveOrUpdatesTraveller(@PathParam("name")String name, @PathParam("sex") String sex,
								@PathParam("idcard")String idcard, @PathParam("tel") String tel);N});c String getTravellerById(@PathParam("id") int id);
	
@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getTravellerByIdCard/{idcard}/{agencyid}")
	public String getTravellerByIdCard(@PathParam("idcard") String idcard, @PathParam("agencyid") int agencyid);PPLICATION_JSON})
	@Path("getTravellerById/{id}")
	public String getTravellerById(@PathParam("id") int id);/{idcard}/{agencyid}")
	public String getTravellerByIdCard(@PathParam("idcard
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getTravellerByIdCard/{idcard}/{agencyid}")
	public String getTravellerByIdCard(@PathParam("idcard") String idcard, @PathParam("agencyid") int agencyid);") String idcard, @PathParam("agencyid") int agencyid);
}
