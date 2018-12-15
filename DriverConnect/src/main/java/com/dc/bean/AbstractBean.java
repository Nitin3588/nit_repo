package com.dc.bean;

import java.util.Date;


public abstract class AbstractBean {

	private Integer id;
	private String name;
	private Date createdDate;
	private String createdBy;
	private Date mdfdDate;
	private String mdfdBy;
	private boolean status;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getMdfdDate() {
		return mdfdDate;
	}
	public void setMdfdDate(Date mdfdDate) {
		this.mdfdDate = mdfdDate;
	}
	public String getMdfdBy() {
		return mdfdBy;
	}
	public void setMdfdBy(String mdfdBy) {
		this.mdfdBy = mdfdBy;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
