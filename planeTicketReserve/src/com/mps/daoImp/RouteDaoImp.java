package com.mps.daoImp;

import com.mps.daoBase.BaseDao;
import com.mps.model.Route;

public class RouteDaoImp extends BaseDao<Route, Integer> {
	public RouteDaoImp(){
		super(Route.class);
	}
}
