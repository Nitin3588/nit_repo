package com.dc.dao;

import com.dc.bean.User;

public interface UserDao {

	void saveUser(User user);

	void deleteUser(int Id);

	void updateUser(User user);

}
