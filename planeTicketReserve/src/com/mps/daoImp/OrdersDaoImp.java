package com.mps.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.binding.corba.wsdl.Array;

import com.mps.daoBase.BaseDao;
import com.mps.model.Flight;
import com.mps.model.Orders;

public class OrdersDaoImp extends BaseDao<Orders, Integer> {
	public OrdersDaoImp(){
		super(Orders.class);
	}
	@SuppressWarnings("unchecked")
	public List<Flight> getFlightList(){
		String sql="select flight from orders group by flight";
		List<Flight> flight=new ArrayList<Flight>();
		flight=this.getSession().createSQLQuery(sql).list();
		//return this.queryBySql(sql);
		
		/*System.out.println();*/
		return flight;
	}
	/*public int getFlighttest(){
		int result;
		String sql="select flight from orders";
		result=this.excuteBySql(sql);
		return result;
	}*/
}
