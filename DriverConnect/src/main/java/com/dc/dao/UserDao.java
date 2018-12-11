package com.dc.dao;

import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;

public interface UserDao {

	void saveUser(User user) throws DataAccessLayerException;

	void deleteUser(int Id) throws DataAccessLayerException;

	void updateUser(User user) throws DataAccessLayerException;
	
	
	User findUserById(int userId) throws DataAccessLayerException;

}
