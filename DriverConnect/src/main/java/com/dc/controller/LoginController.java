package com.dc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.UserProfileForm;
import com.dc.service.UserService;
import com.dc.utill.Constants;

@Controller
public class LoginController  {

	@Autowired
	UserService userService;
	
	private  static final Logger Logger = LoggerFactory.getLogger(LoginController.class); 

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new UserProfileForm());
		return mav;
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showLoginPost(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user")UserProfileForm user,
			HttpSession session,Model model) {
		
		UserProfileForm userDetails   =  null;
		boolean  valid=false;	
		ModelAndView mav = new ModelAndView();
		
		Logger.info("inside Login method");
		
		
		if(!Constants.SMS_BYPASSED) {
		session.setAttribute("loggedInUser", userDetails);
		mav.setViewName("SubscriberDashboard");
		mav.addObject("user", userDetails);
		return mav;
		}
		try {
		    userDetails = userService.findUserByMobile(user.getUserloginId());
			if(null != userDetails) {
				valid =userDetails.isStatus();
				if(!valid) {
				mav.setViewName("login");
				mav.addObject("error", "Acount not Active"); 
				mav.addObject("user", user);
				return mav;
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		if(valid) {
			String dbPass =  userDetails.getPassword();
			if(user.getPassword().equals(dbPass)) {
				valid =true ;
			}
			
			user.setFirstName((String)request.getParameter("userName"));
			user.setUserType(session.getId());
			
			session.setAttribute("loggedInUser", userDetails);
			mav.setViewName("home");
			mav.addObject("user", userDetails);
			return mav;
		}else {
			mav.setViewName("login");
			mav.addObject("error", "Invalid Credentials"); 
			mav.addObject("user", user);
			return mav;

		} 

	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView showLogout(HttpServletRequest request, HttpServletResponse response,HttpSession session,Model model) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("error", "Please login"); 
		mav.addObject("user", new UserProfileForm());
		return mav;

	}
}
