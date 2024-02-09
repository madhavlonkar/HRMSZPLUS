package com.HRMS.model;

import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Table(name = "tbl_candidate")
public class CandidateMaster {

	public CandidateMaster(int i, String currentDateAsString, String candidateFirstName2, String candidateLastName2,
			String string, String string2, String candidateEmail2, String candidateMobileNo2, JobTitleMaster jobId2,
			String originalFilename, String contentType, byte[] compressData) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long candidateId;

	private int demandId;

	private Date appliedDate;

	private String candidateFirstName;
	private String candidateLastName;
	private String candidateAddress;
	private String candidateGender;
	private String candidateEmail;
	private String candidateMobileNo;
	
	private Date candidateDOB;
	private String candidateState;
	private String candidatePan;

	private String candidateHighestEducation;
	private String candidateCollegeUniversityName;
	private String candidateAreaOfStudy;
	private Date candidateDateOfGraduation;

	private String candidateReference;

	private String Status;
		
	@ManyToOne
	@JoinColumn(name= "jobId")
	private JobTitleMaster jobId;
	

	 @Lob
	    @Column(name = "resume", length = 1000000) 
	    private byte[] resume;
	 
	 private String fileName;

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public int getDemandId() {
		return demandId;
	}

	public void setDemandId(int demandId) {
		this.demandId = demandId;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getCandidateFirstName() {
		return candidateFirstName;
	}

	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}

	public String getCandidateLastName() {
		return candidateLastName;
	}

	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}

	public String getCandidateAddress() {
		return candidateAddress;
	}

	public void setCandidateAddress(String candidateAddress) {
		this.candidateAddress = candidateAddress;
	}

	public String getCandidateGender() {
		return candidateGender;
	}

	public void setCandidateGender(String candidateGender) {
		this.candidateGender = candidateGender;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public String getCandidateMobileNo() {
		return candidateMobileNo;
	}

	public void setCandidateMobileNo(String candidateMobileNo) {
		this.candidateMobileNo = candidateMobileNo;
	}

	public Date getCandidateDOB() {
		return candidateDOB;
	}

	public void setCandidateDOB(Date candidateDOB) {
		this.candidateDOB = candidateDOB;
	}

	public String getCandidateState() {
		return candidateState;
	}

	public void setCandidateState(String candidateState) {
		this.candidateState = candidateState;
	}

	public String getCandidatePan() {
		return candidatePan;
	}

	public void setCandidatePan(String candidatePan) {
		this.candidatePan = candidatePan;
	}

	public String getCandidateHighestEducation() {
		return candidateHighestEducation;
	}

	public void setCandidateHighestEducation(String candidateHighestEducation) {
		this.candidateHighestEducation = candidateHighestEducation;
	}

	public String getCandidateCollegeUniversityName() {
		return candidateCollegeUniversityName;
	}

	public void setCandidateCollegeUniversityName(String candidateCollegeUniversityName) {
		this.candidateCollegeUniversityName = candidateCollegeUniversityName;
	}

	public String getCandidateAreaOfStudy() {
		return candidateAreaOfStudy;
	}

	public void setCandidateAreaOfStudy(String candidateAreaOfStudy) {
		this.candidateAreaOfStudy = candidateAreaOfStudy;
	}

	public Date getCandidateDateOfGraduation() {
		return candidateDateOfGraduation;
	}

	public void setCandidateDateOfGraduation(Date candidateDateOfGraduation) {
		this.candidateDateOfGraduation = candidateDateOfGraduation;
	}

	public String getCandidateReference() {
		return candidateReference;
	}

	public void setCandidateReference(String candidateReference) {
		this.candidateReference = candidateReference;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public JobTitleMaster getJobId() {
		return jobId;
	}

	public void setJobId(JobTitleMaster jobId) {
		this.jobId = jobId;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CandidateMaster() {
		super();
	}

	@Override
	public String toString() {
		return "CandidateMaster [candidateId=" + candidateId + ", demandId=" + demandId + ", appliedDate=" + appliedDate
				+ ", candidateFirstName=" + candidateFirstName + ", candidateLastName=" + candidateLastName
				+ ", candidateAddress=" + candidateAddress + ", candidateGender=" + candidateGender
				+ ", candidateEmail=" + candidateEmail + ", candidateMobileNo=" + candidateMobileNo + ", candidateDOB="
				+ candidateDOB + ", candidateState=" + candidateState + ", candidatePan=" + candidatePan
				+ ", candidateHighestEducation=" + candidateHighestEducation + ", candidateCollegeUniversityName="
				+ candidateCollegeUniversityName + ", candidateAreaOfStudy=" + candidateAreaOfStudy
				+ ", candidateDateOfGraduation=" + candidateDateOfGraduation + ", candidateReference="
				+ candidateReference + ", Status=" + Status + ", jobId=" + jobId + ", resume=" + Arrays.toString(resume)
				+ ", fileName=" + fileName + "]";
	}

	

	


}
