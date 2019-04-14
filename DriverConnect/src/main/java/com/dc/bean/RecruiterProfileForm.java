package com.dc.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class RecruiterProfileForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	private String  firstName;
	private String  lastName;
	private String 	fullName;
	private String  photoName;
	private String  photoPath;
	private String  companyName;
	private String  companyLocation;
	private String  mobileNo;
	private String  email;
	private String  country;
	private String  flagHire;
	private String  dob;
	private String  currentDesignation;
	private String  companySummary;
	private String  userType;
	private String  createdBy;
	private String  mdfdBy;
	private Date  mdfdDate;
	private Date  createdDate;
	private boolean status;
	private String fireBaseId;
	
	private CompanyProfileForm  companyProfileForm;

	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getMdfdDate() {
		return mdfdDate;
	}
	public void setMdfdDate(Date mdfdDate) {
		this.mdfdDate = mdfdDate;
	}
	public String getMdfdBy() {
		return mdfdBy;
	}
	public void setMdfdBy(String mdfdBy) {
		this.mdfdBy = mdfdBy;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyLocation() {
		return companyLocation;
	}
	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFlagHire() {
		return flagHire;
	}
	public void setFlagHire(String flagHire) {
		this.flagHire = flagHire;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCurrentDesignation() {
		return currentDesignation;
	}
	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}
	public String getCompanySummary() {
		return companySummary;
	}
	public void setCompanySummary(String companySummary) {
		this.companySummary = companySummary;
	}
	public String getFireBaseId() {
		return fireBaseId;
	}
	public void setFireBaseId(String fireBaseId) {
		this.fireBaseId = fireBaseId;
	}
	public CompanyProfileForm getCompanyProfileForm() {
		return companyProfileForm;
	}
	public void setCompanyProfileForm(CompanyProfileForm companyProfileForm) {
		this.companyProfileForm = companyProfileForm;
	}
	@Override
	public String toString() {
		return "RecruiterProfileForm [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", photoName=" + photoName + ", photoPath=" + photoPath + ", companyName=" + companyName
				+ ", companyLocation=" + companyLocation + ", mobileNo=" + mobileNo + ", email=" + email + ", country="
				+ country + ", flagHire=" + flagHire + ", dob=" + dob + ", currentDesignation=" + currentDesignation
				+ ", companySummary=" + companySummary + ", userType=" + userType + ", createdBy=" + createdBy
				+ ", mdfdBy=" + mdfdBy + ", mdfdDate=" + mdfdDate + ", createdDate=" + createdDate + ", status="
				+ status + ", fireBaseId=" + fireBaseId + ", companyProfileForm=" + companyProfileForm + "]";
	}
	
	
	
	
	

}