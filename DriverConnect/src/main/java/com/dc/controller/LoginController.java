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

import com.dc.bean.User;
import com.dc.service.UserService;

@Controller
public class LoginController  {

	@Autowired
	UserService userService;
	
	private  static final Logger log = LoggerFactory.getLogger(LoginController.class); 

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showLoginPost(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user")User user,
			HttpSession session,Model model) {

		boolean  valid=false;	
		String password = request.getParameter("password");
		log.debug(password);
		try {
			user = userService.findUserById(1);
			if(null != user) {
				valid =user.isStatus();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		if(valid) {
			user.setFirstName((String)request.getParameter("userName"));
			user.setUserType(session.getId());
			session.setAttribute("loggedInUser", user);
			ModelAndView mav = new ModelAndView("home");
			mav.addObject("user", user);
			return mav;
		}else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("error", "Invalid Credentials"); 
			return mav;

		} 

	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView showLogout(HttpServletRequest request, HttpServletResponse response,HttpSession session,Model model) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("error", "Please login"); 
		return mav;

	}
}
