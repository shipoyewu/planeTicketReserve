package com.mps.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Participate;
import com.mps.model.Traveller;

public class ParticipateDaoImp extends BaseDao<Participate, Integer> {
	public ParticipateDaoImp(){
		super(Participate.class);
	}
	public List<Participate> getListTeam(int teamid){
		List<Participate> allparticipate = findBy("id", true, Restrictions.sqlRestriction("teamid = " + teamid));
		return allparticipate;
	}
	public List<Participate> getParticipByTeamId(int teamid){
		return findBy("id", true, Restrictions.sqlRestriction("teamid="+teamid));
	}
	public int getCountPeople(int teamid){
		return findBy("id",true,Restrictions.sqlRestriction("teamid='"+teamid+"'")).size();
	}
	public List<Traveller> getUnpartTraveller(int teamid, List<Traveller> tras){
		if(tras == null)
			return null;
		List<Participate> items = getParticipByTeamId(teamid);
		List<Traveller> partTras = new ArrayList<Traveller>();
		List<Traveller> unpart = new ArrayList<Traveller>();
		for(Participate p : items){
			partTras.add(p.getTraveller());
		}
		System.out.println("partsize:"+partTras.size());
		int flag = 0;
		for(Traveller t1 : tras){
			flag = 0;
			for(Traveller t2 : partTras){
				if(t1.equals(t2)){
					//System.out.println(t1.toString()+"=="+t2.toString());
					flag = 1;
					break;
				}
			}
			if(flag == 0)
				unpart.add(t1);
		}
		return unpart;
	}
	
	
}
