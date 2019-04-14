package com.dc.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dc.bean.FileInfo;
import com.dc.bean.RecruiterProfileForm;
import com.dc.bean.UserProfileForm;
import com.dc.dto.RecruiterProfileDTO;
import com.dc.dto.UserProfileDTO;
import com.dc.service.UserService;
import com.dc.utill.CommonUtill;
import com.dc.utill.Constants;
import com.twilio.rest.chat.v1.service.User;

@RestController
@RequestMapping("/fileUploadResource")
public class FileUploadResource {

	
	@Autowired
	UserService userService;
	
	private  static final Logger Logger = LoggerFactory.getLogger(FileUploadResource.class); 
	
	@RequestMapping(value = "/uploadFile", headers=("content-type=multipart/*"),method = RequestMethod.POST)
	public  ResponseEntity<FileInfo>  upload(@RequestParam("file") MultipartFile inputFile,@RequestParam(value = "userId") String userId) {
		FileInfo response = new FileInfo();
		HttpHeaders header = new HttpHeaders();
		
		if(!inputFile.isEmpty() && userId != null) {
			try {
				String originalFileName  = inputFile.getOriginalFilename();
				File file = new File(Constants.UPLOAD_LOCATION+File.separator+originalFileName);
				inputFile.transferTo(file);
				if(inputFile.getSize() > 0 && inputFile.getSize() < Constants.MAX_UPLOAD_SIZE) {
					UserProfileForm user = new UserProfileForm();
					UserProfileDTO  userDetails =  userService.findUserById(CommonUtill.convertTOBigInteger(userId));
					userDetails.setPhotoName(originalFileName);
					userDetails.setPhotoPath(file.getAbsolutePath());
					BeanUtils.copyProperties(userDetails, user);
					userService.updateUser(user);
					response.setPhotoName(originalFileName);
					response.setPhotoPath(file.getAbsolutePath());
			}else {
				response.setPhotoName("Photo size is larger than 1 MB");
				response.setPhotoPath("Issue with photo size");
			}
			}catch(Exception e) {
				Logger.error("fail to upload file due to {}",e.getCause());
				response.setPhotoPath("fail to upload at this time");
			}
		}
		return new ResponseEntity<FileInfo>(response,header,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/uploadFileByRec", headers=("content-type=multipart/*"),method = RequestMethod.POST)
	public  ResponseEntity<FileInfo>  uploadFileByRec(@RequestParam("file") MultipartFile inputFile,@RequestParam(value = "userId") String userId) {
		FileInfo response = new FileInfo();
		HttpHeaders header = new HttpHeaders();
		
		if(!inputFile.isEmpty() && userId != null) {
			try {
				String originalFileName  = inputFile.getOriginalFilename();
				File file = new File(Constants.UPLOAD_LOCATION+File.separator+originalFileName);
				inputFile.transferTo(file);
				if(inputFile.getSize() > 0 && inputFile.getSize() < Constants.MAX_UPLOAD_SIZE) {
					RecruiterProfileForm user = new RecruiterProfileForm();
					RecruiterProfileDTO  recruiter =  userService.findRecruiterById(CommonUtill.convertTOBigInteger(userId));
					recruiter.setPhotoName(originalFileName);
					recruiter.setPhotoPath(file.getAbsolutePath());
					BeanUtils.copyProperties(recruiter, user);
					userService.updateRecruiterProfile(user);
					response.setPhotoName(originalFileName);
					response.setPhotoPath(file.getAbsolutePath());
			}else {
				response.setPhotoName("Photo size is larger than 1 MB");
				response.setPhotoPath("Issue with photo size");
			}
			}catch(Exception e) {
				Logger.error("fail to upload file due to {}",e.getCause());
				response.setPhotoPath("fail to upload at this time");
			}
		}
		return new ResponseEntity<FileInfo>(response,header,HttpStatus.OK);
	}
	
	
	 @RequestMapping(value = "/downloadFile/{file_Name:.+}", method = RequestMethod.GET) 
	 public ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable("file_Name") String fileName)  {
	     HttpHeaders headers = new HttpHeaders();
	 
	     ResponseEntity<byte[]> responseEntity = null;
	     	
	     try {
	    	 File file = new File(Constants.UPLOAD_LOCATION + fileName);
	    	 Logger.info("file path for download {}",file.getAbsolutePath()); 
	    	 if(file.exists()) {
	    		 Logger.info("file exist for download "); 
		     InputStream in = new FileInputStream(file);
		     byte[] media = IOUtils.toByteArray(in);
		     headers.setContentLength(media.length);
		     headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		      responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
	    	 }
		    
	     	} catch (Exception   ex) {
	     		
	     	Logger.error("fail to download file due to {}",ex.getCause());
	     }
	     return responseEntity;
	 }
	
}
