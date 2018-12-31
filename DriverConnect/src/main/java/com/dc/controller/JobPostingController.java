package com.dc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.JobPostingForm;
import com.dc.bean.User;
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
			HttpSession session,@ModelAttribute JobPostingForm jobPostingForm) {
		ModelAndView mav = new ModelAndView("recruiterPostingJobs");
		
		
		
		return mav;
	}

	
	
}
