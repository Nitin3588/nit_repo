package com.dc.service;


import java.util.List;

import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;

public interface UserService {

	void saveUser(User user) throws DataAccessLayerException ;

	void deleteUser(int Id) throws DataAccessLayerException ;

	void updateUser(User user) throws DataAccessLayerException ;
	
	List<User> findAllusers() throws DataAccessLayerException ;
	
	User findUserById(int Id) throws DataAccessLayerException ;

}
