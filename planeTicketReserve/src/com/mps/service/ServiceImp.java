package com.mps.service;

import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.TravellerDaoImp;
import com.mps.iservice.Service;
import com.mps.model.Traveller;

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

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
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
