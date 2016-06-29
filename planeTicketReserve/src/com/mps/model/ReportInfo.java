package com.mps.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ReportInfo")
public class ReportInfo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1461975132525973854L;
	/**
	 * 
	 */
	
	private String flight;
	private String startPoint;
	private String endPoint;
	private String startTime;
	private String endTime;
	private String fullPeo;
	private String actualPeo;
	private String singlePrice;
	private String totalPrice;
	
	public ReportInfo(){
		
	}

	
	public ReportInfo(String flight, String startPoint, String endPoint, String startTime, String endTime,
			String fullPeo, String actualPeo, String singlePrice, String totalPrice) {
		super();
		this.flight = flight;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fullPeo = fullPeo;
		this.actualPeo = actualPeo;
		this.singlePrice = singlePrice;
		this.totalPrice = totalPrice;
	}


	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFullPeo() {
		return fullPeo;
	}

	public void setFullPeo(String fullPeo) {
		this.fullPeo = fullPeo;
	}

	public String getActualPeo() {
		return actualPeo;
	}

	public void setActualPeo(String actualPeo) {
		this.actualPeo = actualPeo;
	}

	public String getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
