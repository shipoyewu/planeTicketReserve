package com.mps.daoImp;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Traveller;

public class TravellerDaoImp extends BaseDao<Traveller, Integer> {
	public TravellerDaoImp(){
		super(Traveller.class);
	}
	public Traveller getTraveller(String idcard){
		List<Traveller> tras = super.findBy("id", true, Restrictions.sqlRestriction("idcard = '" + idcard + "'"));
		if(tras.size() != 1){
			return null;
		}
		else return tras.get(0);
	}
}
