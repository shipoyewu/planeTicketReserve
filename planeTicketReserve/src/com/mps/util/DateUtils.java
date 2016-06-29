package com.mps.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

public class DateUtils {
	private static DateFormat format2= new SimpleDateFormat("yyyy-MM-dd"); 
	public static Date stringToDate(String datestr){
		  Date date = null;   
		  try {   
		             date = format2.parse(datestr);  
		  } catch (Exception e) {   
		             e.printStackTrace();   
		  }   
		  System.out.println(date);
		  return date;
		 }
	public static String dateAddOne(String datestr){
		String dateAdd="";
		try {
			 Calendar c = Calendar.getInstance();
			 c.setTime(DateUtils.stringToDate(datestr));
			 c.add(Calendar.DAY_OF_MONTH, 1); 
			 dateAdd=c.getTime().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateAdd;
	}
}
