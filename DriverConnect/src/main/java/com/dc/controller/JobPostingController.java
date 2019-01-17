package com.dc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.JobPostingForm;
import com.dc.service.UserService;

@Controller
public class JobPostingController {

	@Autowired
	UserService  userService;

	private  static final Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	
	
	@RequestMapping(value = "/recruiterPostingJobs", method = RequestMethod.GET)
	public ModelAndView jobPostingDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute JobPostingForm jobPostingForm) {
		ModelAndView mav = new ModelAndView("recruiterPostingJobs");
		return mav;
	}
	
	
	@RequestMapping(value = "/recruiterPostingJobs", method = RequestMethod.POST)
	public ModelAndView addJobPostingDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute JobPostingForm jobPostingForm,BindingResult result) {
		ModelAndView mav = new ModelAndView("recruiterPostingJobs");
		
		try {
			jobPostingForm.setJobId("101");
			jobPostingForm.setCompanyName("SEVEN HILLS");
			jobPostingForm.setJobTitle("SHRI");
			jobPostingForm.setRecId(12);
			jobPostingForm.setCrtBy(101);
			userService.saveJobPostingDetails(jobPostingForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.reject("jobTitle","System Exception occured , Please contact system administrator");
			e.printStackTrace();
			return mav;
		}
		//show it here success page with back button
		return mav;
	}

	
	
}
