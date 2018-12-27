package com.dc.bean;

public class ContactDetailForm {

	
	
	private String emerContactNumber;
	private String houseNoDetail;
	private String colonyName;
	private String landmark;
	private Integer pincode;
	private String city;
	private String state;
	private String country;
	public String getEmerContactNumber() {
		return emerContactNumber;
	}
	public void setEmerContactNumber(String emerContactNumber) {
		this.emerContactNumber = emerContactNumber;
	}
	public String getHouseNoDetail() {
		return houseNoDetail;
	}
	public void setHouseNoDetail(String houseNoDetail) {
		this.houseNoDetail = houseNoDetail;
	}
	public String getColonyName() {
		return colonyName;
	}
	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "ContactDetailForm [emerContactNumber=" + emerContactNumber + ", houseNoDetail=" + houseNoDetail
				+ ", colonyName=" + colonyName + ", landmark=" + landmark + ", pincode=" + pincode + ", city=" + city
				+ ", state=" + state + ", country=" + country + "]";
	}
	
	
	
}
