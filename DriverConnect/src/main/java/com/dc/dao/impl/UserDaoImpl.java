package com.dc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dc.bean.JobPostingForm;
import com.dc.bean.OTP;
import com.dc.bean.RecruiterProfile;
import com.dc.bean.User;
import com.dc.dao.UserDao;
import com.dc.exception.DataAccessLayerException;
import com.dc.utill.Constants;
import com.dc.utill.SqlConstants;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private  static final Logger Logger = LoggerFactory.getLogger(UserDaoImpl.class); 
	
	@Override
	public User saveUser(User user) throws DataAccessLayerException {
		
		KeyHolder key = new GeneratedKeyHolder(); 
	     final String query = SqlConstants.insert_rec_deatils;
			try {
				jdbcTemplate.update(new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection connection)throws SQLException{					
						PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, user.getFullName());
						ps.setString(2, user.getPassword());
						ps.setString(3, user.getFirstName());
						ps.setString(4, user.getLastName());
						ps.setString(5,user.getEmail());
						ps.setString(6,user.getMobileNo());
						ps.setObject(7,user.getCreatedBy());
					    ps.setObject(8,user.getId());
						ps.setBoolean(9,user.isStatus());
						ps.setString(10,user.getOtp());
						return ps;
					}
				},key);
				user.setId(key.getKey().intValue());
				return user;
			} catch(Exception e) {
				Logger.error(e.getMessage());
				throw new DataAccessLayerException("Error while Inserting User", e);
			}	
		
		
		
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

	@Override
	public User findUserByMobile(String mobile) throws DataAccessLayerException {

		User userDetails = null;
		final String query =" SELECT * FROM `rd_usr` WHERE `MOB_NO`=? ";	
		try {
			userDetails = jdbcTemplate.queryForObject(query.toString(), new Object[]{mobile}, new RowMapper<User>(){
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



	
	
/************
 * 
 * Below method is used to save basic detail of recruiter/User
 * so after registration recruiter can access post a new job option , update a profile,view profile
 * Recruiter id should be generated which is used as a forien key in job posting table 
 * 
 * ************/	
	
	@Override
	public RecruiterProfile saveRecruiterProfile(RecruiterProfile recruiterProfile) throws DataAccessLayerException {
		
		KeyHolder key = new GeneratedKeyHolder(); 
	     final String query = SqlConstants.insert_rec_deatils;
			try {
				jdbcTemplate.update(new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection connection)throws SQLException{					
						PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, recruiterProfile.getFullName());
						ps.setString(2,"A");
						ps.setString(3, Constants.UPLOAD_LOCATION);
						ps.setString(4, recruiterProfile.getCompanyName());
						ps.setString(5,recruiterProfile.getCompanyLocation());
						ps.setString(6,recruiterProfile.getMobileNumber());
						ps.setString(7,recruiterProfile.getCountry());
					    ps.setString(8,recruiterProfile.getFlagHire());
						ps.setString(9,recruiterProfile.getCreatedBy());
						ps.setDate(10,null );
						ps.setString(11,null);
						ps.setString(12,null);
						return ps;
					}
				},key);
				recruiterProfile.setId(key.getKey().intValue());
				return recruiterProfile;
			} catch(Exception e) {
				Logger.error(e.getMessage());
				throw new DataAccessLayerException("Error while Inserting User", e);
			}	
	}

	
	public JobPostingForm saveJobPostingDetails(JobPostingForm jobPostingForm) throws DataAccessLayerException{
		
		 KeyHolder key = new GeneratedKeyHolder(); 
	     final String query = SqlConstants.insert_job_deatils;
			try {
				jdbcTemplate.update(new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection connection)throws SQLException{					
						PreparedStatement ps = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);


					/*	JOB_ID,CATEGORY_ID,COMPANY_NAME,TITLE,DESCRIPTION,"
								+ "LOCATION,EXP_REQUIRED,MIN_EXP,MAX_EXP,"
								+ "CITY_ID,RECRUITER_ID,CREATED_DATE,"
								+ "UPDATED_BY,CREATED_BY,LST_UPD_TS,STATUS,PUBLISH,ISNEW,APPROVE_BY_ADMIN,REJECT_COMMENT_BY_ADMIN				
	*/					
						/*ps.setString(1, Integer.valueOf(jobPostingForm.getId()));
						ps.setString(2, Integer.valueOf(jobPostingForm.getId()));
						ps.setString(3, jobPostingForm.getCompanyName());
						ps.setString(4, jobPostingForm.getImp());
						ps.setString(5, jobPostingForm.getMinWorkexp());
						ps.setString(6, jobPostingForm.getMaxWorkexp());
						ps.setString(7, jobPostingForm.getWorkLocation());
						ps.setString(8, x);
						ps.setString(9, x);
						ps.setString(10, x);
						ps.setString(11, x);
						ps.setString(12, x);
						ps.setString(13, x);*/
						return ps;
					}
				},key);
				jobPostingForm.setId(key.getKey().intValue());
				return jobPostingForm;
			}catch(Exception e) {
				Logger.error(e.getMessage());
				throw new DataAccessLayerException("Error while Inserting User", e);
			}
	}
}
	
