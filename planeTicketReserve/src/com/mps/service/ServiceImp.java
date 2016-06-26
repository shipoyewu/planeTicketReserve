package com.mps.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mps.daoImp.OrdersDaoImp;
import com.mps.iservice.Service;
import com.mps.model.Flight;
import com.mps.model.Orders;
import com.mps.util.PostSplite;

import cn.com.WebXml.ServiceFacade;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ServiceImp implements Service {
	
	public ServiceFacade webService;

	public ServiceFacade getWebService() {
		return webService;
	}

	public void setWebService(ServiceFacade webService) {
		this.webService = webService;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "shihu";
	}

	@Override
	public String getAirLines(String json) {
		// TODO Auto-generated method stub
		Map<String, String> ma = PostSplite.postchange(json);
		String start = ma.get("start");
		String end  = ma.get("end");
		String date = ma.get("date");
		
		String str = webService.getAirLines(start, end, date);
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("\\]", "");
		str = "["+str+"]";
	
		return str;
	}
    //liushuo
	private OrdersDaoImp ordersDaoImp;
	public OrdersDaoImp getOredersDaoImp() {
		return ordersDaoImp;
	}

	public void setOrdersDaoImp(OrdersDaoImp OrdersDaoImp) {
		this.ordersDaoImp = OrdersDaoImp;
	}
	@Override
	public List<Flight> getFlight() {
		// TODO Auto-generated method stub 
       System.out.println("liushuo----");
	   try {
		   List<Flight> flight=new ArrayList<Flight>();
		   System.out.println(ordersDaoImp);
		   //flight.addAll(ordersDaoImp.getFlightList());
		   flight=ordersDaoImp.getFlightList();
		   System.out.println(flight);
		   String f=JSONArray.fromObject(flight).toString();
		   System.out.println(f);
		   System.out.println(flight.size());
		  
		  /* String[] a=f.split(",");
		   for(String i: a){
			   i="fight"+i;
			   System.out.println(i);
		   }*/
		   return flight;
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
       
	   //System.out.println(flight+"liushuo");
      
	   
	}

}
