package com.dc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dao.UserDao;
import com.dc.dto.RecruiterProfileDTO;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.ApplicationException;
import com.dc.exception.DataAccessLayerException;
import com.dc.utill.Constants.ResponseStatus;
import com.dc.utill.SqlConstants;

@Repository
public class UserDaoImpl implements UserDao{


	@Autowired
	@Qualifier("hibernateSessionFactory")
	private SessionFactory sessionFactory;

	private  static final Logger Logger = LoggerFactory.getLogger(UserDaoImpl.class); 

	@Override
	public UserProfileForm saveUser(UserProfileForm user) throws DataAccessLayerException,ApplicationException {
		Session session=sessionFactory.getCurrentSession();
		UserProfileDTO userProfileDTO=new UserProfileDTO();
		BeanUtils.copyProperties(user, userProfileDTO);
		try {
			session.save(userProfileDTO);
			BeanUtils.copyProperties(userProfileDTO, user);
		}catch (Exception e) {
			throw new ApplicationException(e.getMessage(), e.getCause());
		}
		Logger.info("User details saved");
		return user;
	}

	@Override
	public boolean deleteUser(Integer Id) throws DataAccessLayerException {

		boolean deleted = false;
		Session session=sessionFactory.getCurrentSession();
		try {
			UserProfileDTO userProfileDTO=new UserProfileDTO();
			userProfileDTO.setId(BigInteger.valueOf(Id) );
			session.delete(userProfileDTO);
			deleted = true;

		}catch (Exception e) {
			throw new DataAccessLayerException(e.getMessage(), e.getCause());
		}
		Logger.info("User details saved");
		return deleted;

	}

	@Override
	public UserProfileForm updateUser(UserProfileForm user) throws DataAccessLayerException {

		Session session=sessionFactory.getCurrentSession();
		UserProfileDTO userProfileDTO=new UserProfileDTO();
		BeanUtils.copyProperties(user, userProfileDTO);
		try {
			session.update(userProfileDTO);
			BeanUtils.copyProperties(userProfileDTO, user);
		}catch (Exception e) {
			throw new DataAccessLayerException(e.getMessage(), e.getCause());
		}
		Logger.info("User details updated");
		return user;

	}


