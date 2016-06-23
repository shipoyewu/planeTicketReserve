package com.mps.daoImp;

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
		List<Participate> allparticipate = super.findBy("id", true, Restrictions.sqlRestriction("teamid = " + teamid));
		return allparticipate;
	}
}
