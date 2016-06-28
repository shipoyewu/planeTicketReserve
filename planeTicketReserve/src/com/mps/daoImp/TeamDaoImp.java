package com.mps.daoImp;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Team;

public class TeamDaoImp extends BaseDao<Team, Integer> {
	public TeamDaoImp(){
		super(Team.class);
	}
	public List<Team> getListTeam(int agencyid){
		List<Team> allteam = super.findBy("id", true, Restrictions.sqlRestriction("agencyid = " + agencyid +" and status = 0 "));
		return allteam;
	}
	public List<Team> getListTeamByPri(int agencyid,String name){
		List<Team> allteam = findBy("id",true,Restrictions.sqlRestriction("agencyid = " + agencyid +" and status = 0 " + " and principal='"+name+"'"));
		return allteam;
				
	}
	
}