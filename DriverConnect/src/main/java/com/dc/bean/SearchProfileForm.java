package com.dc.bean;

import java.util.List;

public class SearchProfileForm {

	private  String sub_id;
	private String recId;
	private int cityId;
	private int expReq;
	private String fromDate;
	private String toDate;
	
	private  String employmentType;
	private Integer salaryAnnual;
	private String  vechicleType; 
	
	private List<Integer> cityList;
	private List<String> vechicleList;
	
	
	UserProfileForm userForm=new UserProfileForm();


	public UserProfileForm getUserForm() {
		return userForm;
	}
	public void setUserForm(UserProfileForm userForm) {
		this.userForm = userForm;
	}
	public String getSub_id() {
		return sub_id;
	}
	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getExpReq() {
		return expReq;
	}
	public void setExpReq(int expReq) {
		this.expReq = expReq;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public Integer getSalaryAnnual() {
		return salaryAnnual;
	}
	public void setSalaryAnnual(Integer salaryAnnual) {
		this.salaryAnnual = salaryAnnual;
	}
	public String getVechicleType() {
		return vechicleType;
	}
	public void setVechicleType(String vechicleType) {
		this.vechicleType = vechicleType;
	}
	public List<Integer> getCityList() {
		return cityList;
	}
	public void setCityList(List<Integer> cityList) {
		this.cityList = cityList;
	}
	public List<String> getVechicleList() {
		return vechicleList;
	}
	public void setVechicleList(List<String> vechicleList) {
		this.vechicleList = vechicleList;
	}
	
	
}
