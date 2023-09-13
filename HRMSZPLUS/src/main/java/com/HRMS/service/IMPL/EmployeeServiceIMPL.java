package com.HRMS.service.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.EmployeeDAO;
import com.HRMS.model.EmployeeMaster;
import com.HRMS.service.EmployeeService;

@Service
public class EmployeeServiceIMPL implements EmployeeService{

	@Autowired
	private EmployeeDAO employeedao;
	
	@Override
	public List<EmployeeMaster> getAllEmployees() {
		try {
			List<EmployeeMaster> findAll = (List<EmployeeMaster>) employeedao.findAll();
			return findAll;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeMaster addEmployee(EmployeeMaster employee) {
		
		try {
			EmployeeMaster save = employeedao.save(employee);
			return save;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
