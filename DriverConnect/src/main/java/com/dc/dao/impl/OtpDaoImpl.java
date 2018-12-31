package com.dc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dc.bean.OTP;
import com.dc.dao.OtpDao;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.OtpService;
import com.dc.utill.CommonUtill;
import com.dc.utill.SqlConstants;

@Repository
public class OtpDaoImpl implements OtpDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private  static final Logger Logger = LoggerFactory.getLogger(OtpDaoImpl.class); 
	
	@Override
	public OTP saveOTPdetails(OTP otp) throws DataAccessLayerException {
		
		KeyHolder key = new GeneratedKeyHolder(); 
	     final String query = SqlConstants.insert_otp_deatils;
	     // `MOB_NO`,`OTP`,`CRTD_BY`,`CRTD_TMSTMP`,`MOD_BY`,`MOD_TMSTMP`,`EXP_TMSTMP`   //
 			try {
				jdbcTemplate.update(new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection connection)throws SQLException{					
						PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, otp.getMobile());
						ps.setInt(2, Integer.parseInt(otp.getPin()));
						ps.setString(3, otp.getCreatedBy());
						ps.setDate(4, null);	
						ps.setString(5, null);
						ps.setDate(6,null);
						ps.setDate(7, CommonUtill.convertToDbInsertDate(otp.getCreatedDate()));
						return ps;
					}
				},key);
				otp.setId(key.getKey().intValue());
				return otp;
			} catch(Exception e) {
				Logger.error(e.getMessage());
				throw new DataAccessLayerException("Error while Inserting User", e);
			}	
		
	}
	@Override
	public OTP getOtp(String mobile) throws DataAccessLayerException {
		OTP otpDetails = null;
		final String query =" SELECT * FROM `dc_otp` WHERE `MOB_NO`=? ";	
		try {
			 otpDetails = jdbcTemplate.queryForObject(query.toString(), new Object[]{mobile}, new RowMapper<OTP>(){
				@Override
				public OTP mapRow(ResultSet rs, int rowNum) throws SQLException {
					OTP otp = new OTP();
					otp.setId(rs.getInt("ID"));
					otp.setPin(String.valueOf(rs.getInt("OTP")));
					otp.setExpDate(null);
					return otp;
				}});			
		} catch (Exception excp) {						
			throw new DataAccessLayerException("Error find user by Id",excp);
		}
		return otpDetails;
	}

}
