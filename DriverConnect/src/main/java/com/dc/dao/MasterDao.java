package com.dc.dao;

import java.util.List;

import com.dc.bean.CityForm;
import com.dc.exception.DataAccessLayerException;

public interface MasterDao {

	public List<CityForm> getCityList() throws DataAccessLayerException ;

}
