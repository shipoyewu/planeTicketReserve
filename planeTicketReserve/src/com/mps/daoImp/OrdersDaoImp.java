package com.mps.daoImp;


import java.util.Date;
import java.util.List;

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
	public Orders getOrderByTeamTravalFlight(String flght,String date,String treid){
		return findBy("id", true, Restrictions.sqlRestriction("flight='"+flght
				+"' and starttime ='" + date+"' and treid= '"+treid+"' and stauts=0")).get(0);
	}
	public List<Orders> getOrderByteam(String teamid){
		return findBy("id",true,Restrictions.sqlRestriction("teamid='"+teamid
				+"' and status='0'"));
	}
}
