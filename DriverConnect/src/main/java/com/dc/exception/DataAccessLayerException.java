package com.dc.exception;

import java.sql.SQLException;

public class DataAccessLayerException extends Exception {


	private static final long serialVersionUID = 18349323234328L;

	
	
	protected int errorCode ;
	protected int errorState;
	
	private String errorMessage;
	
	
	public DataAccessLayerException(String errorMessage, Throwable cause) {

		super(cause);
		if(cause instanceof SQLException) {
			errorCode =((SQLException) cause).getErrorCode(); 
			errorMessage =  ((SQLException) cause).getSQLState(); 
		}
	}
	
	
	public DataAccessLayerException(Throwable cause) {
		super(cause);
	}
	

	public DataAccessLayerException() {
		super();
	}

	public DataAccessLayerException(String message, Throwable cause, boolean arg2, boolean arg3) {
		super(message, cause, arg2, arg3);
	}

	public DataAccessLayerException(String message) {
		super(message);
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public int getErrorState() {
		return errorState;
	}


	public void setErrorState(int errorState) {
		this.errorState = errorState;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
