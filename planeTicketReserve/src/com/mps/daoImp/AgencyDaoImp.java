package com.mps.daoImp;

import com.mps.daoBase.BaseDao;
import com.mps.model.Agency;

import java.util.List;

import org.hibernate.criterion.Restrictions;

public class AgencyDaoImp extends BaseDao<Agency, Integer> {

	public AgencyDaoImp() {
		super(Agency.class);
		// TODO Auto-generated constructor stub
	}

	public Agency getAgencyInfoByAgencyid(int agencyid){
		List<Agency> agency = super.findBy("id", true, Restrictions.sqlRestriction("id = " + agencyid));
		if(agency.size() != 1)
			return null;
		else
			return agency.get(0);
		
	}
}
