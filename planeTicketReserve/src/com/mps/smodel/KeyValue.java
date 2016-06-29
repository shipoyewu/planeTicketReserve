package com.mps.smodel;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="KeyValue")
public class KeyValue{
	public String code;
	public String name;
	public KeyValue(){
		
	}
	public KeyValue(String code,String name){
		this.code = code;
		this.name = name;	
	}
	
}
