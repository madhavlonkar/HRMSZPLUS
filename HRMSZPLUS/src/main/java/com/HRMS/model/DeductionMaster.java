package com.HRMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_deduction")
public class DeductionMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deductionId;
	
	private String deductionName;
	
	private String deductionnDescription;
     
	
	
	public DeductionMaster() {
		super();
	}



	public DeductionMaster(int deductionId, String deductionName, String deductionnDescription) {
		super();
		this.deductionId = deductionId;
		this.deductionName = deductionName;
		this.deductionnDescription = deductionnDescription;
	}



	public int getDeductionId() {
		return deductionId;
	}



	public void setDeductionId(int deductionId) {
		this.deductionId = deductionId;
	}



	public String getDeductionName() {
		return deductionName;
	}



	public void setDeductionName(String deductionName) {
		this.deductionName = deductionName;
	}



	public String getDeductionnDescription() {
		return deductionnDescription;
	}



	public void setDeductionnDescription(String deductionnDescription) {
		this.deductionnDescription = deductionnDescription;
	}



	@Override
	public String toString() {
		return "DeductionMaster [deductionId=" + deductionId + ", deductionName=" + deductionName
				+ ", deductionnDescription=" + deductionnDescription + "]";
	}
	
	
	

}
