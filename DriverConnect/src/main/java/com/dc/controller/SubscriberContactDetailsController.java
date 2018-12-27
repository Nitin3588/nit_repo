package com.dc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.User;

@Controller
public class SubscriberContactDetailsController {

	
	private  static final Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value = "/contactDetails", method = RequestMethod.GET)
	public ModelAndView subscriberContactDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session,@ModelAttribute User user) {
		//Redirecting to Subscriber's contact details page
		Logger.info("Entering into subscriber's contact details page");
		ModelAndView mav = new ModelAndView("registration");
		try {
		mav.addObject("user", user);
		}catch(Exception e) {
			e.printStackTrace();
			Logger.error("Exception occured in contact Details get method {}",e);
			//set error msg as Exception occured in system
			Logger.info("Exiting from contact details get method with exception");
			return mav;
		}
		Logger.info("Exiting from contact details get method with success");
		return mav;
	}

	
	@RequestMapping(value = "/contactDetails", method = RequestMethod.POST)
	public ModelAndView addSubscriberContactDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute User user,BindingResult result) {
		////saving Subscriber's contact details 
		Logger.info("Before saving details into subscriber's contact details table");
		
		//Server side validation of contact details fields
		validateContactDetailFields(user,result);
		/*All below fields are mandatory should not be null
		 *Emergency contact number validation :: should contain only numbers , length should be 10 with no white spaces
		 * House number details validation :: it is alaphanumeric with some special characters are allowed
		 * colony name validation :: it is alaphanumeric with some special characters are allowed
		 * landmark validation :: it is alaphanumeric with some special characters are allowed
		 * pincode valition :: only numbers are allowed
		 * city,state,country :: validation only alaphabets are allowed
		 * 
		 * */
		
		ModelAndView mav = new ModelAndView("registration");
		try {
			mav.addObject("user", user);
		}catch(Exception e) {
			e.printStackTrace();
			Logger.error("Exception occured in contact Details post method {}",e);
			//set error msg as exception occured in system
			Logger.info("Exiting from contact details post method with exception");
			return mav;
		}
		Logger.info("After saving details into subscriber's contact details table");
		
		
		/*
		 * Generate success page after validation of contact detail page 
		 * and saving it into database
		 * 
		 * 
		 * 
		 * */
		
		
		return mav;
	}
	
	public void validateContactDetailFields(User user,BindingResult result) {
		
	}
	
	}

	

