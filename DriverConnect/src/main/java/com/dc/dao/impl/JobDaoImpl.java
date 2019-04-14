package com.dc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dc.bean.JobApplyForm;
import com.dc.bean.JobDetailForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.SearchProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dao.JobDao;
import com.dc.dto.JobApplyDTO;
import com.dc.dto.JobDetailDTO;
import com.dc.exception.DataAccessLayerException;
import com.dc.utill.CommonUtill;
import com.dc.utill.SqlConstants;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Repository
public class JobDaoImpl implements JobDao {
	
	@Autowired
	@Qualifier("hibernateSessionFactory")
	private SessionFactory sessionFactory;
	
	private  static final Logger Logger = LoggerFactory.getLogger(JobDaoImpl.class); 
	
	public JobDetailForm saveJobPostingDetails(JobDetailForm jobPostingForm) throws DataAccessLayerException{
		Session session=sessionFactory.getCurrentSession();
		JobDetailDTO jobPostingDetailsDTO=new JobDetailDTO();
		BeanUtils.copyProperties(jobPostingForm, jobPostingDetailsDTO);
		session.save(jobPostingDetailsDTO);
		BeanUtils.copyProperties(jobPostingDetailsDTO, jobPostingForm);
		return jobPostingForm;
		
	}
	
	public JobDetailForm updateJobPostingDetails(JobDetailForm jobPostingForm) throws DataAccessLayerException{
		Session session=sessionFactory.getCurrentSession();
		JobDetailDTO jobPostingDetailsDTO=new JobDetailDTO();
		jobPostingDetailsDTO = (JobDetailDTO) session.get(JobDetailDTO.class , jobPostingForm.getId());
		BeanUtils.copyProperties(jobPostingForm, jobPostingDetailsDTO);
		session.update(jobPostingDetailsDTO);
		BeanUtils.copyProperties(jobPostingDetailsDTO, jobPostingForm);
		return jobPostingForm;
		
	}
	
	
	public List<JobDetailForm> fetchJobDetailsForRecruiter(SearchProfileForm searchProfileForm ,int offset) 
			throws DataAccessLayerException{
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(JobDetailDTO.class);
		cr.add(Restrictions.eq("recId", searchProfileForm.getRecId()));
		
		 
		 if(searchProfileForm.getFromDate() != null &&  "" !=searchProfileForm.getFromDate()) {
			 cr.add(Restrictions.eq("crtdDate",searchProfileForm.getFromDate()));
			 
		 }
		 if(searchProfileForm.getToDate() != null && "" != searchProfileForm.getToDate()) {
			 cr.add(Restrictions.eq("crtdDate",searchProfileForm.getToDate()));
			 
		 }
		 
		 if(null !=searchProfileForm.getEmploymentType() &&  ""!=searchProfileForm.getEmploymentType()) {
			 cr.add(Restrictions.eq("employmentType", searchProfileForm.getEmploymentType()));
			 
		 }
		 
		 if(null  != searchProfileForm.getVechicleType() &&  ""!= searchProfileForm.getVechicleType() ) {
			 cr.add(Restrictions.in("vechicleType",searchProfileForm.getVechicleList()));
			 
		 }
		 
		cr.setFirstResult(offset);
		cr.setMaxResults(SqlConstants.PAGESIZE);
		List<JobDetailForm> jobPostingForm =(List<JobDetailForm>) cr.list();
		return jobPostingForm;
		
	}

