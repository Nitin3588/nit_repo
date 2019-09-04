package com.dc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.bean.JobApplyForm;
import com.dc.bean.JobDetailForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.SearchProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dao.JobDao;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.JobService;
import com.dc.utill.Constants;

@Service("JobService")
@Transactional
public class JobServiceImpl implements JobService {
	
	@Autowired
	JobDao  jobDao;
	
	
	private  static final Logger Logger = LoggerFactory.getLogger(JobServiceImpl.class); 
	
	public JobDetailForm saveJobPostingDetails(JobDetailForm jobPostingForm) throws DataAccessLayerException{
		Logger.info("saveJobPostingDetails");
		return jobDao.saveJobPostingDetails(jobPostingForm);
	}

	public List<JobDetailForm> fetchJobDetailsForRecruiter(SearchProfileForm searchProfileForm,int offset) throws DataAccessLayerException{
		return jobDao.fetchJobDetailsForRecruiter(searchProfileForm ,offset);
	}
	
	public List<JobDetailForm> fetchJobDetailsForSubscriber(SearchProfileForm searchProfileForm, int offset) throws DataAccessLayerException{
		return jobDao.fetchJobDetailsForSubscriber(searchProfileForm,offset);
	}
	
	/*public boolean checkJobDetailsExistOrNot(JobDetailForm jobDetailForm) throws DataAccessLayerException{
		return jobDao.checkJobDetailsExistOrNot(jobDetailForm);
	}*/

	public JobDetailForm updateJobPostingDetails(JobDetailForm jobPostingForm) throws DataAccessLayerException{
		return jobDao.updateJobPostingDetails(jobPostingForm);
	}
	
	public boolean checkJobDetailsExistOrNotById(JobDetailForm jobDetailForm) throws DataAccessLayerException{
		return jobDao.checkJobDetailsExistOrNotById(jobDetailForm);
	}
	
	public JobApplyForm saveJobAppliedDetails(JobApplyForm jobApplyForm) throws DataAccessLayerException{
		return jobDao.saveJobAppliedDetails(jobApplyForm);
	}

	@Override
	public boolean updateJobStatus(String jobId, String recId, boolean status) throws DataAccessLayerException {
		return jobDao.updateJobStatus(jobId, recId, status);
	}

	@Override
	public JobDetailForm getJobDetail(String jobId ,String userType ,String userId) throws DataAccessLayerException {
		return jobDao.getJobDetail(jobId ,userType, userId);
	}
	
}
