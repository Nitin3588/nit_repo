package com.dc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dc.bean.BaseResponse;
import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.UserService;
import com.dc.utill.Constants.ResponseStatus;

public class RegistrationResource {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody User loginPost(@RequestBody  User user) {
		
		BaseResponse response = new BaseResponse();
		if (null != user) {
			//Logger.info("received : " + userId );
			try {
				   userService.saveUser(user);
			
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
