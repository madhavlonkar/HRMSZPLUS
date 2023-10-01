package com.HRMS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.HRMS.model.EmpAllowanceMaster;


public interface EmpAllowanceDAO extends CrudRepository<EmpAllowanceMaster, Long> {

	Optional<EmpAllowanceMaster> findById(Integer id);
    
	List<EmpAllowanceMaster> findByEmployeeEmpId(Long employeeId);

//	void deleteById(int id);
}
