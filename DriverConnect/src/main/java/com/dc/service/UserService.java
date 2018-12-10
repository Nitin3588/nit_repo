package com.dc.service;


import com.dc.bean.User;

public interface UserService {

	void saveUser(User user) ;

	void deleteUser(int Id);

	void updateUser(User user);

}
