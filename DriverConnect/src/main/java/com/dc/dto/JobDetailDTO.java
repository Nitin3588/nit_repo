package com.dc.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="dc_job")
public class JobDetailDTO {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private BigInteger id;

	@Column(name="JOB_ID")
	  private String jobId;

	@Column(name="CATEGORY_ID")
	  private int categoryId;

	@Column(name="COMPANY_NAME")
	  private String companyName;

	@Column(name="TITLE")
	  private String jobTitle;

	@Column(name="DESCRIPTION")
	  private String description;

	@Column(name="LOCATION")
	private String workLocation;

	@Column(name="EXP_REQUIRED")
	  private String expReq;

	@Column(name="MIN_EXP")
	  private int minWorkexp;

	@Column(name="MAX_EXP")
	  private int maxWorkexp;

	@Column(name="CITY_ID")
	  private int cityId;

	@Column(name="RECRUITER_ID")
	  private BigInteger recId;

	@Column(name="CREATED_DATE")
	  private Date crtdDate;

	@Column(name="UPDATED_BY")
	  private int updBy;

	@Column(name="CREATED_BY")
	  private int crtBy;

	@Column(name="LST_UPD_TS")
	  private Date lstUpdStatus;

	@Column(name="STATUS")
	  private boolean status;

	@Column(name="PUBLISH")
	  private boolean publish;

	@Column(name="ISNEW")
	  private boolean isNew;

	@Column(name="APPROVE_BY_ADMIN")
	  private boolean appByAdmin;

	@Column(name="REJECT_COMMENT_BY_ADMIN")
	  private String rejComByAdmin;

	@Column(name="CONTACT")
	private String contact;
	
	@Column(name="EML")
	private String email;
	
	
	@Column(name="EMP_TYPE")
	private String employmentType;
	
	@Column(name="VECHICLE_TYPE")
	private String  vechicleType; 
	
	@Column(name="SALARY_ANNUAL")
	private Integer salaryAnnual;
	
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public int getMinWorkexp() {
		return minWorkexp;
	}

	public void setMinWorkexp(int minWorkexp) {
		this.minWorkexp = minWorkexp;
	}

	public int getMaxWorkexp() {
		return maxWorkexp;
	}

	public void setMaxWorkexp(int maxWorkexp) {
		this.maxWorkexp = maxWorkexp;
	}


	public String getExpReq() {
		return expReq;
	}

	public void setExpReq(String expReq) {
		this.expReq = expReq;
	}


	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public BigInteger getRecId() {
		return recId;
	}

	public void setRecId(BigInteger recId) {
		this.recId = recId;
	}

	public Date getCrtdDate() {
		return crtdDate;
	}

	public void setCrtdDate(Date crtdDate) {
		this.crtdDate = crtdDate;
	}

	public int getUpdBy() {
		return updBy;
	}

	public void setUpdBy(int updBy) {
		this.updBy = updBy;
	}

	public int getCrtBy() {
		return crtBy;
	}

	public void setCrtBy(int crtBy) {
		this.crtBy = crtBy;
	}

	public Date getLstUpdStatus() {
		return lstUpdStatus;
	}

	public void setLstUpdStatus(Date lstUpdStatus) {
		this.lstUpdStatus = lstUpdStatus;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean isAppByAdmin() {
		return appByAdmin;
	}

	public void setAppByAdmin(boolean appByAdmin) {
		this.appByAdmin = appByAdmin;
	}

	public String getRejComByAdmin() {
		return rejComByAdmin;
	}

	public void setRejComByAdmin(String rejComByAdmin) {
		this.rejComByAdmin = rejComByAdmin;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getVechicleType() {
		return vechicleType;
	}

	public void setVechicleType(String vechicleType) {
		this.vechicleType = vechicleType;
	}

	public Integer getSalaryAnnual() {
		return salaryAnnual;
	}

	public void setSalaryAnnual(Integer salaryAnnual) {
		this.salaryAnnual = salaryAnnual;
	}

	
}
