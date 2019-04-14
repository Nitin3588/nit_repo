package com.dc.bean;

import java.security.Timestamp;
import java.util.Date;

public class OTPForm extends AbstractBean{

	private Timestamp expDate;
	private String  mobileNumber;
	private String pin;
	
	
	public Timestamp getExpDate() {
		return expDate;
	}
	public void setExpDate(Timestamp expDate) {
		this.expDate = expDate;
	}
	public String getMobile() {
		return mobileNumber;
	}
	public void setMobile(String mobile) {
		this.mobileNumber = mobile;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
}
