package com.HRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HRMS.model.EmployeeMaster;
import com.HRMS.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/employees")
	public List<EmployeeMaster> getAll()
	{
		List<EmployeeMaster> allEmployees = employeeservice.getAllEmployees();
		if(employeeservice!=null)
		{
			return allEmployees;
		}
		else
		{
			return null;
		}
	}
	
	@PostMapping("/addemp")
	public EmployeeMaster addemp(@RequestBody EmployeeMaster emp)
	{
		EmployeeMaster addEmployee = employeeservice.addEmployee(emp);
		if(addEmployee!=null)
		{
			return addEmployee;
		}
		else
		{
			return null;
		}
		
	}

}
