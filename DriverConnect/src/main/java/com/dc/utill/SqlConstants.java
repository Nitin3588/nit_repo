package com.dc.utill;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SqlConstants {
	

public	static DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

public	static DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
public static final String insert_sub_user= "INSERT INTO `rd_sub_usr`(`USR_NM`,USR_PWD,`F_NM`,`EML`,`MOB_NO`,`CREATED_DATE`,`CREATED_BY`,`ACTIVE`,`CITY_ID`,`PASS_RESET`,`AUTH_PASS_FLAG`,`OTP`, `OTP_CREATED_DATE`) VALUES (?,md5(?),?,?,?,?,?,?,?,NOW(),?,TRUE,?,?,?,?,NOW())" ; 

public static final String insert_rec_user= "INSERT INTO `recruiter_details`(`USR_NM`,USR_PWD,`F_NM`,`EML`,`MOB_NO`,`CREATED_DATE`,`CREATED_BY`,`ACTIVE`,`CITY_ID`,`PASS_RESET`,`AUTH_PASS_FLAG`,`OTP`, `OTP_CREATED_DATE`) VALUES (?,md5(?),?,?,?,?,?,?,?,NOW(),?,TRUE,?,?,?,?,NOW())" ; 

public static final String insert_rec_deatils = "INSERT INTO  `recruiter_details`(`FULL_NAME`,`PHOTO_NAME`,`PHOTO_PATH`,`COMPANY_NAME`,`COMPANY_LOCATION`,`MOBILE_NUMBER`,`COUNTRY`,`FLAG_HIRE`,`CRTD_BY`,`CRTD_TMSTMP`,`MOD_BY`,`MOD_TMSTMP`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

public static final String  insert_otp_deatils = "INSERT INTO `dc_otp` (`MOB_NO`,`OTP`,`CRTD_BY`,`CRTD_TMSTMP`,`MOD_BY`,`MOD_TMSTMP`,`EXP_TMSTMP`) VALUES (?,?,?,?,?,?,?)";



public static final String  insert_job_deatils = "insert into dc_job (JOB_ID,CATEGORY_ID,COMPANY_NAME,TITLE,DESCRIPTION,"
		+ "LOCATION,EXP_REQUIRED,MIN_EXP,MAX_EXP,"
		+ "CITY_ID,RECRUITER_ID,CREATED_DATE,"
		+ "UPDATED_BY,CREATED_BY,LST_UPD_TS,STATUS,PUBLISH,ISNEW,APPROVE_BY_ADMIN,REJECT_COMMENT_BY_ADMIN) "
		+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


}
