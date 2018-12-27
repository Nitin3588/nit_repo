package com.dc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.User;

@Controller
public class JobPostingController {

	
	private  static final Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	
	
	@RequestMapping(value = "/jobPostingDetails", method = RequestMethod.GET)
	public ModelAndView jobPostingDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}
	
	
	@RequestMapping(value = "/jobPostingDetails", method = RequestMethod.POST)
	public ModelAndView addJobPostingDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}

	
	
}
