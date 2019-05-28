package com.dc.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.dc.dto.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class JobDetailForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	private String jobId;
	private int categoryId;
	private String companyName;
	private String jobTitle;
	private String description;
	private String workLocation;
	private String expReq;
	private int minWorkexp;
	private int maxWorkexp;
	private int cityId;
	private BigInteger recId;
	private Date crtdDate;

	private int updBy;
	private int crtBy;
	private Date lstUpdStatus;
	private boolean status;
	private boolean publish;
	private boolean isNew;
	private boolean appByAdmin;
	private String rejComByAdmin;
	private String imp;
	private String hiringFlag;
	private String designation;

	private String contact;
	private String email;
	private String employmentType;
	private Integer salaryAnnual;
	
	@JsonIgnore
	private List<String> vechicleTypes;
	
	private String companyAddress;
	private Date   expiryDate;
	
	private boolean applyStatus =false;
		
	private String minSalary;
	private String maxSalary;
	
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

	public String getHiringFlag() {
		return hiringFlag;
	}
	public void setHiringFlag(String hiringFlag) {
		this.hiringFlag = hiringFlag;
	}
	public String getImp() {
		return imp;
	}
	public void setImp(String imp) {
		this.imp = imp;
	}
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

	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public Integer getSalaryAnnual() {
		return salaryAnnual;
	}
	public void setSalaryAnnual(Integer salaryAnnual) {
		this.salaryAnnual = salaryAnnual;
	}
	public List<String> getVechicleList() {
		return vechicleTypes;
	}
	public void setVechicleList(List<String> vechicleTypes) {
		this.vechicleTypes = vechicleTypes;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public boolean isApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(boolean applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	
}
