package com.mps.daoImp;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Traveller;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Traveller;

public class TravellerDaoImp extends BaseDao<Traveller, Integer> {
	public TravellerDaoImp(){
		super(Traveller.class);
	}
	
}
