package com.mps.smodel;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="KeyValuePair")
public class KeyValuePair{
	public String code;
	public String name;
	public KeyValuePair(){
		
	}
	public KeyValuePair(String code,String name){
		this.code = code;
		this.name = name;	
	}
	
}
