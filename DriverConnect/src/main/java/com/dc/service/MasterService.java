package com.dc.service;

import java.util.List;

import com.dc.bean.CityForm;
import com.dc.exception.DataAccessLayerException;

public interface MasterService {
	
	public List<CityForm> getCityList() throws DataAccessLayerException ;

}
