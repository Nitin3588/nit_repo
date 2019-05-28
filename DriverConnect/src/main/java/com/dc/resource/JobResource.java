package com.dc.resource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dc.bean.BaseResponse;
import com.dc.bean.JobApplyForm;
import com.dc.bean.JobDetailForm;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.SearchProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dto.UserProfileDTO;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.JobService;
import com.dc.service.UserService;
import com.dc.utill.CommonUtill;
import com.dc.utill.Constants.ResponseStatus;


@RestController
@RequestMapping("/mob")
public class JobResource {


	@Autowired
	JobService  jobService;
	@Autowired
	UserService userService;

	private  static final Logger Logger = LoggerFactory.getLogger(JobResource.class); 
	
	@RequestMapping(value = "/postJob", method = RequestMethod.POST)
	public @ResponseBody BaseResponse postJob(@RequestBody  JobDetailForm jobPostingForm) {

		BaseResponse response = new BaseResponse();
		boolean status = false;
		if (null != jobPostingForm) {
			//Logger.info("received : " + userId );
			List<String> errors=validateJobDetailForm(jobPostingForm);
			if(errors.size() != 0) {
				response.setStatus(ResponseStatus.ERROR_OCCURED);
				response.setCode(ResponseStatus.ERROR_CODE);
				response.setObj(errors.get(0));
				return response;
			}
			try {
				if(jobPostingForm.getRecId() != null ) {
					RecruiterProfileForm   recruiter  = new RecruiterProfileForm();
					recruiter.setId(jobPostingForm.getRecId());
					status  = userService.findRecruiterProfileAlreadyExistOrNotById(recruiter);
					
					if (!status)
					{ response.setStatus(ResponseStatus.NOT_AUTHORIZED);
					response.setCode(ResponseStatus.NOT_AUTHORIZED_CODE);
					return response;
					}
				} 
				// call for genrating unique job id 
				String jobId =  CommonUtill.generateJObAckId(jobPostingForm.getRecId().toString());
				jobPostingForm.setJobId(jobId);
				jobPostingForm = jobService.saveJobPostingDetails(jobPostingForm);

			} catch (DataAccessLayerException e) {
				e.printStackTrace();
				response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
				response.setCode(ResponseStatus.EXCEPTION_CODE);
			}
			response.setStatus(ResponseStatus.SUCESS);
			response.setCode(ResponseStatus.SUCESS_CODE);
			response.setObj(jobPostingForm);
		} else {
			response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
			response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
		}
		return response;
	}

	
	@RequestMapping(value = "/getJobDetail", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> getJobDetail(@RequestParam(value = "jobId") String jobId)
	{
		JobDetailForm job=null;
		BaseResponse response = new BaseResponse();
		if (null != jobId && !jobId.equalsIgnoreCase("")) {
			try {
				//RecruiterProfileForm recruiterProfile=new RecruiterProfileForm();
				//recruiterProfile.setId(BigInteger.valueOf( Integer.valueOf(recId)));
				job = jobService.getJobDetail(jobId);
				if(null != job ) {
					response.setObj(job);	
					response.setStatus(ResponseStatus.SUCESS);
					response.setCode(ResponseStatus.SUCESS_CODE);	
				}	
				else {
					response.setStatus(ResponseStatus.NOT_FOUND);
					response.setCode(ResponseStatus.NOT_FOUND_CODE);
				}

			} catch (DataAccessLayerException e) {
				e.printStackTrace();
				response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
				response.setCode(ResponseStatus.EXCEPTION_CODE);
			}
		} else {
			response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
			response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
		}
		return new ResponseEntity<BaseResponse>(response,HttpStatus.CREATED);
	}
	

	//fetches jobs list for recruiter 
	@RequestMapping(value = "/fetchJobDetail", method = RequestMethod.POST)
	public ResponseEntity<List<JobDetailForm>> fetchJobDetail(@RequestBody SearchProfileForm searchProfileForm, @RequestParam(value = "offset") int offset)
	{
		List<JobDetailForm> jobsList=null;
		String recId =  searchProfileForm.getRecId();
		BaseResponse response = new BaseResponse();
		if (null != recId && !recId.equalsIgnoreCase("")) {
			try {
				
				offset = offset*10;  
				RecruiterProfileForm recruiterProfile=new RecruiterProfileForm();
				recruiterProfile.setId(BigInteger.valueOf( Integer.valueOf(recId)));
				jobsList= jobService.fetchJobDetailsForRecruiter(searchProfileForm , offset);
				
				if(jobsList.size() < 0) {
					response.setStatus(ResponseStatus.NOT_FOUND);
					response.setCode(ResponseStatus.NOT_FOUND_CODE);
				}
				
			} catch (DataAccessLayerException e) {
				e.printStackTrace();
				response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
				response.setCode(ResponseStatus.EXCEPTION_CODE);
			}
			response.setStatus(ResponseStatus.SUCESS);
			response.setCode(ResponseStatus.SUCESS_CODE);
		} else {
			response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
			response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
		}
		return new ResponseEntity<List<JobDetailForm>>(jobsList,HttpStatus.CREATED);
	}


	//fetches jobs list for recruiter 
	@RequestMapping(value = "/fetchJobDetailsForSubscriber", method = RequestMethod.POST)
	public ResponseEntity<List<JobDetailForm>> fetchJobDetailsForSubscriber(@RequestBody SearchProfileForm searchProfileForm, @RequestParam(value = "offset") int offset)
	{
		String sub_id=searchProfileForm.getSub_id();
		List<JobDetailForm> jobsList=null;
		BaseResponse response = new BaseResponse();
		if (null != sub_id && !sub_id.equalsIgnoreCase("")) {
			try {
				UserProfileForm userForm=new UserProfileForm();
				userForm.setId(CommonUtill.convertTOBigInteger(sub_id));
				
				offset = offset*10;
				searchProfileForm.setUserForm(userForm);
				jobsList= jobService.fetchJobDetailsForSubscriber(searchProfileForm,offset);
				if(jobsList.size() < 0) {
					response.setStatus(ResponseStatus.NOT_FOUND);
					response.setCode(ResponseStatus.NOT_FOUND_CODE);
				} 

			} catch (DataAccessLayerException e) {
				e.printStackTrace();
				response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
				response.setCode(ResponseStatus.EXCEPTION_CODE);
			}
			response.setStatus(ResponseStatus.SUCESS);
			response.setCode(ResponseStatus.SUCESS_CODE);
		} else {
			response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
			response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
		}
		return new ResponseEntity<List<JobDetailForm>>(jobsList,HttpStatus.CREATED);
	}


	@RequestMapping(value = "/editJob", method = RequestMethod.POST)
	public @ResponseBody BaseResponse editJob(@RequestBody  JobDetailForm jobPostingForm) {

		BaseResponse response = new BaseResponse();
		boolean status = false; 
		if(null==jobPostingForm  || jobPostingForm.getJobId()==null ||	jobPostingForm.getRecId()==null)  {
				
				response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
				response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
				return response;
			}
		//	|| (!jobPostingForm.getJobId().matches("[0-9]+$"))) { /*Recruitment id check is it exist or not is it valid or not*/
		
		try {
			 RecruiterProfileForm recruiterProfile=new RecruiterProfileForm();
			 recruiterProfile.setId(jobPostingForm.getRecId());
			 status = userService.findRecruiterProfileAlreadyExistOrNotById(recruiterProfile);
			
			 if(!status) {
				response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
				response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
				return response;
			}
			 
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
			response.setCode(ResponseStatus.EXCEPTION_CODE);
			return response;
		}
		/*Job id check is it exist or not is it valid or not*/
		try {
			
			if(status) {
				/*take out job detail with rec id change status to deactivate*/
				jobPostingForm =  jobService.updateJobPostingDetails(jobPostingForm);	
				response.setStatus(ResponseStatus.SUCESS);
				response.setCode(ResponseStatus.SUCESS_CODE);
			}
			 
		}catch(Exception e) {
			Logger.error(e.getLocalizedMessage());
			response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
			response.setCode(ResponseStatus.EXCEPTION_CODE);
			return response;
		}
	
		return response;
	}


	@RequestMapping(value = "/applyForAJob", method = RequestMethod.POST)
	public @ResponseBody BaseResponse applyForAJob(@RequestBody  JobApplyForm jobApplyForm) {
		BaseResponse response = new BaseResponse();
		if(null!=jobApplyForm) {

		/*check Driver id is in proper format or not then is it exist in database or not*/
			if(null==jobApplyForm.getId()) {
				response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
				response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
				return response;
			}else {
				try {
					UserProfileDTO userProfileDTO= userService.findUserById(jobApplyForm.getId());
					if(null==userProfileDTO) {
						response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
						response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
						return response;
					}
				}catch(Exception e) {
					e.printStackTrace();
					response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
					response.setCode(ResponseStatus.EXCEPTION_CODE);
					return response;
				}
			}

		/*check job id is in proper format or not then check is it exist or not && check job id is in active or deactive status*/
			if(null==jobApplyForm.getJobId()) {
				response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
				response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
				return response;
			}else {
				try {
						JobDetailForm jobDetailForm = new JobDetailForm();
						jobDetailForm.setJobId(jobApplyForm.getJobId());
						jobDetailForm.setStatus(true);
						boolean flag=jobService.checkJobDetailsExistOrNotById(jobDetailForm);
						if(!flag) {
							response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
							response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
							return response;
						}
				}catch(Exception e) {
					response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
					response.setCode(ResponseStatus.EXCEPTION_CODE);
					return response;
				}
			}

		/*insert into a table which is having jobid ,driver id , job description*/
			try {
				jobApplyForm.setCreatedDate(new Date());
					jobApplyForm=jobService.saveJobAppliedDetails(jobApplyForm);
					response.setStatus(ResponseStatus.SUCESS);
					response.setCode(ResponseStatus.SUCESS_CODE);
			}catch(Exception e) {
				e.printStackTrace();
				response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
				response.setCode(ResponseStatus.EXCEPTION_CODE);
				return response;
			}
		}else {
			response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
			response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
			return response;
		}
		return response;
	}

	
	
	
	@RequestMapping(value = "/editJobStatus", method = RequestMethod.POST)
	public @ResponseBody BaseResponse editJobStatus(@RequestParam(value = "jobId") String jobid,@RequestParam(value = "status") boolean jobStatus,
			@RequestParam(value = "recId") String recId) {

		BaseResponse response = new BaseResponse();
		boolean status = false; 
		if(null==jobid  || 	jobid=="")  {
				response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
				response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
				return response;
			}
		try {
			 RecruiterProfileForm recruiterProfile=new RecruiterProfileForm();
			 recruiterProfile.setId(CommonUtill.convertTOBigInteger(recId) );
			 status = userService.findRecruiterProfileAlreadyExistOrNotById(recruiterProfile);
			if(!status) {
				response.setStatus(ResponseStatus.INVALID_CREDENTIALS);
				response.setCode(ResponseStatus.INVALID_CREDENTIALS_CODE);
				return response;
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
			response.setCode(ResponseStatus.EXCEPTION_CODE);
			return response;
		}
		/*Job id check is it exist or not is it valid or not*/
		try {
			if(status) {
				/*take out job detail with rec id change status to deactivate*/
				jobService.updateJobStatus(jobid, recId ,jobStatus);	
				response.setStatus(ResponseStatus.SUCESS);
				response.setCode(ResponseStatus.SUCESS_CODE);
			}
			 
		}catch(Exception e) {
			Logger.error(e.getLocalizedMessage());
			response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
			response.setCode(ResponseStatus.EXCEPTION_CODE);
			return response;
		}
	
		return response;
	}
	
	
	
	public List<String> validateJobDetailForm(JobDetailForm jobPostingForm) {
		List<String> errors=new ArrayList<String>();
		if (null == jobPostingForm.getRecId() || String.valueOf(jobPostingForm.getRecId()).equalsIgnoreCase("")
				|| !String.valueOf(jobPostingForm.getRecId()).matches("\\d+")) {
			errors.add("Please enter valid recruiter id");
		}if(null== jobPostingForm.getCompanyName() ||
				jobPostingForm.getCompanyName().equalsIgnoreCase("")) {
			errors.add("Please enter valid company name");	
		}if(null== jobPostingForm.getJobTitle() ||
				jobPostingForm.getJobTitle().equalsIgnoreCase("")) {
			errors.add("Please enter valid job title");	
		}if(null== String.valueOf(jobPostingForm.getCrtBy()) ||
				String.valueOf(jobPostingForm.getCrtBy()).equalsIgnoreCase("") || jobPostingForm.getCrtBy()==0) {
			errors.add("Created by value is not provided or may be provided value is not valid");	
		}
		return errors;
		
	}
	
}