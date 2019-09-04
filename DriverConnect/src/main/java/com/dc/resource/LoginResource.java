package com.dc.resource;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.BaseResponse;
import com.dc.bean.OTPForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.MailingService;
import com.dc.service.OtpService;
import com.dc.service.UserService;
import com.dc.utill.CommonUtill;
import com.dc.utill.Constants;
import com.dc.utill.Constants.ResponseStatus;


@RestController
@RequestMapping("/mob")
public class LoginResource {


	@Autowired
	UserService userService;
	
	
	@Autowired
	MailingService mailingService;
	
	@Autowired
	OtpService  otpService;
	
	
	private  static final Logger Logger = LoggerFactory.getLogger(LoginResource.class); 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(@RequestParam(value = "userId") int userId) {
		
	Logger.info("GET :login request recieved from  Mobile {}: ",userId);	
	 UserProfileDTO user=null;
		try {
			UserProfileDTO userDetails= userService.findUserById(BigInteger.valueOf(Long.valueOf(userId)));
			 Logger.info("received : " + user.toString());
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
		}
				ModelAndView  model = new ModelAndView("login");
				model.addObject("user", user);
				return   model;
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> loginPost(@RequestParam(value = "mobile_no") String mobile,@RequestParam(value = "user_type") String userType,
			@RequestParam(value = "lang") String lang) {
		Object  user=null;
		BaseResponse response = new BaseResponse();
		
		Logger.info("POST :login request recieved from  Mobile {}: ",mobile);	
		if(null!=mobile && (!mobile.matches("^[0-9]{10}$") || mobile.length()!=10)) {
			mobile=null;
		}if(null!=userType && (userType.length()!=1 || !userType.matches("[1-4]"))) {
			mobile=null;
		}
		
		if (null != mobile && null!= userType && (Integer.valueOf(userType).equals(Constants.userRole.ROLE_DRIVER) ||
				Integer.valueOf(userType).equals(Constants.userRole.ROLE_RECRUITER))) {
			try {
				if(Integer.valueOf(userType) == Constants.userRole.ROLE_DRIVER){
					 user = userService.findUserByMobile(mobile);
				if ( user instanceof UserProfileForm ) {
					UserProfileForm  driver  =  (UserProfileForm)user;
					driver.setUserType(String.valueOf(Constants.userRole.ROLE_DRIVER));
				}
					 
				}else if(Integer.valueOf(userType) == Constants.userRole.ROLE_RECRUITER) {
					user =  userService.findRecruiterProfile(mobile); 
					if ( user instanceof UserProfileForm ) {
						RecruiterProfileForm  rec  =  (RecruiterProfileForm)user;
						rec.setUserType(String.valueOf(Constants.userRole.ROLE_RECRUITER));
					}
				}
				 if(null!=user) {
				     response.setStatus(ResponseStatus.SUCESS);
					 response.setCode(ResponseStatus.SUCESS_CODE);
					 response.setObj(user);
				 }else {
					    response.setStatus(ResponseStatus.NOT_FOUND);
				    	response.setCode(ResponseStatus.NOT_FOUND_CODE);
				 }
				
			} catch (DataAccessLayerException e) {
				Logger.error(ResponseStatus.NOT_FOUND);
				response.setStatus(ResponseStatus.NOT_FOUND);
				response.setCode(ResponseStatus.NOT_FOUND_CODE);
			}
			
		} else {
			response.setStatus(ResponseStatus.INVALID_DETAIL);
			response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
		}
		return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/genrateOTPMob", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> genrateOTPMob(@RequestParam(value = "mobile_no") String mobile,@RequestParam(value = "user_type") String userType)
	{
		UserProfileForm user = null;
		BaseResponse response = new BaseResponse();
		if (null != mobile) {
			Logger.info("received  mobile: {} ,userType: {} " + mobile,userType );
			try {
				    //user= userService.findUserByMobile(mobile);
					OTPForm otp = new OTPForm();
				    otp.setPin(CommonUtill.generateOTP());
					if(!Constants.SMS_BYPASSED) {
						 mailingService.sendSMS(otp.getPin(), mobile);
						//mailingService.sendEmail("Regstered", "Successfilly registerd", user.getEmail());
					}
					otp.setMobile(mobile);
					otp.setCreatedBy(mobile);
					otp.setCreatedDate(new Date());
					otp = otpService.saveOTPdetails(otp);
				   response.setStatus(ResponseStatus.SUCESS);
				   response.setCode(ResponseStatus.SUCESS_CODE);
				   response.setObj(otp.getPin());
				   
			} catch (DataAccessLayerException | IOException e) {
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
	   return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
	}
	
}
