package com.dc.dao.impl;

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

import com.dc.bean.CompanyProfileForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dao.CompanyDao;
import com.dc.dto.CompanyProfileDTO;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.DataAccessLayerException;


@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	
	@Autowired
	@Qualifier("hibernateSessionFactory")
	private SessionFactory sessionFactory;

	private  static final Logger Logger = LoggerFactory.getLogger(CompanyDaoImpl.class); 

	@Override
	public CompanyProfileForm saveCompanyDetails(CompanyProfileForm company) throws DataAccessLayerException {
		
		Session session=sessionFactory.openSession();
		CompanyProfileDTO companyProfileDTO=new CompanyProfileDTO();
		BeanUtils.copyProperties(company, companyProfileDTO);
		try {
			session.saveOrUpdate(companyProfileDTO);
			BeanUtils.copyProperties(companyProfileDTO, company);
		}catch (Exception e) {
			throw new DataAccessLayerException(e.getMessage(), e.getCause());
		}
		Logger.info("Company details saved");
		return company;
	}

	@Override
	public List<CompanyProfileForm> fetchCompanyDetailsForRecruiter(RecruiterProfileForm recruiter)	throws DataAccessLayerException {
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(CompanyProfileDTO.class);
		cr.add(Restrictions.eq("recId", recruiter.getId()));
		List<CompanyProfileForm> companyProfileForm =(List<CompanyProfileForm>) cr.list();
		return companyProfileForm;
	}

	@Override
	public List<CompanyProfileForm> fetchCompanyDetailsForSubscriber(UserProfileForm user) throws DataAccessLayerException {
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(CompanyProfileDTO.class);
		//cr.add(Restrictions.eq("recId", user.getId()));
		List<CompanyProfileForm> companyProfileForm =(List<CompanyProfileForm>) cr.list();
		return companyProfileForm;
	}

	@Override
	public CompanyProfileForm updateCompanyDetails(CompanyProfileForm company) throws DataAccessLayerException {
		Session session=sessionFactory.getCurrentSession();
		CompanyProfileDTO companyProfileDTO=new CompanyProfileDTO();
		BeanUtils.copyProperties(company, companyProfileDTO);
		try {
			session.update(companyProfileDTO);
			BeanUtils.copyProperties(companyProfileDTO, company);
		}catch (Exception e) {
			throw new DataAccessLayerException(e.getMessage(), e.getCause());
		}
		Logger.info("User details updated");
		return company;
	}

}
