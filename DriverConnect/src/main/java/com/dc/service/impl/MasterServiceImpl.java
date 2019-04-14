package com.dc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.bean.CityForm;
import com.dc.dao.MasterDao;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.MasterService;

@Service
@Transactional
public class MasterServiceImpl implements MasterService
{

	@Autowired
	MasterDao masterDao;
	
	private  static final Logger Logger = LoggerFactory.getLogger(MasterServiceImpl.class);
	
	@Override
	public List<CityForm> getCityList() throws DataAccessLayerException {
		Logger.info("inside MasterServiceImpl : getCityList ");
		ArrayList<CityForm> cityList =null;
		return masterDao.getCityList();
	}

}
