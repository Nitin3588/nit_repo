package com.dc.bean;

public class JobPostingForm extends AbstractBean{

	private String jobTitle;
	private String Emptype;
	private String description;
	private String imp;
	private String minWorkexp;
	private String maxWorkexp;
	private String workLocation;
	private String hiringFlag;
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmptype() {
		return Emptype;
	}
	public void setEmptype(String emptype) {
		Emptype = emptype;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImp() {
		return imp;
	}
	public void setImp(String imp) {
		this.imp = imp;
	}
	public String getMinWorkexp() {
		return minWorkexp;
	}
	public void setMinWorkexp(String minWorkexp) {
		this.minWorkexp = minWorkexp;
	}
	public String getMaxWorkexp() {
		return maxWorkexp;
	}
	public void setMaxWorkexp(String maxWorkexp) {
		this.maxWorkexp = maxWorkexp;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getHiringFlag() {
		return hiringFlag;
	}
	public void setHiringFlag(String hiringFlag) {
		this.hiringFlag = hiringFlag;
	}
	
	
	
}
