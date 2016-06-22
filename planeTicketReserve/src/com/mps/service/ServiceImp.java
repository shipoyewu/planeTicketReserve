package com.mps.service;

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
import com.mps.model.Agency;
import com.mps.model.Traveller;
import com.mps.util.PostSplite;

import cn.com.WebXml.ServiceFacade;

public class ServiceImp implements Service {

	public TravellerDaoImp travellerDaoImp;
	public AgencyDaoImp agencyDaoImp;
	public ServiceFacade webService;
	public OrdersDaoImp ordersDaoImp;
	public ParticipateDaoImp participateDaoImp;
	public TeamDaoImp teamDaoImp;
	public RouteDaoImp routeDaoImp;
	
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
	

}
