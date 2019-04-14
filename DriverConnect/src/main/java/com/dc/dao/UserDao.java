 package com.dc.dao;

import java.math.BigInteger;
import java.util.List;

import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dto.RecruiterProfileDTO;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.DataAccessLayerException;

public interface UserDao {

	UserProfileForm saveUser(UserProfileForm user) throws DataAccessLayerException;

	boolean deleteUser(Integer Id) throws DataAccessLayerException;

	UserProfileForm updateUser(UserProfileForm user) throws DataAccessLayerException;
	
	UserProfileDTO findUserById(BigInteger userId) throws DataAccessLayerException;

	List<UserProfileForm> findAllusers(int offset) throws DataAccessLayerException;
	
	UserProfileForm findUserByMobile(String mobile) throws DataAccessLayerException;

	public RecruiterProfileForm saveRecruiterProfile(RecruiterProfileForm recruiterProfile) throws DataAccessLayerException;
	
	public RecruiterProfileForm updateRecruiterProfile(RecruiterProfileForm recruiterProfile) throws DataAccessLayerException;
	
	public RecruiterProfileForm findRecruiterProfile(String mobile) throws DataAccessLayerException;
	
	public RecruiterProfileDTO findRecruiterById(BigInteger Id) throws DataAccessLayerException ;
	
	public boolean findRecruiterProfileAlreadyExistOrNot(RecruiterProfileForm recruiter) throws DataAccessLayerException;
	
	public boolean findRecruiterProfileAlreadyExistOrNotById(RecruiterProfileForm recruiter) throws DataAccessLayerException;
	
	public List<UserProfileForm> findApplicantForJob(String job_id ,int offset) throws DataAccessLayerException ;

}
