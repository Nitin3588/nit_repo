 package com.dc.dao;

import java.util.List;

import com.dc.bean.JobPostingForm;
import com.dc.bean.RecruiterProfile;
import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;

public interface UserDao {

	User saveUser(User user) throws DataAccessLayerException;

	void deleteUser(int Id) throws DataAccessLayerException;

	void updateUser(User user) throws DataAccessLayerException;
	
	User findUserById(int userId) throws DataAccessLayerException;

	List<User> findAllusers() throws DataAccessLayerException;
	
	User findUserByMobile(String mobile) throws DataAccessLayerException;

	public RecruiterProfile saveRecruiterProfile(RecruiterProfile recruiterProfile) throws DataAccessLayerException;
	
	public JobPostingForm saveJobPostingDetails(JobPostingForm jobPostingForm) throws DataAccessLayerException;
	
}