	@Override
	public UserProfileDTO findUserById(BigInteger userId) throws DataAccessLayerException {
		UserProfileDTO userDetailsDTO = null;
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserProfileDTO.class);
		cr.add(Restrictions.eq("id", userId));
		userDetailsDTO = (UserProfileDTO) cr.uniqueResult();
		return userDetailsDTO;
	}


	@Override
	public List<UserProfileForm> findAllusers(int offset) throws DataAccessLayerException {
		List<UserProfileForm> userList =  new ArrayList<UserProfileForm>();
		List<UserProfileDTO> userDTOList =  new ArrayList<UserProfileDTO>();

		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserProfileDTO.class);
		cr.add(Restrictions.eq("status", true));
		cr.setFirstResult(offset);
		cr.setMaxResults(SqlConstants.PAGESIZE);
		userDTOList = cr.list();
		for (UserProfileDTO userDTO : userDTOList) {
			UserProfileForm userDetails = new UserProfileForm();
			BeanUtils.copyProperties(userDTO, userDetails);
			userList.add(userDetails);
		}
		return userList;
	}


	@Override
	public UserProfileForm findUserByMobile(String mobile) throws DataAccessLayerException {

		UserProfileForm userDetails = new UserProfileForm();
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserProfileDTO.class);
		cr.add(Restrictions.eq("mobileNo", mobile));
		UserProfileDTO userDTO = (UserProfileDTO)cr.uniqueResult();
		
		Logger.info("user details {}",userDTO);
		if(null  == userDTO) {
			throw new DataAccessLayerException();
		}
		try {
			BeanUtils.copyProperties(userDTO, userDetails);
		}catch(Exception e) {
			System.out.println("Hello");
		}
		userDetails.setUserType("1");
		return userDetails;
	}





	/************
	 * 
	 * Below method is used to save basic detail of recruiter
	 * so after registration recruiter can access post a new job option , update a profile,view profile
	 * Recruiter id should be generated which is used as a forien key in job posting table 
	 * 
	 * ************/	

	@Override
	public RecruiterProfileForm saveRecruiterProfile(RecruiterProfileForm recruiterProfile) 
			throws DataAccessLayerException,ApplicationException {
		
		try {
			
			Session session=sessionFactory.getCurrentSession();
			RecruiterProfileDTO recruiterProfileDTO=new RecruiterProfileDTO();
			BeanUtils.copyProperties(recruiterProfile, recruiterProfileDTO);
			session.saveOrUpdate(recruiterProfileDTO);
			BeanUtils.copyProperties(recruiterProfileDTO, recruiterProfile);
			Logger.info("Recruiter details saved");
			
		} catch (Exception e) {
			Logger.error(e.getCause().toString());
			throw  new DataAccessLayerException(e);
		}
		return recruiterProfile;
	}


	@Override
	public RecruiterProfileForm updateRecruiterProfile(RecruiterProfileForm recruiterProfile) throws DataAccessLayerException {
		Session session=sessionFactory.getCurrentSession();
		RecruiterProfileDTO recruiterProfileDTO= (RecruiterProfileDTO) session.get(RecruiterProfileDTO.class,recruiterProfile.getId());
		recruiterProfile=valuesForUpdate(recruiterProfileDTO,recruiterProfile);
		BeanUtils.copyProperties(recruiterProfile, recruiterProfileDTO);
		session.saveOrUpdate(recruiterProfileDTO);
		BeanUtils.copyProperties(recruiterProfileDTO, recruiterProfile);
		Logger.info("Recruiter details updated");
		return recruiterProfile;
	}

	
	@Override
	public RecruiterProfileForm findRecruiterProfile(String mobile) throws DataAccessLayerException {

		RecruiterProfileForm recruiterProfile = new RecruiterProfileForm();
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(RecruiterProfileDTO.class);
		cr.add(Restrictions.eq("mobileNo", mobile));
		RecruiterProfileDTO recruiterProfileDTO = (RecruiterProfileDTO)cr.uniqueResult();
		Logger.info("recruiter details {}",recruiterProfileDTO );
		if(null  == recruiterProfileDTO) {
			throw new DataAccessLayerException(ResponseStatus.NOT_FOUND, new Throwable(ResponseStatus.NOT_FOUND) );
		}
		Logger.info("Recruiter details returned By Mobile");
		BeanUtils.copyProperties(recruiterProfileDTO, recruiterProfile);
		recruiterProfile.setUserType("2");
		return recruiterProfile;
	}

	
	@Override
	public RecruiterProfileDTO findRecruiterById(BigInteger Id) throws DataAccessLayerException {

		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(RecruiterProfileDTO.class);
		cr.add(Restrictions.eq("id", Id));
		RecruiterProfileDTO recruiterProfileDTO = (RecruiterProfileDTO)cr.uniqueResult();
		Logger.info("recruiter details {}",recruiterProfileDTO );
		if(null  == recruiterProfileDTO) {
			throw new DataAccessLayerException(ResponseStatus.NOT_FOUND, new Throwable(ResponseStatus.NOT_FOUND) );
		}
		Logger.info("Recruiter details returned By Id");
		return recruiterProfileDTO;
	}

	
	
	public boolean findRecruiterProfileAlreadyExistOrNot(RecruiterProfileForm recruiter) throws DataAccessLayerException {

		RecruiterProfileForm recruiterProfile = new RecruiterProfileForm();
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(RecruiterProfileDTO.class);
		cr.add(Restrictions.eq("mobileNo", recruiter.getMobileNo()));
		RecruiterProfileDTO recruiterProfileDTO = (RecruiterProfileDTO)cr.uniqueResult();
		Logger.info("recruiter details {}",recruiterProfileDTO );
		if(null  == recruiterProfileDTO) {
			return true;
		}
		Logger.info("Recruiter details returned By Mobile");
		return false;
	}

	public boolean findRecruiterProfileAlreadyExistOrNotById(RecruiterProfileForm recruiter) throws DataAccessLayerException {

		RecruiterProfileForm recruiterProfile = new RecruiterProfileForm();
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(RecruiterProfileDTO.class);
		cr.add(Restrictions.eq("id", recruiter.getId()));
		RecruiterProfileDTO recruiterProfileDTO = (RecruiterProfileDTO)cr.uniqueResult();
		Logger.info("recruiter details {}",recruiterProfileDTO );
		if(null  == recruiterProfileDTO) {
			return false;
		}
		Logger.info("Recruiter details returned By Mobile");
		return true;
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserProfileForm> findApplicantForJob(String job_id ,int offset) throws DataAccessLayerException {
		List<UserProfileForm> userList =  new ArrayList<UserProfileForm>();
		List<UserProfileDTO> userDTOList =  null;
		
		Session session=sessionFactory.openSession();
		SQLQuery  query = session.createSQLQuery(SqlConstants.fetch_all_Applicants);
		query.addEntity(UserProfileDTO.class);
		query.setParameter(0, job_id);
		query.setFirstResult(offset);
		query.setMaxResults(SqlConstants.PAGESIZE);
		userDTOList =  query.list();
		for(UserProfileDTO user: userDTOList )
		{
			UserProfileForm  userProfile = new UserProfileForm();
			BeanUtils.copyProperties(user, userProfile);
			userList.add(userProfile);
		}
		
		return userList;
	}
	
	
public RecruiterProfileForm  valuesForUpdate(RecruiterProfileDTO RecruiterProfileDTO,RecruiterProfileForm recruiterProfile) {
		
		if(null!=recruiterProfile.getFirstName()) {
			RecruiterProfileDTO.setFirstName(recruiterProfile.getFirstName());
		}
	    if(null!=recruiterProfile.getLastName()) {
	    	RecruiterProfileDTO.setLastName(recruiterProfile.getLastName());
	    }
	    if(null!=recruiterProfile.getFullName()) {
	    	RecruiterProfileDTO.setFullName(recruiterProfile.getFullName());
	    }
	    if(null!=recruiterProfile.getPhotoName()) {
	    	RecruiterProfileDTO.setPhotoName(recruiterProfile.getPhotoName());
	    }
	    if(null!=recruiterProfile.getPhotoPath()) {
	    	RecruiterProfileDTO.setPhotoPath(recruiterProfile.getPhotoPath());
	    }
	    if(null!=recruiterProfile.getCompanyName()) {
	    	RecruiterProfileDTO.setCompanyName(recruiterProfile.getCompanyName());
	    }
	    if(null!=recruiterProfile.getCompanyLocation()) {
	    	RecruiterProfileDTO.setCompanyLocation(recruiterProfile.getCompanyLocation());
	    }
	    if(null!=recruiterProfile.getDob()) {
	    	RecruiterProfileDTO.setDob(recruiterProfile.getDob());
	    }
	    if(null!=recruiterProfile.getMobileNo()) {
	    	RecruiterProfileDTO.setMobileNo(recruiterProfile.getMobileNo());
	    }
	    if(null!=recruiterProfile.getEmail()) {
	    	RecruiterProfileDTO.setEmail(recruiterProfile.getEmail());
	    }
	    
	    if(null!=recruiterProfile.getCountry()) {
	    	RecruiterProfileDTO.setCountry(recruiterProfile.getCountry());
	    }
	    
	    if(null!=recruiterProfile.getFlagHire()) {
	    	RecruiterProfileDTO.setFlagHire(recruiterProfile.getFlagHire());
	    }
	    if(null!=recruiterProfile.getCreatedBy()) {
	    	RecruiterProfileDTO.setCrtd_by(recruiterProfile.getCreatedBy());
	    }
	    if(null!=recruiterProfile.getCreatedDate()) {
	    	RecruiterProfileDTO.setCrtd_tmstmp(recruiterProfile.getCreatedDate());
	    }
	    if(null!=recruiterProfile.getMdfdBy()) {
	    	RecruiterProfileDTO.setMdfd_by(recruiterProfile.getMdfdBy());
	    }
	    if(null!=recruiterProfile.getMdfdDate()) {
	    	RecruiterProfileDTO.setMdfd_tmstmp(recruiterProfile.getMdfdDate());
	    }
	    
	    BeanUtils.copyProperties(RecruiterProfileDTO, recruiterProfile);
		return recruiterProfile;
	}

}

