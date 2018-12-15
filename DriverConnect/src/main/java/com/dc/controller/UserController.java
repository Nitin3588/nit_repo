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

import com.dc.bean.User;
import com.dc.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	UserService  userService;
	
	private  static final Logger log = LoggerFactory.getLogger(UserController.class); 

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegistration(HttpServletRequest request, HttpServletResponse response,HttpSession session,@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("user", user);
		try {
			userService.saveUser(user);
			mav.addObject("user", user);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		User user =(User) session.getAttribute("loggedInUser");
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("user", user);
		return mav;
	}
	
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public ModelAndView showProfilePost(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		User user =(User) session.getAttribute("loggedInUser");
		ModelAndView mav =new ModelAndView("profile");
		try {
			userService.updateUser(user);
			mav.addObject("user", user);
			return mav;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
}
