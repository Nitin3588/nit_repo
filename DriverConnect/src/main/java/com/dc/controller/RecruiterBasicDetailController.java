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

import com.dc.bean.RecruiterProfile;
import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.UserService;

@Controller
public class RecruiterBasicDetailController {
	
	@Autowired
	UserService userService;


	private  static final Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/redirectToDetails", method = RequestMethod.GET)
	public ModelAndView recruitersBasicDetails(@ModelAttribute("recruiterProfile")RecruiterProfile recruiterProfile,HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("recruiterPersonalDetails");
		Logger.info("in recruitBasicDetails" );
		return mav;
	}
	
	
	@RequestMapping(value = "/recruitBasicDetails", method = RequestMethod.POST)
	public ModelAndView addRecruitersBasicDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute RecruiterProfile recruiterProfile) {
		ModelAndView mav = new ModelAndView("recruiterCompanyDetails");
		
		/*RecruiterProfile recruiter = new RecruiterProfile();
		recruiter.setFullName("NITIN SOLANKI");
		recruiter.setPhotoName("A");
		recruiter.setPhotoPath("B");
		recruiter.setCompanyName("C");
		recruiter.setCompanyLocation("D");
		recruiter.setCreatedBy("E");
		recruiter.setCreatedDate(new Date());
		recruiter.setMobileNumber("3435");
		recruiter.setCountry("ORIENTO");*/
		try {
			userService.saveRecruiterProfile(recruiterProfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/recruiterCompanyDetails", method = RequestMethod.POST)
	public ModelAndView addRecruiterCompanyDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("success");
		return mav;
	}
	
	
	
}
