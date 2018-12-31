package com.dc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.bean.OTP;
import com.dc.dao.OtpDao;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.OtpService;


@Transactional
@Service
public class OtpServiceImpl implements OtpService {

	@Autowired
	OtpDao otpDao;
	
	@Override
	public OTP saveOTPdetails(OTP otp) throws DataAccessLayerException {
		 return   otpDao.saveOTPdetails(otp);
	}
	

	@Override
	public OTP getOtp(String mobile) throws DataAccessLayerException {
		return   otpDao.getOtp(mobile);
	}
	
}
