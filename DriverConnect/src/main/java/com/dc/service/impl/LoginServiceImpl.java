package com.dc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.bean.UserProfileForm;
import com.dc.service.LoginService;


@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Override
	public void login(UserProfileForm user) {
		
	}

}
