package com.dc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.bean.OTPForm;
import com.dc.dao.OtpDao;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.OtpService;


@Service
@Transactional
public class OtpServiceImpl implements OtpService {

	@Autowired
	OtpDao otpDao;
	
	private  static final Logger Logger = LoggerFactory.getLogger(OtpServiceImpl.class); 
	
	@Override
	public OTPForm saveOTPdetails(OTPForm otp) throws DataAccessLayerException {
		Logger.info("saveOTPdetails");
		 return   otpDao.saveOTPdetails(otp);
	}
	

	@Override
	public OTPForm getOtp(String mobile) throws DataAccessLayerException {
		return   otpDao.getOtp(mobile);
	}
	
}
