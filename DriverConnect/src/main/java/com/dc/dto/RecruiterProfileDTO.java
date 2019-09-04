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
@Table(name = "dc_recruiter_details")
public class RecruiterProfileDTO {

	@Id
	@Column(name = "REC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "F_NM")
	private String firstName;

	@Column(name = "L_NM")
	private String lastName;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "PHOTO_NAME")
	private String photoName;

	@Column(name = "PHOTO_PATH")
	private String photoPath;

	@Column(name = "COMPANY_ID")
	private BigInteger companyId;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "COMPANY_LOCATION")
	private String companyLocation;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNo;

	@Column(name = "EML")
	private String email;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "FLAG_HIRE")
	private String flagHire;

	@Column(name = "CRTD_BY")
	private String crtd_by;

	@Temporal(TemporalType.DATE)
	@Column(name = "CRTD_TMSTMP",insertable=false)
	private Date crtd_tmstmp;

	@Column(name = "MOD_BY")
	private String mdfd_by;

	@Temporal(TemporalType.DATE)
	@Column(name = "MOD_TMSTMP",insertable=false)
	private Date mdfd_tmstmp;

	@Column(name = "STATUS")
	private boolean status;

	@Column(name = "FIREBASE_ID")
	private String fireBaseId;

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

	public BigInteger getCompanyId() {
		return companyId;
	}

	public void setCompanyId(BigInteger companyId) {
		this.companyId = companyId;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
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

	public String getFireBaseId() {
		return fireBaseId;
	}

	public void setFireBaseId(String fireBaseId) {
		this.fireBaseId = fireBaseId;
	}

}
