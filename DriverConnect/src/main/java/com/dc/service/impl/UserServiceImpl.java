package com.dc.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.bean.CompanyProfileForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dao.CompanyDao;
import com.dc.dao.UserDao;
import com.dc.dto.RecruiterProfileDTO;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.ApplicationException;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired 
	CompanyDao companyDao;
	
	private  static final Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class); 

	public UserProfileForm saveUser(UserProfileForm user) throws DataAccessLayerException{
		return userDao.saveUser(user);
	}

	public boolean deleteUser(Integer Id) throws DataAccessLayerException {
		return userDao.deleteUser(Id);
	}

	public UserProfileForm updateUser(UserProfileForm user) throws DataAccessLayerException {
		return userDao.updateUser(user);
	}

	@Override
	public List<UserProfileForm> findAllusers(int offset) throws DataAccessLayerException {
		return userDao.findAllusers(offset);
	}

	@Override
	public UserProfileDTO findUserById(BigInteger userId) throws DataAccessLayerException {
		return  userDao.findUserById(userId);
	}

	@Override
	public UserProfileForm findUserByMobile(String mobile) throws DataAccessLayerException {
		return  userDao.findUserByMobile(mobile);
	}
	
	
	@Override
	@Transactional
	public RecruiterProfileForm saveRecruiterProfile(RecruiterProfileForm recruiterProfile) 
			throws DataAccessLayerException, ApplicationException{
		 Logger.info("in saveRecruiterProfile");
		 CompanyProfileForm  company =  companyDao.saveCompanyDetails(recruiterProfile.getCompanyProfileForm());
		 recruiterProfile.setCompanyProfileForm(company);
		 recruiterProfile  = userDao.saveRecruiterProfile(recruiterProfile);
		 return recruiterProfile;
	}

	@Override
	public RecruiterProfileForm updateRecruiterProfile(RecruiterProfileForm recruiterProfile) throws DataAccessLayerException {
		return userDao.updateRecruiterProfile(recruiterProfile);
	}

	@Override
	public RecruiterProfileForm findRecruiterProfile(String mobile) throws DataAccessLayerException {
		 return userDao.findRecruiterProfile(mobile);
	}
	
	@Override
	public RecruiterProfileDTO findRecruiterById(BigInteger Id) throws DataAccessLayerException {
		return userDao.findRecruiterById(Id);
	}
	
	
	public boolean findRecruiterProfileAlreadyExistOrNot(RecruiterProfileForm recruiter) throws DataAccessLayerException{
		return userDao.findRecruiterProfileAlreadyExistOrNot(recruiter);
	}
	
	public boolean findRecruiterProfileAlreadyExistOrNotById(RecruiterProfileForm recruiter) throws DataAccessLayerException{
		return userDao.findRecruiterProfileAlreadyExistOrNotById(recruiter);
	}

	@Override
	public List<UserProfileForm> findApplicantForJob(String job_id ,int offset) throws DataAccessLayerException {
		return userDao.findApplicantForJob(job_id ,offset);
	}

	
}
