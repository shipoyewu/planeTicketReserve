package com.mps.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;


import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.OrdersDaoImp;
import com.mps.daoImp.ParticipateDaoImp;
import com.mps.daoImp.RouteDaoImp;
import com.mps.daoImp.TeamDaoImp;
import com.mps.daoImp.TravellerDaoImp;
import com.mps.iservice.Service;
import com.mps.util.JSONObjectUtils;
import com.mps.util.PostSplite;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import cn.com.WebXml.ServiceFacade;
import net.sf.json.JSONArray;

import com.google.gson.JsonObject;
import com.mps.daoImp.*;
import com.mps.model.*;

import java.util.Date;
import java.util.List;


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
	public String  updateAgencyInfo(String json){
		Map<String,String> ma = PostSplite.postchange(json);
		
		Agency agency = agencyDaoImp.get(Integer.parseInt(ma.get("agencyid")));
		agency.setPwd(ma.get("pwd"));
		agency.setPhone(ma.get("tel"));
		agency.setName(ma.get("agencyname"));
		agency.setAddress(ma.get("address"));
		agency.setContacts(ma.get("contacts"));
		try {
			agencyDaoImp.save(agency);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccess";
		}
		return "success";
		
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
	public String saveOrUpdatesTraveller(String name, String sex, String idcard, String tel, int agencyid) {
		// TODO Auto-generated method stub
		Traveller t = new Traveller();
		t.setAgency(agencyDaoImp.get(agencyid));
		t.setIdcard(idcard+"F");
		t.setName(name);
		t.setSex(sex);
		t.setPhone(tel);
		try {
			travellerDaoImp.save(t);
		} catch (Exception e) {
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
		List<Traveller> items = new ArrayList<Traveller>();
		items.add(travellerDaoImp.getTraveller(idcard+"F", agencyid));
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
			return "unsucc";
		}
		return "succ";
	}

	public String orderAirline(String json) {
		// TODO Auto-generated method stub
		
		Map<String, String> ma = PostSplite.postchange(json);
		JSONArray tre = null;
		try{
			String ww = ma.get("listtre");
			if(ww.charAt(ww.length()-1) == '\"'){
				ww = ww.substring(0,ww.length()-1);
			}
			tre =JSONArray.fromObject(ww);
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
		List<String> phone = new ArrayList<>();
		
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
					o.setAdvancestatus(1);
					o.setTicketstatus(0);
					Traveller t = null;
					try {
						o.setTeam(teamDaoImp.get(tre.getJSONObject(i).getInt("teamid")));
						t= travellerDaoImp.get(tre.getJSONObject(i).getInt("id"));
						phone.add(tre.getJSONObject(i).getString("phone"));
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
		StringBuilder sb = new StringBuilder();
		String ans = "";
		if(phone.size() > 0){
			for(String s:phone){
				sb.append(phone);
				sb.append(',');
			}
			ans = sb.toString().substring(0, sb.length()-1);
		}
		
		
		TaobaoClient client = 
			new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest","23390281", "14d2de25dc8047fc35985bce7d2aae3d");
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("学生项目");
		req.setSmsParamString("");
		req.setRecNum(ans);
		req.setSmsTemplateCode("SMS_10885001");
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				.add(p
				.getTraveller());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return items;
		}

	@Override
	public String joinToTeam(String uri) {
		// TODO Auto-generated method stub
		
		Map<String,String> ma = PostSplite.postchange(uri);
		String teamid = ma.get("teamid");
		System.out.println(teamid);
		JSONArray array = null;
		
		try{
			array = JSONArray.fromObject(ma.get("listtre"));
			System.out.println(array);
		}catch(Exception e){
			e.printStackTrace();
		}
		int size = array.size();
		Team team = teamDaoImp.get(Integer.parseInt(teamid));
		int max = 0;
		switch (team.getType()) {
		case 0:
			max = 10;
			break;

		case 1:
			max = 30;
			break;
		case 2:
			max = 100;
			break;
		}
		
		int now = participateDaoImp.getCountPeople(Integer.parseInt(teamid));
		if(size > max - now){
			return "unsucc";
		}
		for(int i = 0;i < array.size();i++){
			Participate pa = new Participate();
			pa.setJointime(new Date());
			pa.setTeam(team);
			pa.setTraveller(travellerDaoImp.get(array.getJSONObject(i).getInt("id")));
			participateDaoImp.save(pa);
		}
		return "success";
	}


	@Override
	public String updatesTraveller(int id, String name, String tel) {
		// TODO Auto-generated method stub
		Traveller t = travellerDaoImp.get(id);
		t.setPhone(tel);
		t.setName(name);
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
	public String advance(String json){
		try{
			Map<String,String> ma = PostSplite.postchange(json);
			JSONArray array = JSONArray.fromObject(ma.get("listtre"));
			String starttime = ma.get("starttime");
			String flght = ma.get("flght");
			for(int i = 0;i < array.size();i++){
				Orders a = ordersDaoImp.getOrderByTeamTravalFlight(
						flght, 
						starttime, 
						array.getJSONObject(i).getString("id"));
				a.setAdvancestatus(1);
				ordersDaoImp.save(a);
			}
			return "succ";
		}catch(Exception e){
			e.printStackTrace();
			return "unsucc";
		}
	}

	@Override
	public List<KeyValuePair> getListFlghtbyTeamId(int teamid) {
		List<Orders> orders = ordersDaoImp.getOrderByteam(""+teamid);
		List<KeyValuePair> keys = new ArrayList<>();
		
		for(Orders o: orders){
			KeyValuePair tem = new KeyValuePair();
			String kk = o.getFlight() + "("+o.getStarttime()+")";
			tem.setKey(kk);
			tem.setValue(kk);
			keys.add(tem);
		}
		return keys;
	}

	@Override
	public String addTeam(String json) {
		Map<String,String> ma = PostSplite.postchange(json);
		try{
			Team team = new Team();
			team.setAgency(agencyDaoImp.get(Integer.parseInt(ma.get("agencyid"))));
			team.setName(ma.get("teamnamea"));
			team.setPrincipal(ma.get("principala"));
			team.setPrinphone(ma.get("prinphonea"));
			SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
			team.setStarttime(dateform.parse(ma.get("starttimea")));
			team.setType(Integer.parseInt(ma.getOrDefault("typea","0")));	
			team.setStatus(0);
			teamDaoImp.save(team);
		}catch(Exception e ){
			e.printStackTrace();
			return "unsucc";
		}
		
		
		return "succ";
	}
	public String updateTeam(String json){
		Map<String,String> ma = PostSplite.postchange(json);
		Team team = teamDaoImp.get(Integer.parseInt(ma.get("teamide")));
		SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
		team.setName(ma.get("teamnamee"));
		team.setPrincipal(ma.get("principale"));
		team.setPrinphone(ma.get("prinphonee"));
		try {
			team.setStarttime(dateform.parse(ma.get("starttimee")));
			if(!ma.get("endtimee").equals("")){
				team.setEndtime(dateform.parse(ma.get("endtimee")));
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "unsuccess";
		}
		
		team.setType(Integer.parseInt(ma.getOrDefault("typee","0")));	
		team.setStatus(Integer.parseInt(ma.get("statee")));
		try{
			teamDaoImp.update(team);
		}catch(Exception e){
			e.printStackTrace();
			return "unsuccess";
		}
		return "success";
	}
	
	@Override
	public List<Traveller> getUnpartTraveller(String agencyid, String teamid) {
		// TODO Auto-generated method stub
		int aid = Integer.parseInt(agencyid);
		int tid = Integer.parseInt(teamid);
		List<Traveller> tras = travellerDaoImp.getAllTraveller(aid);
		List<Traveller> res = participateDaoImp.getUnpartTraveller(tid, tras);
		
		return res;
	}
	
	public List<Team> findTeamByPar(String pri,int agency){
		return teamDaoImp.getListTeamByPri(agency, pri);
	}
}
