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
import com.mps.model.Traveller;

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
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("getTravellerByIdCard/{idcard}/{agencyid}")
	public List<Traveller> getTravellerByIdCard(@PathParam("idcard") String idcard, @PathParam("agencyid") int agencyid);
	
	@GET
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("getAllTraveller/{agencyid}")
	public List<Traveller> getAllTraveller(@PathParam("agencyid") int agencyid);
	
	
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
	

	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/updateAgencyInfo/{name}/{starttime}/{endtime}/{type}/{status}/{agency}")
	public void saveOrupdateTeam(@PathParam("name")String name,@PathParam("starttime")Date starttime,
			@PathParam("endtime")Date endtime,@PathParam("type")int type,@PathParam("status")int status,@PathParam("agency")Agency agency);
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/checkLoginUser")
	public int checkLoginUser(String para);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/register")
	public String register(String para);
}
 