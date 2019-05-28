package com.dc.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Vehicle implements  Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3547406454112934880L;
	
	@Column
	private String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
