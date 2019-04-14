package com.dc.dao;

import java.util.List;

import com.dc.bean.JobApplyForm;
import com.dc.bean.JobDetailForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.SearchProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.exception.DataAccessLayerException;

public interface JobDao {

	public JobDetailForm saveJobPostingDetails(JobDetailForm jobPostingForm) throws DataAccessLayerException;
	
	public List<JobDetailForm> fetchJobDetailsForRecruiter(SearchProfileForm searchProfileForm, int offset) throws DataAccessLayerException;
	
	public List<JobDetailForm> fetchJobDetailsForSubscriber(SearchProfileForm searchProfileForm , int offset) throws DataAccessLayerException;
	
	/*public boolean checkJobDetailsExistOrNot(JobDetailForm jobDetailForm) throws DataAccessLayerException;*/
	
	public JobDetailForm updateJobPostingDetails(JobDetailForm jobPostingForm) throws DataAccessLayerException;
	
	public boolean checkJobDetailsExistOrNotById(JobDetailForm jobDetailForm) throws DataAccessLayerException;
	
	public JobApplyForm saveJobAppliedDetails(JobApplyForm jobApplyForm) throws DataAccessLayerException;
	
	public boolean updateJobStatus(String jobId,String recId,boolean status) throws DataAccessLayerException;
	
	public JobDetailForm getJobDetail(String jobId) throws DataAccessLayerException;
	
}
