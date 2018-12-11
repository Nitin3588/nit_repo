package com.dc.service;

import com.dc.bean.User;

public interface MailingService {
	
	void sendConfirmRegistrationMail(User user);
	
	void sendForgotPasswordMail(User user);
	
	void sendChangePasswordMail(User user);
	
	void sendNewOtpMail(User user);
	
	void sendUserCredentials(User user);
	
	void sendEmail(String eSubject, String eContent, String recipient);

	void sendSMS(String sContent, String mobile);

}
