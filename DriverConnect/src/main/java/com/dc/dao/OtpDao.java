package com.dc.dao;

import com.dc.bean.OTP;
import com.dc.exception.DataAccessLayerException;

public interface OtpDao {

	public OTP saveOTPdetails(OTP otp) throws DataAccessLayerException ;
	
	public OTP getOtp(String mobile) throws DataAccessLayerException ;

	
}
