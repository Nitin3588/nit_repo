package com.dc.controller;

import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.BaseResponse;
import com.dc.bean.OTP;
import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.MailingService;
import com.dc.service.OtpService;
import com.dc.service.UserService;
import com.dc.utill.CommonUtill;
import com.dc.utill.Constants;
import com.dc.utill.Constants.ResponseStatus;

@Controller
public class UserController {


	@Autowired
	UserService  userService;

	@Autowired
	OtpService  otpService;

	@Autowired
	MailingService mailingService;
	
	String UPLOAD_LOCATION="E:/mytemp/";
	
	
	private  static final Logger Logger = LoggerFactory.getLogger(UserController.class); 



	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegistration(HttpServletRequest request, HttpServletResponse response,HttpSession session,@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("registration");
		mav.addObject("user", user);
		return mav;
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView showRegistrationPost(HttpServletRequest request, HttpServletResponse response,HttpSession session,@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("registration");
		mav.addObject("user", user);
		try {
			user.setUserType(String.valueOf(Constants.userRole.ROLE_CUSTOMER));
			Integer rn =  new Random().nextInt();
			user.setOtp(String.valueOf(rn));
			String mobile = user.getMobileNo();

			MultipartFile multipartFile = user.getFile();
			if(null != multipartFile)
			{ 
				FileCopyUtils.copy(user.getFile().getBytes(), new File(UPLOAD_LOCATION + user.getFile().getOriginalFilename()));
				String fileName = multipartFile.getOriginalFilename();
				Logger.info("uploaded fileName {}",fileName);
			}
			String newOtpMessage ="Dear "+user.getFirstName()+","+ user.getOtp()+ "is the your one time password (OTP),valid for 30 min. Please do not share it with anyone.";
			//mailingService.sendSMS(newOtpMessage, mobile);
			mailingService.sendEmail("Regstered", "Successfilly registerd", user.getEmail());
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


	@RequestMapping(value = "/genrateOTP", method = RequestMethod.GET)
	@ResponseBody 
	public String  genrateOTP(@RequestParam(value = "mobile_no") String mobile)
	{
		OTP otp = new OTP();
		BaseResponse response = new BaseResponse();
		if (null != mobile) {
			try {
				otp.setPin(CommonUtill.generateOTP());
				otp.setMobile(mobile);
				otp.setCreatedBy("");
				otp.setCreatedDate( new Date());
				otp = otpService.saveOTPdetails(otp);
			} catch (DataAccessLayerException e) {
				e.printStackTrace();
				response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
				response.setCode(ResponseStatus.EXCEPTION_CODE);
			}
			response.setStatus(ResponseStatus.SUCESS);
			response.setCode(ResponseStatus.SUCESS_CODE);
		} else {
			response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
			response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
		}
		return otp.getPin();
	}



	@RequestMapping(value = "/verificationOTP", method = RequestMethod.POST)
	public ModelAndView  verificationOTP(@ModelAttribute User user,
			HttpServletRequest request, HttpServletResponse response,HttpSession session)
	{
		String otpnum =  user.getOtp();

		ModelAndView mav = new ModelAndView("SubscriberDashboard");

		/*try {

			if(null !=otpnum ){
				OTP serverOtp = otpService.getOtp(user.getMobileNo());
				if(otpnum.equals(serverOtp.getPin())){
					mav =new ModelAndView("SubscriberDashboard");
					return mav;
				}
				else{
					mav =new ModelAndView("registration");
					mav.addObject("error", "Entered Otp is NOT valid. Please Retry!");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
*/
		return mav;
	}	


	@RequestMapping(value = "/landingPage", method = RequestMethod.GET)
	public ModelAndView  landingPage(@RequestParam("sts")String sts, @ModelAttribute User user,
			HttpServletRequest request, HttpServletResponse response,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if( sts.equalsIgnoreCase("1")) {
			mav.setViewName("successResponse");
		}else if( sts.equalsIgnoreCase("2")) {
			
			mav.setViewName("failureResponse");
		}
		else {
			
			mav.setViewName("errorResponse");
		}
		
		return mav;
	}	
	
	
}





/*
MultipartFile multipartFile = user.getFile();
if(null != multipartFile)
{ 
	FileCopyUtils.copy(user.getFile().getBytes(), new File(UPLOAD_LOCATION + user.getFile().getOriginalFilename()));
	String fileName = multipartFile.getOriginalFilename();
	Logger.info("uploaded fileName {}",fileName);
}
*/
