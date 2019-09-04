package com.dc.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="dc_company")
public class CompanyProfileDTO {


	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger  id ;	
	
	@Column(name="NAME")
	private String	name;
	
	@Column(name="WEBSITE")
	private String	website;
	
	@Column(name="ADDRESS")
	private String  address;
	
	@Column(name="LOCATION")
	private String  location;

	@Column(name="CITY_ID")
	private Integer cityId;
	
	@Column(name="STATE_ID")
	private Integer stateId;
	
	@Column(name="PINCODE")
	private Integer pinCode;
	
	@Column(name="CRTD_BY")
	private String crtd_by;
	  
	@Temporal(TemporalType.DATE)
	@Column(name="CRTD_TMSTMP" ,insertable=false)
	private Date createdDate;
	
	@Column(name="MOD_BY")
	private String mdfd_by;
	  
	@Temporal(TemporalType.DATE)
	@Column(name="MOD_TMSTMP",insertable=false)
	private Date mdfdDate;
	
	@Column(name="STATUS")
	private boolean status;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getCrtd_by() {
		return crtd_by;
	}

	public void setCrtd_by(String crtd_by) {
		this.crtd_by = crtd_by;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getMdfd_by() {
		return mdfd_by;
	}

	public void setMdfd_by(String mdfd_by) {
		this.mdfd_by = mdfd_by;
	}

	public Date getMdfdDate() {
		return mdfdDate;
	}

	public void setMdfdDate(Date mdfdDate) {
		this.mdfdDate = mdfdDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
