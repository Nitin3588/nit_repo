package com.dc.bean;

public class UserBean extends AbstractBean {

	private String Name ;
	private String mobileNo;
	private String address;
	private String userType;

	
	String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	

	
	
}
