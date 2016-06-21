package com.mps.daoImp;

import com.mps.daoBase.BaseDao;
import com.mps.model.Traveller;

public class TravellerDaoImp extends BaseDao<Traveller, Integer> {
	public TravellerDaoImp(){
		super(Traveller.class);
	}
}
