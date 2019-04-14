package com.dc.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;

public class CompanyProfileForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger  id;	
	private String	name;
	private String	website;
	private String  location;
	private String  address;
	private Integer cityId;
	private Integer stateId;
	private Integer pinCode;
	private String crtd_by;
	private Date createdDate;
	private String mdfd_by;
	private Date mdfdDate;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCrtd_by() {
		return crtd_by;
	}
	public void setCrtd_by(String crtd_by) {
		this.crtd_by = crtd_by;
	}
	public Date getMdfdDate() {
		return mdfdDate;
	}
	public void setMdfdDate(Date mdfdDate) {
		this.mdfdDate = mdfdDate;
	}
	public String getMdfd_by() {
		return mdfd_by;
	}
	public void setMdfd_by(String mdfd_by) {
		this.mdfd_by = mdfd_by;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}


}
