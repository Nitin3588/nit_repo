package com.dc.bean;

import java.util.Date;

public class JobPostingForm {

	  private int id;
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
	  private int recId;
	  private Date crtdDate;
	  
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
	private int updBy;
	  private int crtBy;
	  private Date lstUpdStatus;
	  private boolean status;
	  private boolean publish;
	  private boolean isNew;
	  private boolean appByAdmin;
	  private String rejComByAdmin;
	  private String Emptype;
	  private String imp;
	  private String hiringFlag;
	  
	  
	  
	  
	  
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
	public String getEmptype() {
		return Emptype;
	}
	public void setEmptype(String emptype) {
		Emptype = emptype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
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
	
	
	
}
