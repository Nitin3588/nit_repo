package com.dc.utill;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.dc.bean.OTPForm;

public class Test {
	
	public static void main12(String args[]) {
		OTPForm otp =  new OTPForm();
		System.out.println("");
		
	} 
	

	public static void main(String args[])throws IOException{

		try {
			
			
			 String path = "E:\\mytemp\\IMG_20171216_100505_Bokeh.jpg";
			 
	    	 InputStream in = new FileInputStream(path);
	    	 System.out.println(in.getClass());
			
	    	 
	    	 
	    	 generateJObAckId();
			//Sender.sendSMS();
			/*String recipient = "+9196850880114";
			String message = " Greetings from Mr. Gupta! Have a nice day!";
			String username = "algomatix";
			String password = "222222";
			String originator = "+917276991084";
			

http:www.smsjust.com/blank/sms/user/urlsmstemp.php?username=algomatix&pass=222222&senderid=ALGVTS&dest_mobileno=#MobNo#&tempid=60085&F1=#F1#&F2=#F2#&F3=#F3#&F4=#F4#&F5=#F5#&response=Y 
	
			
			String requestUrl  = "http://www.smsjust.com/blank/sms/user/urlsmstemp.php?username=algomatix&pass=222222&senderid=ALGVTS&dest_mobileno=9892683023&tempid=60085&F1=Dear User&F2=your &F3=onetime  &F4=password &F5=is 456203 &response=Y";
			
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();

			System.out.println(uc.getResponseMessage());
			System.out.println(uc.getResponseCode());
			uc.disconnect();*/
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}



	}
	
	//first letter J=job   next 10 digit = ddMMYYHHss  after that recruiterID  
	public static  String generateJObAckId(){
		String jid =  "J" ;
		String rId =  "123" ;
	 	java.util.Date date = new java.util.Date();
		SimpleDateFormat ft = new SimpleDateFormat("ddMMyyhhss");
        String datetime = ft.format(date);
	    jid = jid.concat(datetime.concat(rId));
	    System.out.println("You JOB ID is "+jid); 
	    return new String(jid); 
		}
	
}
