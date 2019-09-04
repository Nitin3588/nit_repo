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
@Table(name = "dc_sub_usr")
public class UserProfileDTO {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "F_NM")
	private String firstName;

	@Column(name = "L_NM")
	private String lastName;

	@Column(name = "MOB_NO")
	private String mobileNo;

	@Column(name = "USR_NM")
	private String userName;

	@Column(name = "USR_PWD")
	private String password;

	@Column(name = "EML")
	private String email;

	@Column(name = "PHOTO_NAME")
	private String photoName;

	@Column(name = "PHOTO_PATH")
	private String photoPath;
	
	@Column(name = "OTP")
	private String otp;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "LICENSE_NO")
	private String licenseNumber;

	@Column(name = "EXP_DATE")
	private String expDate;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "STATE_ID")
	private Integer stateId;

	@Column(name = "PINCODE")
	private Integer pinCode;

	@Column(name = "CITY_ID")
	private String cityId;

	@Column(name = "AUTH_PASS_FLAG")
	private boolean authPassFlag;

	@Column(name = "PASS_RESET")
	private boolean passReset;

	@Column(name = "CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE",insertable=false)
	private Date createdDate;

	@Column(name = "UPDATED_BY")
	private int mdfdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "MOD_TMSTMP",insertable=false)
	private Date mdfdDate;

	@Column(name = "STATUS")
	private boolean status;

	@Column(name = "FIREBASE_ID")
	private String fireBaseId;
	
	@Column(name = "CURRENT_WORK_DETAIL")
	private String currentWorkDetail;

	@Column(name = "TOTAL_EXP")
	private String totalExp;
	
	@Column(name = "CURRENT_WORK_LOCATION")
	private String currentWorkLocation;
	
	@Column(name = "PROF_SUMMARY")
	private String profSummary;
	
	@Column(name = "HIGH_QUALIFICATION")
	private String highQualification;
	
	@Column(name = "LANG_KNOWN")
	private String langKnown;
	
	
	
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
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

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAuthPassFlag() {
		return authPassFlag;
	}

	public void setAuthPassFlag(boolean authPassFlag) {
		this.authPassFlag = authPassFlag;
	}

	public boolean isPassReset() {
		return passReset;
	}

	public void setPassReset(boolean passReset) {
		this.passReset = passReset;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getMdfdBy() {
		return mdfdBy;
	}

	public void setMdfdBy(int mdfdBy) {
		this.mdfdBy = mdfdBy;
	}

	public Date getMdfdDate() {
		return mdfdDate;
	}

	public void setMdfdDate(Date mdfdDate) {
		this.mdfdDate = mdfdDate;
	}

	public String getFireBaseId() {
		return fireBaseId;
	}

	public void setFireBaseId(String fireBaseId) {
		this.fireBaseId = fireBaseId;
	}

	public String getCurrentWorkDetail() {
		return currentWorkDetail;
	}

	public void setCurrentWorkDetail(String currentWorkDetail) {
		this.currentWorkDetail = currentWorkDetail;
	}

	public String getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(String totalExp) {
		this.totalExp = totalExp;
	}

	public String getCurrentWorkLocation() {
		return currentWorkLocation;
	}

	public void setCurrentWorkLocation(String currentWorkLocation) {
		this.currentWorkLocation = currentWorkLocation;
	}

	public String getProfSummary() {
		return profSummary;
	}

	public void setProfSummary(String profSummary) {
		this.profSummary = profSummary;
	}

	public String getHighQualification() {
		return highQualification;
	}

	public void setHighQualification(String highQualification) {
		this.highQualification = highQualification;
	}

	public String getLangKnown() {
		return langKnown;
	}

	public void setLangKnown(String langKnown) {
		this.langKnown = langKnown;
	}

}
