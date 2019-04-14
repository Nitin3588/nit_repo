package com.dc.controller;

import org.springframework.validation.BindingResult;

public class CompanyProfileValidator {

	
	public static final String nameRegEx="[a-zA-Z]";
	public static final String website="[a-zA-Z]";
	public static final String address="[a-zA-Z]";
	public static final String location="[a-zA-Z]";
	public static final String stateId="[a-zA-Z]";
	public static final String cityId="[a-zA-Z]";
	public static final String pinCode="[a-zA-Z]";
	
	
	///name validation method
	public static void nameValidation(String nameInput,BindingResult result) {
		if(null==nameInput ||
				nameInput.equalsIgnoreCase("")) {
			result.rejectValue("name","Company name is not valid");
			
		}
		if(!nameInput.matches(nameRegEx)) {
			result.rejectValue("name","Please enter valid details");
			
		}
		
	}


	///website validation method
	public static void websiteValidation(String webs,BindingResult result) {
		if(null==webs ||
				webs.equalsIgnoreCase("")) {
			result.rejectValue("name","Company name is not valid");
			
		}
		if(!website.matches(webs)) {
			result.rejectValue("name","Please enter valid details");
			
		}
		
	}
	//
	public static void locationValidation(String loct,BindingResult result) {
		if(null==loct ||
				loct.equalsIgnoreCase("")) {
			result.rejectValue("name","Company name is not valid");
			
		}
		if(!location.matches(loct)) {
			result.rejectValue("name","Please enter valid details");
			
		}
		
	}
	
	
	public static void stateCdValidation(String sId,BindingResult result) {
		if(null==sId ||
				sId.equalsIgnoreCase("")) {
			result.rejectValue("name","Company name is not valid");
			
		}
		if(!stateId.matches(sId)) {
			result.rejectValue("name","Please enter valid details");
			
		}
		
	}
	

	
	
	public static void countryCdValidation(String c_Id,BindingResult result) {
		if(null==c_Id ||
				c_Id.equalsIgnoreCase("")) {
			result.rejectValue("name","Company name is not valid");
			
		}
		if(!cityId.matches(c_Id)) {
			result.rejectValue("name","Please enter valid details");
			
		}
		
	}

	
	public static void pinCodeValidation(String pin,BindingResult result) {
		if(null==pin ||
				pin.equalsIgnoreCase("")) {
			result.rejectValue("name","Company name is not valid");
			
		}
		if(!pinCode.matches(pin)) {
			result.rejectValue("name","Please enter valid details");
			
		}
		
	}

}
