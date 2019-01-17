package com.dc.service;


import java.util.List;

import com.dc.bean.JobPostingForm;
import com.dc.bean.RecruiterProfile;
import com.dc.bean.User;
import com.dc.exception.DataAccessLayerException;

public interface UserService {

	public User saveUser(User user) throws DataAccessLayerException ;

	public void deleteUser(int Id) throws DataAccessLayerException ;

	public void updateUser(User user) throws DataAccessLayerException ;
	
	public List<User> findAllusers() throws DataAccessLayerException ;
	
	public User findUserById(int Id) throws DataAccessLayerException ;
	
	public User findUserByMobile(String mobile) throws DataAccessLayerException ;
	
	public RecruiterProfile saveRecruiterProfile(RecruiterProfile recruiterProfile) throws Exception;
	
	public JobPostingForm saveJobPostingDetails(JobPostingForm jobPostingForm) throws Exception;
	
	

}
