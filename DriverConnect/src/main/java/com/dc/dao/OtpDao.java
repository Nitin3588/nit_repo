package com.dc.dao;

import com.dc.bean.OTPForm;
import com.dc.exception.DataAccessLayerException;

public interface OtpDao {

	public OTPForm saveOTPdetails(OTPForm otp) throws DataAccessLayerException ;
	
	public OTPForm getOtp(String mobile) throws DataAccessLayerException ;

	
}
