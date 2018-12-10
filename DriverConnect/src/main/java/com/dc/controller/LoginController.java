package com.dc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.User;
import com.dc.service.UserService;

@Controller
public class LoginController  {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showLoginPost(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user")User user) {
		
	user.setFirstname((String)request.getParameter("username"));
	String password = 	request.getParameter("password");
	
	ModelAndView mav = new ModelAndView("home");
	mav.addObject("user", user);
	return mav;
	}

	
	
}
