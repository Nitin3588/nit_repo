package com.dc.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dc.bean.BaseResponse;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.exception.ApplicationException;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.CompanyService;
import com.dc.service.UserService;
import com.dc.utill.Constants.ResponseStatus;


@RestController
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CompanyService companyService;

	
	private  static final Logger Logger = LoggerFactory.getLogger(UserResource.class); 
	
//	Use  for Recruiter  registration 	
	@RequestMapping(value = "/registerRec", method = RequestMethod.POST)
	public  ResponseEntity<BaseResponse>  registerRec(@RequestBody  RecruiterProfileForm  recruiter) {
		
		BaseResponse response = new BaseResponse();
		if (null != recruiter) {
			//Logger.info("received : " + userId );
			try {
				
					//check record is present or not 
				   //boolean flag = userService.findRecruiterProfileAlreadyExistOrNot(recruiter);
				   if(true) {
				   recruiter = userService.saveRecruiterProfile(recruiter);
				   response.setObj(recruiter);
				   response.setStatus(ResponseStatus.SUCESS);
				   response.setCode(ResponseStatus.SUCESS_CODE);
				   }
			} catch (DataAccessLayerException  | ApplicationException  ex) {
				Logger.error(ex.getCause().toString());
				response.setStatus(ResponseStatus.REGISTERED_ALREADY);
				response.setCode(ResponseStatus.REGISTERED_ALREADY_CODE);
			}
		} else {
			response.setStatus(ResponseStatus.INVALID_INPUT_CODE);
			response.setCode(ResponseStatus.INVALID_INPUT);
		}
		return new ResponseEntity<BaseResponse>(response,HttpStatus.CREATED);
	}
	
	
//Use  for driver  registration 	
	@RequestMapping(value = "/registerDrv", method = RequestMethod.POST)
	public  ResponseEntity<BaseResponse>  registerDrv(@RequestBody  UserProfileForm user) {
		
		BaseResponse response = new BaseResponse();
		if (null != user) {
			//Logger.info("received : " + userId );
			try {
				 
				   user = userService.saveUser(user);
				   response.setStatus(ResponseStatus.SUCESS);
				   response.setCode(ResponseStatus.SUCESS_CODE);
				   response.setObj(user);
				   
			} catch (DataAccessLayerException e) {
				Logger.error(e.getCause().toString());
				response.setStatus(ResponseStatus.REGISTERATION_ALREADY);
				response.setCode(ResponseStatus.REGISTERED_ALREADY_CODE);
			}
			
		} else {
			response.setStatus(ResponseStatus.INVALID_INPUT_CODE);
			response.setCode(ResponseStatus.INVALID_INPUT);
		}
		return new ResponseEntity<BaseResponse>(response,HttpStatus.CREATED);
	}
	
	
	
	
	
	//Use  for Recruiter update  	
		@RequestMapping(value = "/updateRecProfile", method = RequestMethod.POST)
		public  ResponseEntity<BaseResponse> updateRecprofile(@RequestBody  RecruiterProfileForm recruiterProfile) {
			
			BaseResponse response = new BaseResponse();
			if (null != recruiterProfile) {
				//Logger.info("received : " + userId );
				try {
					   recruiterProfile = userService.updateRecruiterProfile(recruiterProfile);
					   response.setStatus(ResponseStatus.SUCESS);
					   response.setCode(ResponseStatus.SUCESS_CODE);
					   response.setObj(recruiterProfile);
					   
				} catch (DataAccessLayerException e) {
					Logger.error(e.getCause().toString());
					response.setStatus(ResponseStatus.EXCEPTION_CODE);
					response.setCode(ResponseStatus.EXCEPTION_OCCURED);
				}
				
			} else {
				response.setStatus(ResponseStatus.INVALID_INPUT_CODE);
				response.setCode(ResponseStatus.INVALID_INPUT);
			}
			return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
		}
	
	
   //Use  for driver  registration 	
				@RequestMapping(value = "/updateDrvprofile", method = RequestMethod.POST)
				public  ResponseEntity<BaseResponse>  updateDrvprofile(@RequestBody UserProfileForm user) {
					
					BaseResponse response = new BaseResponse();
					if (null != user) {
						Logger.info("received data in updateDrvprofile: " + user );
						try {
							   user = userService.updateUser(user);
							   response.setStatus(ResponseStatus.SUCESS);
							   response.setCode(ResponseStatus.SUCESS_CODE);
							   response.setObj(user);
							   
						} catch (DataAccessLayerException e) {
							Logger.error(e.getCause().toString());
							response.setStatus(ResponseStatus.EXCEPTION_CODE);
							response.setCode(ResponseStatus.EXCEPTION_OCCURED);
						}
						
					} else {
						response.setStatus(ResponseStatus.INVALID_INPUT_CODE);
						response.setCode(ResponseStatus.INVALID_INPUT);
					}
					return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
				}
				
				
				
				 //List all thhe active driver 
				@RequestMapping(value = "/listActiveDrvprofiles", method = RequestMethod.POST)
				public  ResponseEntity<List<UserProfileForm>>  getAllActiveDrvprofile(@RequestBody UserProfileForm user ,
						@RequestParam (value="offset")  int offset) {
					
					BaseResponse response = new BaseResponse();
					List<UserProfileForm> drvList =  null;
					if (null != user) {
						Logger.info("received data in listActiveDrvprofiles: " + user );
						try {
							   offset = offset*10;
							   drvList = userService.findAllusers(offset);
							   response.setStatus(ResponseStatus.SUCESS);
							   response.setCode(ResponseStatus.SUCESS_CODE);
							  // response.setObj(user);
							   
						} catch (DataAccessLayerException e) {
							Logger.error(e.getCause().toString());
							response.setStatus(ResponseStatus.EXCEPTION_CODE);
							response.setCode(ResponseStatus.EXCEPTION_OCCURED);
						}
						
					} else {
						response.setStatus(ResponseStatus.INVALID_INPUT_CODE);
						response.setCode(ResponseStatus.INVALID_INPUT);
					}
					return new ResponseEntity<List<UserProfileForm>>(drvList,HttpStatus.OK);
				}	
				
			
				
				 //List all the active driver Applied for a job 
				@RequestMapping(value = "/listApplicants", method = RequestMethod.POST)
				public  ResponseEntity<List<UserProfileForm>>  getAllApplicants( @RequestParam(value = "job_Id") String job_id ,@RequestParam (value="offset")  int offset) {
					
					BaseResponse response = new BaseResponse();
					List<UserProfileForm> drvList =  null;
					if (null != job_id) {
						Logger.info(" listApplicants call  received job_id: " + job_id );
						try {
							   offset = offset*10;
							   drvList = userService.findApplicantForJob(job_id ,offset);
							   response.setStatus(ResponseStatus.SUCESS);
							   response.setCode(ResponseStatus.SUCESS_CODE);
							   
						} catch (DataAccessLayerException e) {
							Logger.error(e.getCause().toString());
							response.setStatus(ResponseStatus.EXCEPTION_CODE);
							response.setCode(ResponseStatus.EXCEPTION_OCCURED);
						}
						
					} else {
						response.setStatus(ResponseStatus.INVALID_INPUT_CODE);
						response.setCode(ResponseStatus.INVALID_INPUT);
					}
					return new ResponseEntity<List<UserProfileForm>>(drvList,HttpStatus.OK);
					
				}
	
}
