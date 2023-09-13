package com.HRMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class EmployeeMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	private String empName;
	private String empAddress;
	private String empState;
	private String empEmail;
	private String empMobileNo;
	private String empGender;
	private String empPan;
	private String empDOB;
	private String empDOJ;
	
	@OneToOne
    @JoinColumn(name="departmentId")
	private DepartmentMaster empDepartment;
	
	@ManyToOne
	private DesignationMaster empDesignation;
	
	@ManyToOne
	private BankMaster empBank;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpPan() {
		return empPan;
	}

	public void setEmpPan(String empPan) {
		this.empPan = empPan;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	public String getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(String empDOJ) {
		this.empDOJ = empDOJ;
	}

	public DepartmentMaster getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(DepartmentMaster empDepartment) {
		this.empDepartment = empDepartment;
	}

	public DesignationMaster getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(DesignationMaster empDesignation) {
		this.empDesignation = empDesignation;
	}

	public BankMaster getEmpBank() {
		return empBank;
	}

	public void setEmpBank(BankMaster empBank) {
		this.empBank = empBank;
	}

	public EmployeeMaster(int empId, String empName, String empAddress, String empState, String empEmail,
			String empMobileNo, String empGender, String empPan, String empDOB, String empDOJ,
			DepartmentMaster empDepartment, DesignationMaster empDesignation, BankMaster empBank) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empState = empState;
		this.empEmail = empEmail;
		this.empMobileNo = empMobileNo;
		this.empGender = empGender;
		this.empPan = empPan;
		this.empDOB = empDOB;
		this.empDOJ = empDOJ;
		this.empDepartment = empDepartment;
		this.empDesignation = empDesignation;
		this.empBank = empBank;
	}

	public EmployeeMaster() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeMaster [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empState="
				+ empState + ", empEmail=" + empEmail + ", empMobileNo=" + empMobileNo + ", empGender=" + empGender
				+ ", empPan=" + empPan + ", empDOB=" + empDOB + ", empDOJ=" + empDOJ + ", empDepartment="
				+ empDepartment + ", empDesignation=" + empDesignation + ", empBank=" + empBank + "]";
	}
	
	
	
	
}
