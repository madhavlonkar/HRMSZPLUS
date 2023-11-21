package com.HRMS.service;

import java.util.List;

import com.HRMS.model.EmpDeductionMaster;

public interface EmpDeductionService {
	EmpDeductionMaster findById(long id);



	List<EmpDeductionMaster> getEmployeeDeductionsById(long id);


	void deleteEmpDeduction(Long id);
	
	EmpDeductionMaster saveEmployee(EmpDeductionMaster empDeduction);

}
