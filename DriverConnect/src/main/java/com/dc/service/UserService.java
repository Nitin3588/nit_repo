package com.dc.service;


import java.math.BigInteger;
import java.util.List;

import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dto.RecruiterProfileDTO;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.ApplicationException;
import com.dc.exception.DataAccessLayerException;

public interface UserService {

	public UserProfileForm saveUser(UserProfileForm user) throws DataAccessLayerException ;

	public boolean deleteUser(Integer Id) throws DataAccessLayerException ;

	public UserProfileForm updateUser(UserProfileForm user) throws DataAccessLayerException ;
	
	public List<UserProfileForm> findAllusers(int offset) throws DataAccessLayerException ;
	
	public UserProfileDTO findUserById(BigInteger Id) throws DataAccessLayerException ;
	
	public UserProfileForm findUserByMobile(String mobile) throws DataAccessLayerException ;
	
	public RecruiterProfileForm saveRecruiterProfile(RecruiterProfileForm recruiterProfile) throws DataAccessLayerException,ApplicationException ;
	
	public RecruiterProfileForm updateRecruiterProfile(RecruiterProfileForm recruiterProfile) throws DataAccessLayerException;
	
	public RecruiterProfileForm findRecruiterProfile(String mobile) throws DataAccessLayerException;
	
	public RecruiterProfileDTO findRecruiterById(BigInteger Id) throws DataAccessLayerException ;
	
	public boolean findRecruiterProfileAlreadyExistOrNot(RecruiterProfileForm recruiter) throws DataAccessLayerException;
	
	public boolean findRecruiterProfileAlreadyExistOrNotById(RecruiterProfileForm recruiter) throws DataAccessLayerException;
	
	public List<UserProfileForm> findApplicantForJob(String job_id ,int offset) throws DataAccessLayerException ;
	
	
}
