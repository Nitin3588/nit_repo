package com.dc.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dc.bean.BaseResponse;
import com.dc.bean.CompanyProfileForm;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.CompanyService;
import com.dc.utill.Constants.ResponseStatus;

@RestController
@RequestMapping("/mob")
public class CompanyResource {


	@Autowired  
	CompanyService companyService ;

	private  static final Logger Logger = LoggerFactory.getLogger(CompanyResource.class); 

	@RequestMapping(value = "/updateCompanyDetails", method = RequestMethod.POST)
	public @ResponseBody BaseResponse updateCompanyDetails(@RequestBody  CompanyProfileForm company) {

		BaseResponse response = new BaseResponse();

		try {
			Logger.info("in updateCompanyDetails");
			companyService.updateCompanyDetails(company);
			response.setStatus(ResponseStatus.SUCESS);
			response.setCode(ResponseStatus.SUCESS_CODE);

		} catch (DataAccessLayerException e) {
			Logger.error(e.getLocalizedMessage());
			response.setStatus(ResponseStatus.EXCEPTION_OCCURED);
			response.setCode(ResponseStatus.EXCEPTION_CODE);
			return response;
		}

		return response;


	}

}
