package com.dc.service;

import com.dc.bean.OTPForm;
import com.dc.exception.DataAccessLayerException;

public interface OtpService {
	
	public OTPForm saveOTPdetails(OTPForm otp) throws DataAccessLayerException ;
	
	public OTPForm getOtp(String mobile) throws DataAccessLayerException ;
	
	

}
