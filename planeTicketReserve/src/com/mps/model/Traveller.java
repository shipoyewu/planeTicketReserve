package com.mps.model;
// Generated 2016-6-24 20:12:03 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Traveller generated by hbm2java
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name = "traveller", catalog = "planeticketreserve")
@XmlRootElement(name="Traveller")
public class Traveller implements java.io.Serializable {

	private Integer id;
	private Agency agency;
	private String sex;
	private String name;
	private String idcard;
	private String phone;


	public Traveller() {
	}

	public Traveller(Agency agency) {
		this.agency = agency;
	}

	public Traveller(Agency agency, String sex, String name, String idcard, String phone) {
		this.agency = agency;
		this.sex = sex;
		this.name = name;
		this.idcard = idcard;
		this.phone = phone;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agencyid", nullable = false)
	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	@Column(name = "sex", length = 25)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "name", length = 25)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "idcard", length = 25)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "phone", length = 25)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
