package com.dc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dc_recruiter_details")
public class RecruiterProfileDTO {
	
	
	@Id
	@Column(name="REC_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="FULL_NAME")
	private String 	fullName;

	  
	@Column(name="PHOTO_NAME")
	private String  photoName;

	  
	@Column(name="PHOTO_PATH")
	private String  photoPath;

	  
	@Column(name="COMPANY_NAME")
	private String  companyName;

	  
	@Column(name="COMPANY_LOCATION")
	private String  companyLocation;

	  
	@Column(name="MOBILE_NUMBER")
	private String  mobileNumber;

	@Column(name="COUNTRY")
	private String  country;

	  
	@Column(name="FLAG_HIRE")
	private String  flagHire;

	  
	@Column(name="CRTD_BY")
	private String crtd_by;
	  
	@Column(name="CRTD_TMSTMP")
	private Date crtd_tmstmp;
	
	@Column(name="MOD_BY")
	private String mdfd_by;
	  
	@Column(name="MOD_TMSTMP")
	private Date mdfd_tmstmp;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getCrtd_by() {
		return crtd_by;
	}

	public void setCrtd_by(String crtd_by) {
		this.crtd_by = crtd_by;
	}

	public Date getCrtd_tmstmp() {
		return crtd_tmstmp;
	}

	public void setCrtd_tmstmp(Date crtd_tmstmp) {
		this.crtd_tmstmp = crtd_tmstmp;
	}

	public String getMdfd_by() {
		return mdfd_by;
	}

	public void setMdfd_by(String mdfd_by) {
		this.mdfd_by = mdfd_by;
	}

	public Date getMdfd_tmstmp() {
		return mdfd_tmstmp;
	}

	public void setMdfd_tmstmp(Date mdfd_tmstmp) {
		this.mdfd_tmstmp = mdfd_tmstmp;
	}
	
	  
	  


}
