package com.dc.service.impl;

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
import com.dc.exception.DataAccessLayerException;
import com.dc.service.CompanyService;


@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{

	@Autowired  
	CompanyDao companyDao; 
	
	private  static final Logger Logger = LoggerFactory.getLogger(CompanyServiceImpl.class); 
	
	@Override
	public CompanyProfileForm saveCompanyDetails(CompanyProfileForm company) throws DataAccessLayerException {
		Logger.info("in  saveCompanyDetails");
		return companyDao.saveCompanyDetails(company);
	}

	@Override
	public List<CompanyProfileForm> fetchCompanyDetailsForRecruiter(RecruiterProfileForm recruiter)throws DataAccessLayerException {
		return companyDao.fetchCompanyDetailsForRecruiter(recruiter);
	}

	@Override
	public List<CompanyProfileForm> fetchCompanyDetailsForSubscriber(UserProfileForm user) throws DataAccessLayerException {
		return companyDao.fetchCompanyDetailsForSubscriber(user);
	}

	@Override
	public CompanyProfileForm updateCompanyDetails(CompanyProfileForm company) throws DataAccessLayerException {
		return companyDao.updateCompanyDetails(company);
	}
	
	

}
