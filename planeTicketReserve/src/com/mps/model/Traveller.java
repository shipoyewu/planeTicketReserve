package com.mps.model;
// Generated 2016-6-18 9:41:43 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Traveller generated by hbm2java
 */
public class Traveller implements java.io.Serializable {

	private Integer id;
	private Agency agency;
	private String sex;
	private String name;
	private String idcard;
	private String phone;
	private Set participates = new HashSet(0);
	private Set orderses = new HashSet(0);

	public Traveller() {
	}

	public Traveller(Agency agency) {
		this.agency = agency;
	}

	public Traveller(Agency agency, String sex, String name, String idcard, String phone, Set participates,
			Set orderses) {
		this.agency = agency;
		this.sex = sex;
		this.name = name;
		this.idcard = idcard;
		this.phone = phone;
		this.participates = participates;
		this.orderses = orderses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getParticipates() {
		return this.participates;
	}

	public void setParticipates(Set participates) {
		this.participates = participates;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}
