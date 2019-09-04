package com.dc.dao;

import java.math.BigInteger;
import java.util.List;

import com.dc.bean.CompanyProfileForm;
import com.dc.bean.JobDetailForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.exception.DataAccessLayerException;

public interface CompanyDao {
	
	public CompanyProfileForm saveCompanyDetails(CompanyProfileForm company) throws DataAccessLayerException;
	
	public List<CompanyProfileForm> fetchCompanyDetailsForRecruiter(RecruiterProfileForm recruiter) throws DataAccessLayerException;	
	
	public List<CompanyProfileForm> fetchCompanyDetailsForSubscriber(UserProfileForm user) throws DataAccessLayerException;
	
	public CompanyProfileForm updateCompanyDetails(CompanyProfileForm company) throws DataAccessLayerException;

	public CompanyProfileForm fetchCompanyDetails(BigInteger bigInteger)throws DataAccessLayerException;

}
