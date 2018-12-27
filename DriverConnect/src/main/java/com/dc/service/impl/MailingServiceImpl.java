package com.dc.service.impl;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.bean.User;
import com.dc.service.MailingService;
import com.dc.utill.EmailSender;
import com.dc.utill.PropertyFileReader;
import com.dc.utill.Sender;

@Service
public class MailingServiceImpl implements MailingService {

	@Autowired 
	EmailSender emailSender; 
	
	static PropertyFileReader configProperties = new PropertyFileReader();
	public static Properties appConfig;
	public Sender sendSms;
	
	static {
		try {
			appConfig = configProperties.getPropValues();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void sendConfirmRegistrationMail(User user) {

	}

	@Override
	public void sendForgotPasswordMail(User user) {

	}

	@Override
	public void sendChangePasswordMail(User user) {
	}

	@Override
	public void sendNewOtpMail(User user) {

	}

	@Override
	public void sendUserCredentials(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEmail(String eSubject, String eContent, String recipient) {
		emailSender.send(eSubject, eContent, recipient);
	}

	@Override
	public void sendSMS(String sContent, String mobile)  {
		//Sender sendSms = new Sender(appConfig.getProperty("server"),Integer.parseInt(appConfig.getProperty("port")),appConfig.getProperty("username"),appConfig.getProperty("password"),sContent, "0", "0", mobile, appConfig.getProperty("sender"));
		Sender.sendSMS(sContent,mobile);
		//sendSms.submitMessage();
	}

}
