package com.dc.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserProfileForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String userType;
	private String email;
	private String  photoName;
	private String  photoPath;
	
	private String otp;
	private String dob;
	private String licenseNumber;
	private String expDate;
	
	private String address;
	private Integer cityId;
	private Integer stateId;
	private Integer pinCode;
	
	private String userName;
	private String password;
	private String confirmPassword;
	private Date createdDate;
	private int createdBy;
	private Date mdfdDate;
	private int mdfdBy;
	
	private String userloginId;
	private String fireBaseId;
	private boolean status;
	
	private String currentWorkDetail;
	private String totalExp;
	private String currentWorkLocation;
	private String profSummary;
	private String highQualification;
	private String langKnown;
	
	
	
	private MultipartFile file;  

	
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getMdfdDate() {
		return mdfdDate;
	}
	public void setMdfdDate(Date mdfdDate) {
		this.mdfdDate = mdfdDate;
	}
	public int getMdfdBy() {
		return mdfdBy;
	}
	public void setMdfdBy(int mdfdBy) {
		this.mdfdBy = mdfdBy;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUserloginId() {
		return userloginId;
	}
	
	public void setUserloginId(String userloginId) {
		this.userloginId = userloginId;
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
