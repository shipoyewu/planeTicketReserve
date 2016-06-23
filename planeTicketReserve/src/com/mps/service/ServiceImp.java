package com.mps.service;

import com.mps.iservice.Service;

import com.mps.daoImp.*;
import com.mps.model.*;

import java.util.Date;
import java.util.List;


public class ServiceImp implements Service {
	
	public AgencyDaoImp agencyDaoImp;
	public OrdersDaoImp ordersDaoImp;
	public ParticipateDaoImp participateDaoImp;
	public RouteDaoImp routeDaoImp;
	public TeamDaoImp teamDaoImp;
	public TravellerDaoImp travellerDaoImp;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Team> getListTeam(int agencyid){
		List<Team> allteam = teamDaoImp.getListTeam(agencyid);
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
}
