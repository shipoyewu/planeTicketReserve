package com.mps.daoImp;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Participate;

public class ParticipateDaoImp extends BaseDao<Participate, Integer> {
	public ParticipateDaoImp(){
		super(Participate.class);
	}
	public List<Participate> getParticipByTeamId(int teamid){
		return findBy("id", true, Restrictions.sqlRestriction("teamid="+teamid));
	}
}
