package com.dc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dc.bean.OTPForm;
import com.dc.dao.OtpDao;
import com.dc.exception.DataAccessLayerException;
import com.dc.service.OtpService;
import com.dc.utill.CommonUtill;
import com.dc.utill.SqlConstants;

@Repository
public class OtpDaoImpl implements OtpDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("hibernateSessionFactory")
	private SessionFactory sessionFactory;
	
	
	
	private  static final Logger Logger = LoggerFactory.getLogger(OtpDaoImpl.class); 
	
	@Override
	public OTPForm saveOTPdetails(final OTPForm otp) throws DataAccessLayerException {
		
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
						ps.setDate(7,new Date(System.currentTimeMillis()));
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
	public OTPForm getOtp(String mobile) throws DataAccessLayerException {
		OTPForm otpDetails = null;
		final String query =" SELECT * FROM `dc_otp` WHERE `MOB_NO`=?  order by CRTD_TMSTMP desc Limit 1 ";	
		try {
			 otpDetails = jdbcTemplate.queryForObject(query.toString(), new Object[]{mobile}, new RowMapper<OTPForm>(){
				@Override
				public OTPForm mapRow(ResultSet rs, int rowNum) throws SQLException {
					OTPForm otp = new OTPForm();
					otp.setId(rs.getInt("ID"));
					otp.setPin(String.valueOf(rs.getInt("OTP")));
					otp.setExpDate(null);
					return otp;
				}});			
		} catch (Exception excp) {						
			throw new DataAccessLayerException("Error fetching OTP details",excp);
		}
		return otpDetails;
	}

}
