package com.mps.daoImp;

import com.mps.daoBase.BaseDao;
import com.mps.model.Team;

public class TeamDaoImp extends BaseDao<Team, Integer> {
	public TeamDaoImp(){
		super(Team.class);
	}
}
