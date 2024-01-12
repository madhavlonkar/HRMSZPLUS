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
	private String jobName;
	private String jobDescription;
	@Override
	public String toString() {
		return "JobTitleMaster [jobId=" + jobId + ", jobName=" + jobName + ", jobDescription=" + jobDescription + "]";
	}
	public JobTitleMaster(int jobId, String jobName, String jobDescription) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDescription = jobDescription;
	}
	public JobTitleMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
}
