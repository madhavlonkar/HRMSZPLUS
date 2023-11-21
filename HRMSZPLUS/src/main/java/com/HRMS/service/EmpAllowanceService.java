package com.HRMS.service;

import java.util.List;

import com.HRMS.model.EmpAllowanceMaster;
import com.HRMS.model.EmployeeMaster;

public interface EmpAllowanceService {

	EmpAllowanceMaster findById(long id);



	List<EmpAllowanceMaster> getEmployeeAllowancesById(long id);


	void deleteEmpAllowance(Long id);
	
	EmpAllowanceMaster saveEmployee(EmpAllowanceMaster empallowance);



	EmpAllowanceMaster getAllowanceById(long id);

}
