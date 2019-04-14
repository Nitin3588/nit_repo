package com.dc.controller;

import org.springframework.validation.BindingResult;

public class FieldValidator {

	
	public static final String nameRegEx="[a-zA-Z]";
	public static final String mobRegEx="";
	public static final String emailRegEx="";
	public static final String dobRegEx="";
	public static final String pinCodeRegEx="";
	public static final String otpRegEx="";
	
	
	public static void nameValidation(String nameInput,BindingResult result) {
		if(null==nameInput ||
				nameInput.equalsIgnoreCase("")) {
			result.rejectValue("name","Please fill up mandatory fields");
			
		}
		if(!nameInput.matches(nameRegEx)) {
			result.rejectValue("name","Please use valid details");
			
		}
		
	}
	
	public static void mobileValidation(String mobileInput,BindingResult result) {
		if(null==mobileInput ||
				mobileInput.equalsIgnoreCase("")) {
			result.rejectValue("name","Please fill up mandatory fields");
			
		}
		if(!mobileInput.matches(mobRegEx)) {
			result.rejectValue("name","Please use valid details");
			
		}
		
	}
	
	public static void emailValidation(String emailInput,BindingResult result) {
		if(null==emailInput ||
				emailInput.equalsIgnoreCase("")) {
			result.rejectValue("name","Please fill up mandatory fields");
			
		}
		if(!emailInput.matches(emailRegEx)) {
			result.rejectValue("name","Please use valid details");
			
		}
		
	}
	
	public static void pincodeValidation(String pinInput,BindingResult result) {
		if(null==pinInput ||
				pinInput.equalsIgnoreCase("")) {
			result.rejectValue("name","Please fill up mandatory fields");
			
		}
		if(!pinInput.matches(pinCodeRegEx)) {
			result.rejectValue("name","Please use valid details");
			
		}
		
	}
	
	public static void dobValidation(String dobInput,BindingResult result) {
		if(null==dobInput ||
				dobInput.equalsIgnoreCase("")) {
			result.rejectValue("name","Please fill up mandatory fields");
			
		}
		if(!dobInput.matches(dobRegEx)) {
			result.rejectValue("name","Please use valid details");
			
		}
		
	}
	

	
	public static void otpValidation(String otpInput,BindingResult result) {
		if(null==otpInput ||
				otpInput.equalsIgnoreCase("")) {
			result.rejectValue("name","Please fill up mandatory fields");
			
		}
		if(!otpInput.matches(otpRegEx)) {
			result.rejectValue("name","Please use valid details");
			
		}
		
	}
	
	
	
}
