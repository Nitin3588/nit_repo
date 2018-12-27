package com.dc.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dc.bean.BaseResponse;
import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.UserService;
import com.dc.utill.Constants.ResponseStatus;


@RestController
@RequestMapping("/loginMob")
public class LoginResource {


	@Autowired
	UserService userService;
	
	private  static final Logger Logger = LoggerFactory.getLogger(LoginResource.class); 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(@RequestParam(value = "userId") int userId) {
		
		User user=null;
		try {
			 user= userService.findUserById(userId);
			 Logger.info("received : " + user.toString());
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
		}
				ModelAndView  model = new ModelAndView("login");
				model.addObject("user", user);
				return   model;
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User loginPost(@RequestParam(value = "mobile_no") String mobile,@RequestParam(value = "user_type") String userType,
			@RequestParam(value = "lang") String lang) {
		
		User user = null;
		BaseResponse response = new BaseResponse();
		if (null != mobile) {
			//Logger.info("received : " + userId );
			try {
				 //user= userService.findUserById(userId);
				   user= userService.findUserByMobile(mobile);
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
		return user;
	}
	
	
	@RequestMapping(value = "/genrateOTPMob", method = RequestMethod.POST)
	public @ResponseBody User genrateOTPMob(@RequestParam(value = "mobile_no") String mobile,@RequestParam(value = "user_type") String userType)
	{
		User user = null;
		BaseResponse response = new BaseResponse();
		if (null != mobile) {
			//Logger.info("received : " + userId );
			try {
				 //user= userService.findUserById(userId);
				   user= userService.findUserByMobile(mobile);
				   
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
		return user;
	}
	
}
