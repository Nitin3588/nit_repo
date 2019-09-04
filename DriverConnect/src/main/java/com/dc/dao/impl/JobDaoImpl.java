package com.dc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dc.bean.JobApplyForm;
import com.dc.bean.JobDetailForm;
import com.dc.bean.SearchProfileForm;
import com.dc.dao.JobDao;
import com.dc.dto.JobApplyDTO;
import com.dc.dto.JobDetailDTO;
import com.dc.exception.DataAccessLayerException;
import com.dc.utill.CommonUtill;
import com.dc.utill.Constants;
import com.dc.utill.SqlConstants;

@Repository
public class JobDaoImpl  extends CommonUtill  implements JobDao  {
	
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
		cr.add(Restrictions.eq("recId",convertTOBigInteger(searchProfileForm.getRecId())));
		
		 if(searchProfileForm.getFromDate() != null &&  "" !=searchProfileForm.getFromDate()) {
			 cr.add(Restrictions.eq("crtdDate",searchProfileForm.getFromDate()));
		 }
		 if(searchProfileForm.getToDate() != null && "" != searchProfileForm.getToDate()) {
			 cr.add(Restrictions.eq("crtdDate",searchProfileForm.getToDate()));
		 }
		 if(null !=searchProfileForm.getEmploymentType() &&  ""!=searchProfileForm.getEmploymentType()) {
			 cr.add(Restrictions.eq("employmentType", searchProfileForm.getEmploymentType()));
		 }
		 if( null !=  searchProfileForm.getCityList()    &&  !searchProfileForm.getCityList().isEmpty() ) {
				// cr.add(Restrictions.in("cityId",searchProfileForm.getCityList()));
				 cr.createAlias( "cityList", "cityList" );
	             cr.add(Expression.in("cityList.elements",searchProfileForm.getCityList()));
				 
		 }
		 if(null  != searchProfileForm.getVechicleList() &&  !searchProfileForm.getVechicleList().isEmpty() ) {
			   //cr.add(Restrictions.in("vechicleTypes", searchProfileForm.getVechicleList()));
			cr.createAlias( "vechicleTypes", "vechicleTypes" );
			cr.add(Expression.in("vechicleTypes.elements",searchProfileForm.getVechicleList()));
		 }
		
		cr.addOrder(Order.desc("id"));
		cr.addOrder(Order.desc("crtdDate")); 
		cr.setFirstResult(offset);
		cr.setMaxResults(SqlConstants.PAGESIZE);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<JobDetailForm> jobPostingForm =(List<JobDetailForm>) cr.list();
		return jobPostingForm;
		
	}

	public List<JobDetailForm> fetchJobDetailsForSubscriber(SearchProfileForm searchProfileForm,int offset) throws DataAccessLayerException{
		 Session session=sessionFactory.openSession();
		 
		 SQLQuery query = session.createSQLQuery( SqlConstants.fetch_all_Applied_Jobs);
		 query.setParameter(0, searchProfileForm.getUserForm().getId());
		 query.addEntity(JobDetailDTO.class);
		 
		 List <JobDetailDTO> appliedJobList  = (List<JobDetailDTO>) query.list();
		 Map <BigInteger,JobDetailDTO> appliedJobMap = new LinkedHashMap <BigInteger ,JobDetailDTO>(); 
		 if(appliedJobList.size() != 0)
		 for(JobDetailDTO job: appliedJobList) {
			 appliedJobMap.put(job.getId(), job);
		 }
		 
		 Criteria cr = session.createCriteria(JobDetailDTO.class);
		
		 if(null != searchProfileForm.getRecId() &&  "" != searchProfileForm.getRecId()) {
			 cr.add(Restrictions.eq("recId",CommonUtill.convertTOBigInteger(searchProfileForm.getRecId())));
		 }
		 if( null !=  searchProfileForm.getCityList()    &&  !searchProfileForm.getCityList().isEmpty() ) {
			// cr.add(Restrictions.in("cityId",searchProfileForm.getCityList()));
			 cr.createAlias( "cityList", "cityList" );
             cr.add(Expression.in("cityList.elements",searchProfileForm.getCityList()));
			 
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
		 if(null  != searchProfileForm.getVechicleList() &&  !searchProfileForm.getVechicleList().isEmpty() ) {
			   //cr.add(Restrictions.in("vechicleTypes", searchProfileForm.getVechicleList()));
			cr.createAlias( "vechicleTypes", "vechicleTypes" );
			cr.add(Expression.in("vechicleTypes.elements",searchProfileForm.getVechicleList()));
		 }
		 
		 if(searchProfileForm.getSalaryAnnual() != null) {
			 cr.add(Restrictions.between("salaryAnnual",searchProfileForm.getMinSalary(), searchProfileForm.getMaxSalary()));
		 }
		 
		 cr.add(Restrictions.eq("status",true ));
		 cr.addOrder(Order.desc("id"));
		 cr.addOrder(Order.desc("crtdDate"));
		 
		/* if(searchProfileForm.getMinSalary() != null) {
			 cr.add(Restrictions.ge("minSalary",searchProfileForm.getMinSalary()));
		 }
		 if(searchProfileForm.getMaxSalary() != null) {
			 cr.add(Restrictions.le("maxSalary",searchProfileForm.getMaxSalary()));
		 }*/
		 
		 cr.setFirstResult(offset);
		 cr.setMaxResults(SqlConstants.PAGESIZE);
		 System.out.println("CR detail {}" + cr.toString());
		 
		 cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

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
	public JobDetailForm getJobDetail(String jobId ,String userType,String subscriberId) throws DataAccessLayerException {
		Session session=sessionFactory.openSession();
		JobDetailForm  job = null ;
	
	Criteria cr = session.createCriteria(JobDetailDTO.class);
		cr.add(Restrictions.eq("jobId", jobId));
		if(Integer.valueOf(userType).equals(Constants.userRole.ROLE_DRIVER)) {
			cr.add(Restrictions.eq("status",true ));
			JobDetailDTO jobDTO= (JobDetailDTO) cr.uniqueResult();
			if(null != jobDTO) {
				 job =new JobDetailForm();
				 BeanUtils.copyProperties(jobDTO, job);
				 job.setStatus(getappliedJobStatus(jobId, subscriberId));
			}
			
		}else {
		JobDetailDTO jobDTO= (JobDetailDTO) cr.uniqueResult();
		if(null != jobDTO) {
					job =new JobDetailForm();
					 BeanUtils.copyProperties(jobDTO, job);
		}
	}
		return job;
	}
	
	
	public boolean getappliedJobStatus(String jobId ,String subscriberId) throws DataAccessLayerException {
		Session session=sessionFactory.openSession();
		boolean  status = false ;
		Criteria cr = session.createCriteria(JobApplyDTO.class);
		cr.add(Restrictions.eq("jobId", jobId));
		cr.add(Restrictions.eq("id", CommonUtill.convertTOBigInteger(subscriberId)));
			
		JobApplyDTO jobApplyDTO= (JobApplyDTO) cr.uniqueResult();
		if(null != jobApplyDTO) {
			status = true;
		}
		return status;
	}
	
	
	
	

}
