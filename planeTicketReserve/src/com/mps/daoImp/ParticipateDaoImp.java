package com.mps.daoImp;

import com.mps.daoBase.BaseDao;
import com.mps.model.Participate;

public class ParticipateDaoImp extends BaseDao<Participate, Integer> {
	public ParticipateDaoImp(){
		super(Participate.class);
	}
}
