package com.dc.bean;

import java.math.BigInteger;
import java.util.Date;

public class JobApplyForm {
	
	private BigInteger sub_id;
	private BigInteger req_id;
	
    private String jobId;
    private String description;
	private int createdBy;
	private Date createdDate;
	private int mdfdBy;
	private Date mdfdDate;


	public BigInteger getId() {
		return sub_id;
	}

	public void setId(BigInteger id) {
		this.sub_id = id;
	}

	public BigInteger getReq_id() {
		return req_id;
	}

	public void setReq_id(BigInteger req_id) {
		this.req_id = req_id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getMdfdBy() {
		return mdfdBy;
	}

	public void setMdfdBy(int mdfdBy) {
		this.mdfdBy = mdfdBy;
	}

	public Date getMdfdDate() {
		return mdfdDate;
	}

	public void setMdfdDate(Date mdfdDate) {
		this.mdfdDate = mdfdDate;
	}

}
