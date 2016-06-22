package com.mps.daoImp;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Agency;

public class AgencyDaoImp extends BaseDao<Agency, Integer> {

	public AgencyDaoImp() {
		super(Agency.class);
		// TODO Auto-generated constructor stub
	}
	public int checkPassword(String phone, String psw){
		List<Agency> item = findBy("id", true, Restrictions.sqlRestriction("phone ='" + phone + "' and '" + psw + "'=pwd"));
		if(item.size() == 0)
			return 0;
		else return item.get(0).getId();
	}
	
}
