package com.dc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dc.bean.JobPostingForm;
import com.dc.bean.RecruiterProfile;
import com.dc.bean.User;
import com.dc.dao.UserDao;
import com.dc.dto.JobPostingDetailsDTO;
import com.dc.dto.RecruiterProfileDTO;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.DataAccessLayerException;


@Repository
public class UserDaoImpl implements UserDao{
	

	@Autowired
	@Qualifier("hibernateSessionFactory")
	private SessionFactory sessionFactory;
	
	private  static final Logger Logger = LoggerFactory.getLogger(UserDaoImpl.class); 
	
	@Override
	public User saveUser(User user) throws DataAccessLayerException {
		Session session=sessionFactory.openSession();
		UserProfileDTO userProfileDTO=new UserProfileDTO();
		BeanUtils.copyProperties(user, userProfileDTO);
		session.save(userProfileDTO);
		BeanUtils.copyProperties(userProfileDTO, user);
		Logger.info("User details saved");
		return user;
	}
	
	@Override
	public void deleteUser(int Id) {
	}
	
	@Override
	public void updateUser(User user) {
		
	}

	
	@Override
	public User findUserById(int userId) throws DataAccessLayerException {
		User userDetails = null;
		final String query =" * FROM `dc_sub_usr` WHERE `ID`=? ";	
		
		return userDetails;
	}

	
	@Override
	public List<User> findAllusers() throws DataAccessLayerException {
		List<User> userList =  new ArrayList<User>();
		List<UserProfileDTO> userDTOList =  new ArrayList<UserProfileDTO>();

		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(UserProfileDTO.class);
		 userDTOList = cr.list();
		 for (UserProfileDTO userDTO : userDTOList) {
			 User userDetails = new User();
			 BeanUtils.copyProperties(userDTO, userDetails);
			 userList.add(userDetails);
		}
		return userList;
	}
	

	@Override
	public User findUserByMobile(String mobile) throws DataAccessLayerException {
		
		User userDetails = new User();
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(UserProfileDTO.class);
		cr.add(Restrictions.eq("mobileNo", mobile));
		UserProfileDTO userDTO = (UserProfileDTO)cr.uniqueResult();
		BeanUtils.copyProperties(userDTO, userDetails);
		
		return userDetails;
	}



	
	
/************
 * 
 * Below method is used to save basic detail of recruiter/User
 * so after registration recruiter can access post a new job option , update a profile,view profile
 * Recruiter id should be generated which is used as a forien key in job posting table 
 * 
 * ************/	
	
	@Override
	public RecruiterProfile saveRecruiterProfile(RecruiterProfile recruiterProfile) throws Exception {
		
		Session session=sessionFactory.openSession();
		RecruiterProfileDTO recruiterProfileDTO=new RecruiterProfileDTO();
		BeanUtils.copyProperties(recruiterProfile, recruiterProfileDTO);
		session.save(recruiterProfileDTO);
		BeanUtils.copyProperties(recruiterProfileDTO, recruiterProfile);
		return recruiterProfile;
	}

	
	public JobPostingForm saveJobPostingDetails(JobPostingForm jobPostingForm) throws Exception{
		Session session=sessionFactory.openSession();
		JobPostingDetailsDTO jobPostingDetailsDTO=new JobPostingDetailsDTO();
		BeanUtils.copyProperties(jobPostingForm, jobPostingDetailsDTO);
		session.save(jobPostingDetailsDTO);
		BeanUtils.copyProperties(jobPostingDetailsDTO, jobPostingForm);
		return jobPostingForm;
		
	}
}
	
