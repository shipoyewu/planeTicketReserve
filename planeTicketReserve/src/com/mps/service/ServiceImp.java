package com.mps.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.OrdersDaoImp;
import com.mps.daoImp.ParticipateDaoImp;
import com.mps.daoImp.RouteDaoImp;
import com.mps.daoImp.TeamDaoImp;
import com.mps.daoImp.TravellerDaoImp;
import com.mps.iservice.Service;
import com.mps.util.JSONObjectUtils;
import com.mps.util.PostSplite;

import cn.com.WebXml.ServiceFacade;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.JsonObject;
import com.mps.daoImp.*;
import com.mps.model.*;

import java.util.Date;
import java.util.List;


public class ServiceImp implements Service {
	public ServiceFacade webService;
	public AgencyDaoImp agencyDaoImp;
	public OrdersDaoImp ordersDaoImp;
	public ParticipateDaoImp participateDaoImp;
	public RouteDaoImp routeDaoImp;
	public TeamDaoImp teamDaoImp;
	public TravellerDaoImp travellerDaoImp;


	
	public RouteDaoImp getRouteDaoImp() {
		return routeDaoImp;
	}

	public void setRouteDaoImp(RouteDaoImp routeDaoImp) {
		this.routeDaoImp = routeDaoImp;
	}

	public OrdersDaoImp getOrdersDaoImp() {
		return ordersDaoImp;
	}

	public void setOrdersDaoImp(OrdersDaoImp ordersDaoImp) {
		this.ordersDaoImp = ordersDaoImp;
	}

	public ParticipateDaoImp getParticipateDaoImp() {
		return participateDaoImp;
	}

	public void setParticipateDaoImp(ParticipateDaoImp participateDaoImp) {
		this.participateDaoImp = participateDaoImp;
	}

	public TeamDaoImp getTeamDaoImp() {
		return teamDaoImp;
	}

	public void setTeamDaoImp(TeamDaoImp teamDaoImp) {
		this.teamDaoImp = teamDaoImp;
	}

	public ServiceImp() {
		super();
	}
	
	public TravellerDaoImp getTravellerDaoImp() {
		return travellerDaoImp;
	}

	public void setTravellerDaoImp(TravellerDaoImp travellerDaoImp) {
		this.travellerDaoImp = travellerDaoImp;
	}

	public AgencyDaoImp getAgencyDaoImp() {
		return agencyDaoImp;
	}

	public void setAgencyDaoImp(AgencyDaoImp agencyDaoImp) {
		this.agencyDaoImp = agencyDaoImp;
	}

	public ServiceFacade getWebService() {
		return webService;
	}

