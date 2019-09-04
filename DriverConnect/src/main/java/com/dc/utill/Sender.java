package com.dc.utill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sender {

	private  static final Logger Logger = LoggerFactory.getLogger(Sender.class); 

	String username;
	String password;
	String message;
	String type;
	String destination;
	String server;
	String senderid;
	String tempid;


	/*This logic is written for the system generated SMS to customer related activities related to the requirement RO_006 Description - Customer receives regular SMS on the progress of their complaints*/
	public Sender(String server, String username, String password,String message, String type, String destination,String source) {
		System.out.println("Getting data");
		this.server = server;
		this.username = username;
		this.password = password;
		this.message = message;
		this.type = type;
		this.destination = destination;

	}


	public void sendMessage() throws IOException{
		URL sendUrl = new URL("http://"+this.server);
		HttpURLConnection httpConnection = (HttpURLConnection) sendUrl
				.openConnection();
	}

	   public static void sendSMS(String msg4, String destination) throws IOException {

		//Sender 	sendSms =  new Sender(messageConfig.getProperty("server"),Integer.parseInt(messageConfig.getProperty("port")),messageConfig.getProperty("username"),messageConfig.getProperty("password"),otpSms, "0", "0", user.getMobNo(), messageConfig.getProperty("sender"));
		String   server ="www.smsjust.com";
		String   username = "algomatix";
		String   password="222222";
		String   senderid = "ALGVTS";
		String   tempid="60085";
		
		String   msg1="Dear%20User%20your%20one%20Time%20passwo";
		String   msg2="rd%20is";
		String   msg3="%20";
		String   msg5="%20Please%20do%20not%20share.";
		String   url = "";
		String message = "&F1="+msg1+"&F2="+msg2+"&F3="+msg3+"&F4="+msg4+"&F5="+msg5;

		//final String USER_AGENT = "Chrome/41.0.2227.1";
		 // url  = "http://www.smsjust.com/blank/sms/user/urlsmstemp.php?username=algomatix&pass=222222&senderid=ALGVTS&dest_mobileno=9892683023&tempid=60085&F1=Dear User&F2=your &F3=onetime  &F4=password &F5=is 456203 &response=Y";
		
		
		//String message= this.message;
		String encodedURL=java.net.URLEncoder.encode(message,"UTF-8");
		System.out.println(encodedURL);
		
		url = "http://"+server+"/blank/sms/user/urlsmstemp.php?username="+username+"&pass="+password+"&senderid="+senderid+"&dest_mobileno="+destination+"&tempid="+tempid+message+"&response=Y";
		
		//String entireURL = url+encodedURL;
		
		//System.out.println("\n Entire URL :  "+entireURL);
		//URL obj = new URL(url+encodedURL);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		
		
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(	new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		Logger.info(response.toString());
		
		Logger.info(con.getResponseMessage());
	}



	/*public static void  sendSMS(String sContent, String destination){

		String sid =	Constants.PRIVATE_AUTH_TSID; 
		String token =	Constants.PRIVATE_AUTH_TOKEN; 
		Twilio.init(sid, token);
		try {

			Message message = Message.creator( new PhoneNumber("919892683023"), new PhoneNumber("+19727374399"),sContent).create();
			Logger.info("SNMS sent " + message.getStatus());

		} catch (Exception e) {

			e.printStackTrace();
		} 


	}
*/
}	