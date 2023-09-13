package com.HRMS.dao;

import org.springframework.data.repository.CrudRepository;

import com.HRMS.model.EmployeeMaster;

public interface EmployeeDAO extends CrudRepository<EmployeeMaster, Integer>{

}
