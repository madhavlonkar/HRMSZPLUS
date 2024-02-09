package com.HRMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_jobTitle")
public class JobTitleMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private String jobTitle;
	private String jobDescription;
	@Override
	public String toString() {
		return "JobTitleMaster [jobId=" + jobId + ", jobName=" + jobTitle + ", jobDescription=" + jobDescription + "]";
	}
	public JobTitleMaster(int jobId, String jobName, String jobDescription) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobName;
		this.jobDescription = jobDescription;
	}
	public JobTitleMaster() {
		super();
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
}
