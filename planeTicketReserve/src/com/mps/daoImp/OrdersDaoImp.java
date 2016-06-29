package com.mps.daoImp;


import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.mps.daoBase.BaseDao;
import com.mps.model.Orders;
import com.mps.util.DateUtils;

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
	
	
	@SuppressWarnings("unchecked")
	public List<String> getFlightList(){
		String sql="select DISTINCT flight from orders group by flight";
		return this.getSession().createSQLQuery(sql).list();
		//return this.queryBySql(sql);
		
		/*System.out.println();*/
	}
	/*public int getFlighttest(){
		int result;
		String sql="select flight from orders";
		result=this.excuteBySql(sql);
		return result;
	}*/
	public List<Orders> getAllFlight(String flight){
		return findBy("id",true,Restrictions.sqlRestriction("flight= '"+flight+"'"));
	}
	
	public List<Orders> getFlightMessage(String flight,String start){
		try {
			List<Orders> or=findBy("id",true,Restrictions.sqlRestriction("flight= '"+flight
					+"' and starttime= '"+start+"'"));
		    if(or!=null){
		    	return or;
		    }
		    return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} 
	}
	
	//xufuguo 
	public List<Orders> getTravellerOrders(String travellerid) {
		List<Orders> orders = super.findBy("id", false, Restrictions.sqlRestriction("travellerid='" + travellerid+"' and ticketstatus=0"));
		if (orders == null) {
			return null;
		} else {
			return orders;
		}
	}

	public List<Orders> getTravellerOrders(String startTime, String endTime, String startPoint, String endPoint,String teamid) {
		List<Orders> orders = null;
		 endTime=DateUtils.dateAddOne(endTime);
		if (startPoint.equals("全部")) {
			if (endPoint.equals("全部")) {
				orders = super.findBy("id", false,
						Restrictions.sqlRestriction("startTime>='" + startTime + "' and endTime<='" + endTime+"'and teamid='"+teamid+"'"));
			} else {
				orders = super.findBy("id", false,
						Restrictions.sqlRestriction("startTime>='" + startTime + "' and endTime<='" + endTime+"' and endPoint='"+endPoint+"'and teamid='"+teamid+"'"));
			}
		}else{
			if (endPoint.equals("全部")) {
				orders = super.findBy("id", false,
						Restrictions.sqlRestriction("startTime>='" + startTime + "' and endTime<='" + endTime+"' and startPoint='"+startPoint+"'and teamid='"+teamid+"'"));
			} else {
				orders = super.findBy("id", false,
						Restrictions.sqlRestriction("startTime>='" + startTime + "' and endTime<='" + endTime+"' and startPoint='"+startPoint+"' and endPoint='"+endPoint+"'and teamid='"+teamid+"'"));
			}
		}
		if (orders == null) {
			return null;
		} else {
			return orders;
		}
	}
	public List<Orders> getPrintedOrders(String travellerid,String flight){
		List<Orders> orders = super.findBy("id", false, Restrictions.sqlRestriction("travellerid='" + travellerid+"' and flight='"+flight+"'"));
		if (orders == null) {
			return null;
		} else {
			return orders;
		}
	}
	public void reviseTicketStatus(Orders orders){
		super.update(orders);
	}	
}
