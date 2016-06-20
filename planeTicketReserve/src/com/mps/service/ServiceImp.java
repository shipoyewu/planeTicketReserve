package com.mps.service;
import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.TravellerDaoImp;
import java.util.Map;

import com.mps.iservice.Service;
import com.mps.model.Traveller;
import com.mps.util.PostSplite;

import cn.com.WebXml.ServiceFacade;

public class ServiceImp implements Service {

	TravellerDaoImp tdi;
	AgencyDaoImp adi;
	public AgencyDaoImp getAdi() {
		return adi;
	}

	public void setAdi(AgencyDaoImp adi) {
		this.adi = adi;
	}

	public TravellerDaoImp getTdi() {
		return tdi;
	}

	public void setTdi(TravellerDaoImp tdi) {
		this.tdi = tdi;
	}
	public ServiceFacade webService;

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
		t.setAgency(adi.get(2));///---------------------------test
		t.setIdcard(idcard);
		t.setName(name);
		t.setSex(sex);
		t.setPhone(tel);
		try {
			tdi.save(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsucc";
		}
		return "succ";
	}

	@Override
	public String getTravellerById(int id) {
		// TODO Auto-generated method stub
		Traveller t = tdi.get(id);
		if(t == null)
			return null;
		else 
			return "succ";
	}

	@Override
	public String getTravellerByIdCard(String idcard, int agencyid) {
		// TODO Auto-generated method stub
		Traveller t = tdi.getTraveller(idcard, agencyid);
		if(t == null)
			return null;
		else 
			return "succ";
	}

}