	public List<JobDetailForm> fetchJobDetailsForSubscriber(SearchProfileForm searchProfileForm,int offset) throws DataAccessLayerException{
		 Session session=sessionFactory.openSession();
		 
		 SQLQuery query = session.createSQLQuery( SqlConstants.fetch_all_Applied_Jobs);
		 query.setParameter(0, searchProfileForm.getUserForm().getId());
		 query.addEntity(JobDetailDTO.class);
		 
		 List <JobDetailDTO> appliedJobList  = (List<JobDetailDTO>) query.list();
		 Map <BigInteger,JobDetailDTO> appliedJobMap = new HashMap<BigInteger ,JobDetailDTO>(); 
		 if(appliedJobList.size() != 0)
		 for(JobDetailDTO job: appliedJobList) {
			 appliedJobMap.put(job.getId(), job);
		 }
		 
		 Criteria cr = session.createCriteria(JobDetailDTO.class);
		
		 if(null != searchProfileForm.getRecId() &&  "" != searchProfileForm.getRecId()) {
			 cr.add(Restrictions.eq("recId",CommonUtill.convertTOBigInteger(searchProfileForm.getRecId())));
			 
		 }
		 if(searchProfileForm.getCityId() != 0 ) {
			 cr.add(Restrictions.in("cityId",searchProfileForm.getCityList()));
			 
		 }
		 if(searchProfileForm.getFromDate() != null &&  "" !=searchProfileForm.getFromDate()) {
			 cr.add(Restrictions.eq("crtdDate",searchProfileForm.getFromDate()));
			 
		 }
		 if(searchProfileForm.getToDate() != null && "" != searchProfileForm.getToDate()) {
			 cr.add(Restrictions.eq("crtdDate",searchProfileForm.getToDate()));
			 
		 }
		 
		 if(null !=searchProfileForm.getEmploymentType() &&  ""!=searchProfileForm.getEmploymentType()) {
			 cr.add(Restrictions.eq("employmentType", searchProfileForm.getEmploymentType()));
			 
		 }
		 
		 if(null  != searchProfileForm.getVechicleType() &&  ""!= searchProfileForm.getVechicleType() ) {
			 cr.add(Restrictions.in("vechicleType",searchProfileForm.getVechicleList()));
			 
		 }
		 
		 if(searchProfileForm.getSalaryAnnual() != null) {
			 cr.add(Restrictions.eq("salaryAnnual",searchProfileForm.getSalaryAnnual()));
			 
		 }
		 
		 
		 cr.setFirstResult(offset);
		 cr.setMaxResults(SqlConstants.PAGESIZE);
		 List<JobDetailDTO> availablejobsList =(List<JobDetailDTO>) cr.list();
		 List<JobDetailForm> resultList = new ArrayList<JobDetailForm>(); 
		 
		 for(JobDetailDTO jobDTO: availablejobsList ) {
			 JobDetailForm  jobForm = new JobDetailForm();
			 if(appliedJobMap.containsKey(jobDTO.getId())) {
				 jobForm.setApplyStatus(true);
			 }
			 BeanUtils.copyProperties(jobDTO, jobForm);
			 resultList.add(jobForm);
		 }
		 Logger.info("jodlist size{}", availablejobsList.size() );
		return resultList;
	}
		

	/*public boolean checkJobDetailsExistOrNot(JobDetailForm jobDetailForm) throws DataAccessLayerException{
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(JobDetailDTO.class);
		cr.add(Restrictions.eq("recId", jobDetailForm.getRecId()));
		cr.add(Restrictions.eq("jobId", jobDetailForm.getJobId()));
		List<JobDetailForm> jobPostingForm =(List<JobDetailForm>) cr.list();
		if(null!=jobPostingForm && jobPostingForm.size()>0 && jobPostingForm.get(0) != null) {
			BeanUtils.copyProperties(jobPostingForm.get(0), jobDetailForm);
			return true;
		}
		return false;
		
	}*/
	
	public boolean checkJobDetailsExistOrNotById(JobDetailForm jobDetailForm) throws DataAccessLayerException{
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(JobDetailDTO.class);
		cr.add(Restrictions.eq("status", jobDetailForm.isStatus()));
		cr.add(Restrictions.eq("jobId", jobDetailForm.getJobId()));
		List<JobDetailForm> jobPostingForm =(List<JobDetailForm>) cr.list();
		if(null!=jobPostingForm && jobPostingForm.size()>0 && jobPostingForm.get(0) != null) {
			BeanUtils.copyProperties(jobPostingForm.get(0), jobDetailForm);
			return true;
		}
		return false;
		
	}
	
	public JobApplyForm saveJobAppliedDetails(JobApplyForm jobApplyForm) throws DataAccessLayerException{
		Session session=sessionFactory.getCurrentSession();
		JobApplyDTO jobApplyDTO=new JobApplyDTO();
		BeanUtils.copyProperties(jobApplyForm, jobApplyDTO);
		session.save(jobApplyDTO);
		BeanUtils.copyProperties(jobApplyDTO, jobApplyForm);
		return jobApplyForm;
		
	}

	@Override
	public boolean updateJobStatus(String jobId, String recId, boolean status) throws DataAccessLayerException {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(JobDetailDTO.class);
		cr.add(Restrictions.eq("recId", CommonUtill.convertTOBigInteger(recId)));
		cr.add(Restrictions.eq("jobId", jobId));
		JobDetailDTO  job = (JobDetailDTO) cr.uniqueResult();
		job.setStatus(status);
		session.save(job);
		return true ;
	}

	@Override
	public JobDetailForm getJobDetail(String jobId) throws DataAccessLayerException {
		Session session=sessionFactory.getCurrentSession();
		JobDetailForm  job = null ;
		Criteria cr = session.createCriteria(JobDetailDTO.class);
		cr.add(Restrictions.eq("jobId", jobId));
		cr.add(Restrictions.eq("status",true ));
		JobDetailDTO jobDTO= (JobDetailDTO) cr.uniqueResult();
		if(null != jobDTO) {
			 job =new JobDetailForm();
			 BeanUtils.copyProperties(jobDTO, job);
		}
		
		return job;
	}
	
	

}
