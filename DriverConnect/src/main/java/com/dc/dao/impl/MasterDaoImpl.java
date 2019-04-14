package com.dc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dc.bean.CityForm;
import com.dc.dao.MasterDao;
import com.dc.dto.CityDTO;
import com.dc.exception.DataAccessLayerException;

@Repository
public class MasterDaoImpl implements MasterDao{

	@Autowired
	@Qualifier("hibernateSessionFactory")
	private SessionFactory sessionFactory;

	private  static final Logger Logger = LoggerFactory.getLogger(MasterDaoImpl.class); 
	
	@Override
	public List<CityForm> getCityList() throws DataAccessLayerException {
		Logger.info("inside fetch city List");
		List<CityDTO> cityDTOList = null;
		List<CityForm> cityFormList = new ArrayList<CityForm>();
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(CityDTO.class);
		//cr.add(Restrictions.eq("status", true));
		cityDTOList = cr.list();
		
		if(!cityDTOList.isEmpty()) {
		
			for (CityDTO cityDTO : cityDTOList) {
			CityForm cityForm = new CityForm();
			BeanUtils.copyProperties(cityDTO, cityForm);
			cityFormList.add(cityForm);
		}
	}
		return cityFormList;
	}

}
