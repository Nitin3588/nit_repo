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

import com.dc.bean.UserProfileForm;

@Controller
public class SubscriberBasicDetailsController {

	
	private  static final Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value = "/basicDetails", method = RequestMethod.GET)
	public ModelAndView subscriberBasicDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute UserProfileForm user) {
		
		//Redirecting to Subscriber's basic details page
		Logger.info("Entering into subscriber's basic details page");
		ModelAndView mav = new ModelAndView("registration");
		
		//check user with database on basis of id or mobile number is it already present or not
		
		try {
			mav.addObject("user", user);
		}catch(Exception e) {
			e.printStackTrace();
			Logger.error("Exception occured in basic Details get method {}",e);
			//set error msg as Exception occured in system
			Logger.info("Exiting from basic details get method with exception");
			return mav;
		}
			return mav;
	}

	
	@RequestMapping(value = "/basicDetails", method = RequestMethod.POST)
	public ModelAndView addSubscriberBasicDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute UserProfileForm user,BindingResult result) {
		
		//Saving subscriber's basic details 
		
		
		Logger.info("Before saving details into subscriber's basic details table");
		
		//server side validation of fields
		/*Below fields are mandatory should not contain null values
		 * Uploaded files should be of restricted size
		 * Full name validation can contain single space but only alaphabets are allowed (only 16 characters are allowed)
		 * Date of birth validation should be in format of dd/mm/yyyy check it should not be future date,age > 18 years
		 * license number validation first 2 alphabets next 2 numeric next 4 a valid year remaining 7 are numeric
		 * expiry date of license should be future date should not be past date
		 * */
		
		/**************Validation starts here *****************/
		validateBasicDetailFields(user,result);
		if(result.hasErrors()) {
		}
		/****************Validation ends here ********************/
		
		//After server side validation insert details into database
		ModelAndView mav = new ModelAndView("registration");
		try {
			mav.addObject("user", user);
		}catch(Exception e) {
			e.printStackTrace();
			Logger.error("Exception occured in basic Details post method {}",e);
			//set error msg as exception occured in system
			Logger.info("Exiting from basic details post method with exception");
			return mav;
		}
		Logger.info("After saving details into subscriber's basic details table");
		return mav;
	}
	
	
	
	public void validateBasicDetailFields(UserProfileForm user,BindingResult result) {
			String subscriberFullName=user.getUserName();
			String dob=user.getDob();
			String licenseNumber = user.getLicenseNumber();
			String expDate= user.getExpDate();
			
			if(null == subscriberFullName || 
					!(subscriberFullName.trim().matches("[a-zA-Z]"))){

				result.rejectValue("subscriberFullName", "");
			}
			if(null==dob
					|| !dob.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
				result.rejectValue("subscriberFullName", "");
			}
			
			
					
	}
	
	
}
