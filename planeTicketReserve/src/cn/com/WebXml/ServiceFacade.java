package cn.com.WebXml;

import java.io.File;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.apache.cxf.jaxrs.provider.json.utils.JSONUtils;
import org.apache.xmlbeans.impl.tool.XMLBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.Messaging.SyncScopeHelper;

import com.mps.util.Xml2JsonUtil;

import net.sf.json.JSON;

public class ServiceFacade {
	static DomesticAirline service = null;
	static DomesticAirlineSoap client = null;
	static {
		service = new DomesticAirlineLocator();
		client = null;
		
		try {
			client = service.getDomesticAirlineSoap();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getAirLines(String start,String end,String date){
		String re = null;
		
		try {
			GetDomesticAirlinesTimeResponseGetDomesticAirlinesTimeResult
				res = client.getDomesticAirlinesTime(start, end, date, "");
			
			MessageElement[] mes = res.get_any();
			List body = mes[1].getChildren();
			if(body.size() <= 0){
				return new JSONArray().toString();
			}
			String nn = Xml2JsonUtil.xml2JSON(body.get(0).toString());
			JSONObject json;
			try {
				json = new JSONObject(nn);
				re = json.getJSONObject("Airlines")
				.getJSONArray("AirlinesTime").toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return re;
	}
	
	public String getAllCity(){
		String re = null;
		try{
			GetDomesticCityResponseGetDomesticCityResult res= 
					client.getDomesticCity();
			MessageElement[] me = res.get_any();
			List body = me[1].getChildren();
			if(body.size() < 0) {
				return new JSONArray().toString();
			}
			String nn = Xml2JsonUtil.xml2JSON(body.get(0).toString());
			JSONObject json;
			try {
				json = new JSONObject(nn);
				re = json.getJSONObject("Airline1")
				.getJSONArray("Address").toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return re;
		
	}
	public static void main(String args[]) throws JSONException{
		System.out.println(new ServiceFacade().getAirLines("ÄÏÑô", "Ö£ÖÝ", "2016-6-20").replaceAll("\\[", ""));
	}
}
