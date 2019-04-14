package com.dc.bean;

import java.math.BigInteger;

public class CityForm {
	
	
	private BigInteger  id; 
	private String cityName ;
	private Integer stateCode ;
	boolean status;
	
	
	public BigInteger getId() {
		return id;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public Integer getStateCode() {
		return stateCode;
	}
	
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
	
		this.status = status;
	} 
	

	
}
