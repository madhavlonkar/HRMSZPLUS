package com.HRMS.dao;

import org.springframework.data.repository.CrudRepository;

import com.HRMS.model.EmployeeMaster;
import java.util.List;


public interface EmployeeDAO extends CrudRepository<EmployeeMaster, Integer>{

}
