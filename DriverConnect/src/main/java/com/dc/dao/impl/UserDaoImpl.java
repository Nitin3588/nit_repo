package com.dc.dao.impl;

import org.springframework.stereotype.Repository;

import com.dc.bean.User;
import com.dc.dao.UserDao;
import com.dc.exception.DataAccessLayerException;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Override
	public void saveUser(User user) {
		
	}
	
	@Override
	public void deleteUser(int Id) {
		
	}
	
	@Override
	public void updateUser(User user) {
		
	}

	
	@Override
	public User findUserById(int userId) throws DataAccessLayerException {
		User userDetails = null;
		return userDetails;
	}
	
}
