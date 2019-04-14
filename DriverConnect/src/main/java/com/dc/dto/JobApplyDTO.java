package com.dc.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dc_job_request")
public class JobApplyDTO {
	
	@Id
	@Column(name = "REQUEST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger req_id;
	
	
	@Column(name = "SUBSCRIBER_ID")
	private BigInteger id;

	
	@Column(name="JOB_ID_FK")
	  private String jobId;
	
	@Column(name="DESCRIPTION")
	  private String description;
	
	
	@Column(name = "CREATED_BY")
	private int createdBy;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_BY")
	private int mdfdBy;

	@Column(name = "MOD_TMSTMP")
	private Date mdfdDate;


	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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
