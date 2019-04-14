package com.dc.service;

import java.io.IOException;

import com.dc.bean.UserProfileForm;

public interface MailingService {
	
	void sendConfirmRegistrationMail(UserProfileForm user);
	
	void sendForgotPasswordMail(UserProfileForm user);
	
	void sendChangePasswordMail(UserProfileForm user);
	
	void sendNewOtpMail(UserProfileForm user);
	
	void sendUserCredentials(UserProfileForm user);
	
	void sendEmail(String eSubject, String eContent, String recipient);

	void sendSMS(String sContent, String mobile)throws IOException;

}
