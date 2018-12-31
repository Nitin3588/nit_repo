package com.dc.service;

import com.dc.bean.OTP;
import com.dc.exception.DataAccessLayerException;

public interface OtpService {
	
	public OTP saveOTPdetails(OTP otp) throws DataAccessLayerException ;
	
	public OTP getOtp(String mobile) throws DataAccessLayerException ;
	
	

}
