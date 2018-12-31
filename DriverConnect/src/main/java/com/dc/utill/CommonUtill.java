package com.dc.utill;

import java.sql.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonUtill {
	
	private  static final Logger Logger = LoggerFactory.getLogger(CommonUtill.class); 
	
	public static  String generateOTP(){
	Logger.info("Generating OTP using random() : "); 
    String numbers = "0123456789"; 
    Random rndm_method = new Random(); 
    
    int len = Constants.OTP_LENGTH;
    char[] otp = new char[len]; 

    for (int i = 0; i < len; i++) 
    { 
        // Use of charAt() method : to get character value 
        // Use of nextInt() as it is scanning the value as int 
        otp[i] =  numbers.charAt(rndm_method.nextInt(numbers.length())); 
    }
    String s=otp.toString();
    //save it into db
	Logger.info("You OTP is : {}",otp); 
    return new String(otp); 
	}
	
	
	public static Date convertToDbInsertDate(java.util.Date date){
		Date dateDb =  new Date(date.getTime());
		return dateDb ;
		} 	
	
}
	
	
