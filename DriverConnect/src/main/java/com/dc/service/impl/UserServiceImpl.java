package com.dc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.bean.User;
import com.dc.dao.UserDao;
import com.dc.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;


	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public void deleteUser(int Id) {
		userDao.deleteUser(Id);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

}
