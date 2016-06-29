package com.mps.iservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import com.mps.model.Agency;
import com.mps.model.KeyValuePair;
import com.mps.model.Orders;
import com.mps.model.ReportInfo;
import com.mps.model.Team;
import com.mps.model.Ticket;
import com.mps.model.Traveller;
import com.mps.smodel.*;

@Path("/Service")
public interface Service {
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/test")
	public String test();
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	@Path("saveOrUpdatesTraveller/{name}/{sex}/{idcard}/{tel}/{agencyid}")
	public String saveOrUpdatesTraveller(@PathParam("name")String name, @PathParam("sex") String sex,
								@PathParam("idcard")String idcard, @PathParam("tel") String tel, @PathParam("agencyid")int agencyid);
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	@Path("updatesTraveller/{id}/{name}/{tel}")
	public String updatesTraveller(@PathParam("id")int id, @PathParam("name")String name,  @PathParam("tel") String tel);
	
	@GET
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("getTravellerByIdCard/{idcard}/{agencyid}")
	public List<Traveller> getTravellerByIdCard(@PathParam("idcard") String idcard, @PathParam("agencyid") int agencyid);
	
	@GET
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("getAllTraveller/{agencyid}")
	public List<Traveller> getAllTraveller(@PathParam("agencyid") int agencyid);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getAirLines")
	public String getAirLines(String json);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getListTeam/{agencyid}")
	public List<Team> getListTeam(@PathParam("agencyid")int agencyid);
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getAgencyInfoByAgencyid/{agencyid}")
	public Agency getAgencyInfoByAgencyid(@PathParam("agencyid")int agencyid);
	
	@POST
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/updateAgencyInfo")
	public String updateAgencyInfo(String json);
	

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
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/orderAirline")
	public String orderAirline(String jsons);
	
	@POST
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getTraverllerByTeam/{teamid}")
	public List<Traveller> getTraverllerByTeam(@PathParam("teamid") int teamid);

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/joinToTeam")
	public String joinToTeam(String uri);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/advance")
	public String advance(String jsons);
	
	@POST
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getListFlghtbyTeamId/{teamid}")
	public List<KeyValuePair> getListFlghtbyTeamId(@PathParam("teamid") int teamid);
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/addTeam")
	public String addTeam(String json);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/updateTeam")
	public String updateTeam(String json);
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("getUnpartTraveller/{agencyid}/{teamid}")
	public List<Traveller> getUnpartTraveller(@PathParam("agencyid") String agencyid, @PathParam("teamid") String teamid);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/findTeamByPar/{pri}/{agency}")
	public List<Team> findTeamByPar(@PathParam("pri")String pri,@PathParam("agency")int agency);
	
	
	//liushuo
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getFlight")
	//@Produces({MediaType.TEXT_PLAIN})
    public ArrayList<com.mps.smodel.KeyValue> getFlight();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getFlightMessage/{flight}/{start}")
    public Orders getFlightMessage(@PathParam("flight")String flight,@PathParam("start")String start);
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/doCancel/{flight}")
    public String doCancel(@PathParam("flight")String flight);
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/doDelay/{flight}")
    public String doDelay(@PathParam("flight")String flight);
	
	//xufuguo 
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/createReport")
	public List<ReportInfo> createReport(String data);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/reviseTicketStatus/{orderid}")
	public void reviseTicketStatus(@PathParam("orderid") String orderid);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/printTicket/{idcard}")
	public List<Ticket> printTicket(@PathParam("idcard") String idcard);
}
 