	public void setWebService(ServiceFacade webService) {
		this.webService = webService;
	}


	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "shihu";
	}

	@Override
	public String getAirLines(String json) {
		// TODO Auto-generated method stub
		Map<String, String> ma = PostSplite.postchange(json);
		String start = ma.get("start");
		String end  = ma.get("end");
		String date = ma.get("date");
		
		String str = webService.getAirLines(start, end, date);
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("\\]", "");
		str = "["+str+"]";
		return str;
	}
	
	@Override
	public List<Team> getListTeam(int agencyid){
		List<Team> allteam = teamDaoImp.getListTeam(agencyid);
		System.out.println(allteam.size());
		return allteam;
	}
	
	@Override
	public Agency getAgencyInfoByAgencyid(int agencyid){
		Agency agency = agencyDaoImp.getAgencyInfoByAgencyid(agencyid);
		if(agency == null)
			return null;
		else
			return agency;
	}
	
	@Override
	public void updateAgencyInfo(String pwd,String agencyname,String address,String contacts,String phonenumber){
		Agency agency = new Agency();
		agency.setPwd(pwd);
		agency.setPhone(phonenumber);
		agency.setName(agencyname);
		agency.setAddress(address);
		agency.setContacts(contacts);
		try {
			agencyDaoImp.save(agency);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveOrupdateTeam(String name,Date starttime,Date endtime,int type,int status,Agency agency){
			Team team = new Team();
			team.setName(name);
			team.setStarttime(starttime);
			team.setEndtime(endtime);
			team.setStatus(status);
			team.setType(type);
			team.setAgency(agency);
			try {
				teamDaoImp.save(team);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public String saveOrUpdatesTraveller(String name, String sex, String idcard, String tel) {
		// TODO Auto-generated method stub
		Traveller t = new Traveller();
		t.setAgency(agencyDaoImp.get(2));///---------------------------test
		t.setIdcard(idcard);
		t.setName(name);
		t.setSex(sex);
		t.setPhone(tel);
		try {
			travellerDaoImp.save(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsucc";
		}
		return "succ";
	}

	@Override
	public List<Traveller> getAllTraveller(int agencyid) {
		// TODO Auto-generated method stub
		List<Traveller> t = travellerDaoImp.getAllTraveller(agencyid);
		System.out.println("size:"+t.size());
		return t;
	}

	@Override
	public List<Traveller> getTravellerByIdCard(String idcard, int agencyid) {
		// TODO Auto-generated method stub
		agencyid = 2;
		List<Traveller> items = new ArrayList<Traveller>();
		items.add(travellerDaoImp.getTraveller(idcard, agencyid));
		return items;
	}

	@Override
	public int checkLoginUser(String para) {
		// TODO Auto-generated method stub
		String[] paras = para.split("&");
		System.out.println("postfangfa:"+para);
		return agencyDaoImp.checkPassword(paras[0], paras[1]);
	}

	@Override
	public String register(String para) {
		// TODO Auto-generated method stub
		//联系人&手机号&旅行社名&密码&地址
		String[] paras = para.split("&");
		Agency agency = new Agency();
		agency.setContacts(paras[0]);
		agency.setPhone(paras[1]);
		agency.setName(paras[2]);
		agency.setPwd(paras[3]);
		agency.setAddress(paras[4]);
		try {
			agencyDaoImp.save(agency);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unSuccess";
		}
		return "Success";
	}

	@Override
	public String orderAirline(String json) {
		// TODO Auto-generated method stub
		
		Map<String, String> ma = PostSplite.postchange(json);
		JSONArray tre = null;
		try{
			String ww = ma.get("listtre");
			if(ww.charAt(ww.length()-1) == '\"'){
				ww = ww.substring(0,ww.length()-1);
			}
			tre = JSONArray.fromObject(ww);
		}catch(Exception e){
			e.printStackTrace();
		}
		Orders a = new Orders();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(1232);
		a.setFlight(ma.get("airlinecode"));
		try{
			a.setStarttime(sdf.parse(ma.get("starttime")));
			a.setEndtime(sdf.parse(ma.get("arrivetime")));
			a.setStartpoint(ma.get("startdrome"));
			a.setEndpoint(ma.get("arrivedrome"));
			a.setPrice(50.0);
		}catch(Throwable e){
			e.printStackTrace();
		}
			
		synchronized (ordersDaoImp) {
			int count =ordersDaoImp.getCountOfAirline(a.getFlight(), a.getStarttime());
			System.out.println("111");
			int cc = tre.size();
			if(cc <= 60-count){
				for(int i = 0;i < cc;i++){
					Orders o = new Orders();
					o.setFlight(a.getFlight());
					o.setStarttime(a.getStarttime());
					o.setEndtime(a.getEndtime());
					o.setEndpoint(a.getEndpoint());
					o.setStartpoint(a.getStartpoint());
					o.setSpace(0);
					o.setSeat(cc+i);
					o.setPrice(50.0);
					o.setAdvancestatus(0);
					o.setTicketstatus(0);
					Traveller t = null;
					try {
						o.setTeam(teamDaoImp.get(tre.getJSONObject(i).getInt("teamid")));
						t= travellerDaoImp.get(tre.getJSONObject(i).getInt("id"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "unsucc:内部错误!";
					}
					o.setTraveller(t);
					ordersDaoImp.save(o);
				}
			}else{
				return "unscc:座位不够！";
			}
		}
		return "succ";
	}
	
	@Override
	public List<Traveller> getTraverllerByTeam(int teamid) {
		// TODO Auto-generated method stub
		List<Traveller> items = new ArrayList<Traveller>();
		List<Participate> ps = participateDaoImp.getParticipByTeamId(teamid);
		System.out.println(ps.size());
		try {
			for(Participate p : ps){
				items
				.add(travellerDaoImp
				.get(p
				.getId()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return items;
		}

}
