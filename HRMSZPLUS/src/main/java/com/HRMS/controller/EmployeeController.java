package com.HRMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRMS.model.BankMaster;
import com.HRMS.model.DepartmentMaster;
import com.HRMS.model.DesignationMaster;
import com.HRMS.model.EmployeeMaster;
import com.HRMS.service.BankService;
import com.HRMS.service.DepartmentService;
import com.HRMS.service.DesignationService;
import com.HRMS.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@Autowired
	private DepartmentService departmentservice;
	
	@Autowired
	private DesignationService designationservice;
	
	@Autowired
	private BankService bankservice;
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	
	@GetMapping("/employees")
	public String getAll(Model model)
	{
		List<EmployeeMaster> allEmployees = employeeservice.getAllEmployees();
		if(employeeservice!=null)
		{
			model.addAttribute("employees",allEmployees);
			return "Employee/EmployeeMaintenance";
		}
		else
		{
			log.error("No Data Avilable For Retrival");
			return "Employee/EmployeeMaintenance";
		}
	}
	
	@GetMapping("/employee/new")
	public String createNewForm(Model model)
	{
		List<EmployeeMaster> allEmployees = employeeservice.getAllEmployees();
		List<DepartmentMaster> allDepartments = departmentservice.findAllDepartments();
		List<DesignationMaster> allDesignations = designationservice.findAllDesignations();
		List<BankMaster> allBanks = bankservice.findAllBanks();
		
		model.addAttribute("allEmployees",allEmployees);
		model.addAttribute("allDepartments",allDepartments);
		model.addAttribute("allDesignations",allDesignations);
		model.addAttribute("allbanks",allBanks);
		model.addAttribute("employee",new EmployeeMaster());
		
		return "Employee/newEmployee";
	}
	
	@PostMapping("/employee")
	public String addemp(@ModelAttribute("employee") EmployeeMaster employee)
	{
		EmployeeMaster addEmployee = employeeservice.addEmployee(employee);
		if(addEmployee!=null)
		{
			return "redirect:/employees";
		}
		else
		{
			return "redirect:/employees";
		}
		
	}
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		boolean deleteEmployee = employeeservice.deleteEmployee(id);
		if(deleteEmployee)
		{
			return "redirect:/employees";
		}
		return "redirect:/employees";
	}

}
