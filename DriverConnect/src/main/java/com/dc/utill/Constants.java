package com.dc.utill;

public final class Constants {
	
	
	
	public final static boolean  SMS_BYPASSED = true;
	public final static String PRIVATE_AUTH_TSID = "ACdfd549cced571333c2c574e9b9e0b14a";
	
	public final static String PRIVATE_AUTH_TOKEN = "90ab996c2f74d0ec738c8aa32701b8a0";
	
	public final static String UPLOAD_LOCATION="E:/mytemp/";

	public final static String PARAMETER_TYPE_STRING = "STRING";
	public final static String PARAMETER_TYPE_NUMBER = "NUMBER";
	
	
	public final static String LOG_METHOD_ENTRY = ">>>";
	public final static String LOG_METHOD_EXIT = "<<<";
	public final static String APP_DATE_FORMAT = "MM/dd/yyyy";
	
	public final static String APPLICATION = "Application";
	
	public final static String URL_PDF = "resources\\jasper\\";
	
	public static final String WEBAPPS="\\webapps";
	
	
	public static  final int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;
	public static  final int OTP_LENGTH = 6;
	
	
	public interface Jasper{
		public final String JRXML_FOLDER = "\\resources\\jasper\\";
		public final String GENERATED_PDFS_FOLDER = "generatedpdfs\\";
		public final String payment_receipt = "payment_receipt.jrxml";
		public final String connection_string = "jdbc:mysql://localhost:3306/db_dc?createDatabaseIfNotExist=true";
		public final String username = "root";
		public final String password = "root";
	}
	

	private Constants() {
	}
	public interface SMSText{
		public final String registrationSMS = "Hi $USER_NAME,Thank you for registering  with DriverConnectApp"
				+ " Your UserId is $USER_ID: ";
	}

	public interface userStatus{
		public final int OPEN = 1;
		public final int REGISTERED = 2;
		public final int CONFIRMATIONPENDING=3;
		public final int CONFIRMED = 4;
	}
	
	public interface userRole{
		public final int ROLE_ADMIN=1;
		public final int ROLE_CUSTOMER = 2;
		
	}
	
	public interface applicationLanguageConstats{
		public final static String EN_US = "en-us";
		public final static String EN = "en";
	}
	
	
	public interface FileUploadFolders{
		public final String  ATTACHMENT = "\\complain_attachment\\";
		public final String INWARD_EMAIL_ATTACHMENT = "\\inward_email_attachment\\";
		public final String EDOCUMENT = "\\Edocument\\";
		public final String IRSTEMP = "\\IRSTemp\\";
		public final String MAIL_DOC = "\\MailDocument\\";
	}
	
	
	public interface paymentGatewayParametersName {
		public final String ACTION = "Action";
		public final String ACCOUNT_ID="AccountID";
		public final String SECRET_KEY="SecretKey";
		public final String REF_NO="RefNo";
		public final String PAYMENT_ID = "PaymentID";
		public final String TRANSACTION_TYPE="transactionType";
		public final String TRANSACTION_TYPE_AUTHORIZED="Authorized";
		public final String TRANSACTION_TYPE_AUTH_FAILED="AuthFailed";
		public final String TRANSACTION_ID = "transactionId";
		public final String AMOUNT="Amount";
		public final String DATE_TIME="dateTime";
		public final String MODE="mode";
		public final String REFERENCE_NO = "referenceNo";
		public final String STATUS="status";
		public final String IS_FLAGGED="isFlagged";
	}
	
	public interface ResponseStatus{
		public final String REGISTERATION_SUCESS = "REGISTERATIONSUCESS";
		public final String REGISTERATION_SUCESS_1 = "REGISTERATIONSUCESS1";
		public final String REGISTERATION_SUCESS_2="REGISTERATIONSUCESS2";
		public final String REGISTERATION_FAILED = "REGISTERATIONFAILED";
		public final String REGISTERATION_FAILED_1 = "REGISTERATIONFAILED1";
		public final String REGISTERATION_FAILED_2="REGISTERATIONFAILED2";
		public final String REGISTERATION_ALREADY="REGISTERATIONALREADY";
	
	
		public final String SUCESS  = "SUCESS" ;
		public final String NOT_FOUND  = "No data found" ;
		public final String INVALID_CREDENTIALS  = "Invalid username or password";
		public final String REGISTERED_ALREADY="User already Registered";
		public final String INVALID_INPUT="Invalid input";
		public final String EXCEPTION_OCCURED="exception ocuured";
		
		public final String SUCESS_CODE  = "111" ; 
		public final String NOT_FOUND_CODE ="112";
		public final String INVALID_INPUT_CODE="113";
		public final String REGISTERED_ALREADY_CODE="114";
		public final String INVALID_CREDENTIALS_CODE ="666";
		public final String EXCEPTION_CODE= "222"	;
	
	}
	
	

	public interface MAIL_TYPE{
		
		public static String FORGOT_PASSWORD = "FORGOT_PASSWORD";
		public static String CHANGE_PASSWORD = "CHANGE_PASSWORD";
		public static String NEW_OTP = "NEW_OTP";
		public static String USER_CREDENTIALS = "USER_CREDENTIALS";
		public static String MODIFY_PROFILE="MODIFY_PROFILE";
		public static String UPDATE_PROFILE="UPDATE_PROFILE";
		
		}
	
	
}
