package com.mps.daoImp;

import java.sql.Date;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Orders;

public class OrdersDaoImp extends BaseDao<Orders, Integer> {
	public OrdersDaoImp(){
		super(Orders.class);
	}
	public int getCountOfAirline(String code,Date time){
		return findBy("id", true, Restrictions.sqlRestriction("flight= '"+code+"' and starttime = '" + time+"'")).size();
	}
}
