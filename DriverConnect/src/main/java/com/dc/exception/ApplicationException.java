package com.dc.exception;

public class ApplicationException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
	
	

}
