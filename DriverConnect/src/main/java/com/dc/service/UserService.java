package com.dc.service;


import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;

public interface UserService {

	void saveUser(User user) throws DataAccessLayerException ;

	void deleteUser(int Id) throws DataAccessLayerException ;

	void updateUser(User user) throws DataAccessLayerException ;

}
