package com.HRMS.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_candidate")
public class CandidateMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long candidateId;

	private int demandId;

	private Date appliedDate;

	private String candidateName;
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
	private int jobId;

	@Column(name = "resume_path")
	private String resumePath;

	@Column(name = "profileImage_path")
	private String profileImageData;
	
	

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



	public String getCandidateName() {
		return candidateName;
	}



	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
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



	public String getResumePath() {
		return resumePath;
	}



	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}



	public String getProfileImageData() {
		return profileImageData;
	}



	public void setProfileImageData(String profileImageData) {
		this.profileImageData = profileImageData;
	}



	public CandidateMaster(long candidateId, int demandId, Date appliedDate, String candidateName,
			String candidateAddress, String candidateGender, String candidateEmail, String candidateMobileNo,
			Date candidateDOB, String candidateState, String candidatePan, String candidateHighestEducation,
			String candidateCollegeUniversityName, String candidateAreaOfStudy, Date candidateDateOfGraduation,
			String candidateReference, String status, String resumePath, String profileImageData) {
		super();
		this.candidateId = candidateId;
		this.demandId = demandId;
		this.appliedDate = appliedDate;
		this.candidateName = candidateName;
		this.candidateAddress = candidateAddress;
		this.candidateGender = candidateGender;
		this.candidateEmail = candidateEmail;
		this.candidateMobileNo = candidateMobileNo;
		this.candidateDOB = candidateDOB;
		this.candidateState = candidateState;
		this.candidatePan = candidatePan;
		this.candidateHighestEducation = candidateHighestEducation;
		this.candidateCollegeUniversityName = candidateCollegeUniversityName;
		this.candidateAreaOfStudy = candidateAreaOfStudy;
		this.candidateDateOfGraduation = candidateDateOfGraduation;
		this.candidateReference = candidateReference;
		Status = status;
		this.resumePath = resumePath;
		this.profileImageData = profileImageData;
	}



	public CandidateMaster() {
		super();
	}



	@Override
	public String toString() {
		return "CandidateMaster [candidateId=" + candidateId + ", demandId=" + demandId + ", appliedDate=" + appliedDate
				+ ", candidateName=" + candidateName + ", candidateAddress=" + candidateAddress + ", candidateGender="
				+ candidateGender + ", candidateEmail=" + candidateEmail + ", candidateMobileNo=" + candidateMobileNo
				+ ", candidateDOB=" + candidateDOB + ", candidateState=" + candidateState + ", candidatePan="
				+ candidatePan + ", candidateHighestEducation=" + candidateHighestEducation
				+ ", candidateCollegeUniversityName=" + candidateCollegeUniversityName + ", candidateAreaOfStudy="
				+ candidateAreaOfStudy + ", candidateDateOfGraduation=" + candidateDateOfGraduation
				+ ", candidateReference=" + candidateReference + ", Status=" + Status + ", resumePath=" + resumePath
				+ ", profileImageData=" + profileImageData + "]";
	}
	
	

}
