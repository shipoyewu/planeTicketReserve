package com.mps.daoImp;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Traveller;

public class TravellerDaoImp extends BaseDao<TravellerDaoImp, Integer> {
	public TravellerDaoImp(){
		super(TravellerDaoImp.class);
	}
	public List<Traveller> getListTeam(int team){
		List<Traveller> allteam = super.findBy("id", true, Restrictions.sqlRestriction("agencyid = " + agencyid +"and status = 0"));
		return allteam;
	}
}
