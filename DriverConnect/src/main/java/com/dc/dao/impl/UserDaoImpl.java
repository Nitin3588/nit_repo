package com.dc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dc.bean.User;
import com.dc.controller.UserController;
import com.dc.dao.UserDao;
import com.dc.exception.DataAccessLayerException;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private  static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class); 
	
	@Override
	public void saveUser(User user) {
		
	}
	
	@Override
	public void deleteUser(int Id) {
		
	}
	
	@Override
	public void updateUser(User user) {
		
	}

	
	@Override
	public User findUserById(int userId) throws DataAccessLayerException {
		User userDetails = null;
		final String query =" SELECT * FROM `rd_usr` WHERE `ID`=? ";	
		try {
			userDetails = jdbcTemplate.queryForObject(query.toString(), new Object[]{userId}, new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getInt("ID"));
					user.setFirstName(rs.getString("F_NM"));   
					user.setLastName(rs.getString("L_NM"));
				  //user.setPassword(rs.getString("USR_PWD"));
					user.setOtp(rs.getString("OTP"));
					user.setEmail(rs.getString("EML"));
					user.setMobileNo(rs.getString("MOB_NO"));
					user.setStatus(rs.getBoolean("ACTIVE"));
					return user;
				}});			
		} catch (Exception excp) {						
			throw new DataAccessLayerException("Error find user by Id",excp);
		}
		
		return userDetails;
	}

	
	@Override
	public List<User> findAllusers() throws DataAccessLayerException {
		List<User> userList =  new ArrayList<User>();
		return userList;
	}
	
}
	
