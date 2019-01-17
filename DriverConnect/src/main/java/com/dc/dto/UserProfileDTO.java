package com.dc.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dc_sub_usr")
public class UserProfileDTO {


	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name="F_NM")
	private String firstName; 

	@Column(name="L_NM") 
	private String lastName;

	@Column(name="MOB_NO") 
	private String mobileNo;  

	@Column(name="USR_NM") 
	private String userName;  

	@Column(name="USR_PWD") 
	private String password;  

	@Column(name="EML") 
	private String email;  

	@Column(name="OTP") 
	private String otp;  

	@Column(name="DOB") 
	private String dob;  

	@Column(name="CITY_ID") 
	private String cityId;  
	
	@Column(name="STATUS") 
	private boolean status;  

	@Column(name="AUTH_PASS_FLAG") 
	private boolean authPassFlag;  
	
	@Column(name="PASS_RESET") 
	private boolean passReset;  

	@Column(name="CREATED_BY")
	private int createdBy;

	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="UPDATED_BY")
	private int mdfdBy;

	@Column(name="MOD_TMSTMP")
	private Date mdfdDate;

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

	

/*	private String address;
	private String userType;
	private String licenseNumber;
	private String expDate;
	private String password;
	private String confirmPassword;

*/
}
