package com.dc.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dc.bean.BaseResponse;
import com.dc.bean.CityForm;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.MasterService;
import com.dc.utill.Constants.ResponseStatus;

@RestController
public class MasterResource {

	
	@Autowired
	MasterService masterService;
	
	private  static final Logger Logger = LoggerFactory.getLogger(MasterResource.class); 
	
	@RequestMapping(value = "/listCities", method = RequestMethod.POST)
	public  ResponseEntity<BaseResponse>  getAllApplicants() {
		
		BaseResponse response = new BaseResponse();
		List<CityForm> cityList =  null;
			Logger.info(" listCities call  received job_id: " );
			try {
				cityList = masterService.getCityList();
				   response.setStatus(ResponseStatus.SUCESS);
				   response.setCode(ResponseStatus.SUCESS_CODE);
				   response.setObj(cityList);
				   
			} catch (DataAccessLayerException e) {
				Logger.error(e.getCause().toString());
				response.setStatus(ResponseStatus.EXCEPTION_CODE);
				response.setCode(ResponseStatus.EXCEPTION_OCCURED);
			}
		return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
		
	}
	
}
