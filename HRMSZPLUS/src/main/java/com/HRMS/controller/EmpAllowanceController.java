package com.HRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HRMS.model.AllowanceMaster;
import com.HRMS.model.EmpAllowanceMaster;
import com.HRMS.model.EmployeeMaster;
import com.HRMS.service.AllowanceService;
import com.HRMS.service.EmpAllowanceService;
import com.HRMS.service.EmployeeService;

@Controller
public class EmpAllowanceController {
	
	@Autowired
	private AllowanceService allowanceservice;

	@Autowired
	private EmpAllowanceService empAllowanceService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getEmpAllowance")
	public String showEmployeeIdForm() {
		return "EmpAllowance/EmpAllowanceID";

	}

	@GetMapping("/getEmpAllowances/{id}")
	public String getEmployeeAllowances(@PathVariable("id") long id, Model model,
			RedirectAttributes redirectAttributes) {

		EmployeeMaster employee = employeeService.findById(id);

		if (employee != null) {
			// If the employee exists, retrieve their allowances
			List<EmpAllowanceMaster> employeeAllowances = empAllowanceService.getEmployeeAllowancesById(id);

			model.addAttribute("employee", employee);
			model.addAttribute("employeeAllowances", employeeAllowances);

			return "EmpAllowance/EmpAllowanceMaintenance";// Assuming "employeeAllowances" is your HTML template
																// for displaying allowances.
		} else {
			// Handle the case when the employee does not exist
			model.addAttribute("errorMessage", "Employee not found");
			return "EmpAllowance/EmpAllowanceMaintenance"; // You should have an error template for displaying the
																// error message.
		}
	}
	
	@GetMapping("empAllowance/new/{empid}")
	public String createNewForm(@PathVariable("empid") long empid ,Model model)
	{
		EmpAllowanceMaster empallowance =new EmpAllowanceMaster();
		List<AllowanceMaster> allowances = allowanceservice.getAllAllowances();
		EmployeeMaster employee = new EmployeeMaster();
	    employee.setEmpId(empid);
	    
		empallowance.setEmployee(employee);
		model.addAttribute("empallowance", empallowance);
		model.addAttribute("Allallowances", allowances);
		return "/EmpAllowance/EmpAllowancneAdd";
	}
	
	@PostMapping("/empAllowance")
	public String assignAllowance(@ModelAttribute("empallowance") EmpAllowanceMaster empallowance,
	        @RequestParam("empId") long empId) {
	    // Set the employee for the EmpAllowanceMaster object
	    EmployeeMaster employee = employeeService.findById(empId);
	    empallowance.setEmployee(employee);
	    empAllowanceService.saveEmployee(empallowance);
	    

	    // Redirect to the main page that displays all details for the employee
	    return "redirect:/getEmpAllowances/" + empId;
	}
	
	
	@GetMapping("/empAllowance/edit/{id}")
	public String editEmpAllowance(@PathVariable("empid") long empid ,Model model) {
          
		EmpAllowanceMaster empallowance =new EmpAllowanceMaster();
		List<AllowanceMaster> allowances = allowanceservice.getAllAllowances();
		EmployeeMaster employee = new EmployeeMaster();
        employee.setEmpId(empid);
	    
		empallowance.setEmployee(employee);
		model.addAttribute("empallowance", empallowance);
		model.addAttribute("Allallowances", allowances);

		return "/EmpAllowance/EmpAllowanceEdit";
	}



	@GetMapping("/empAllowance/delete/{id}")
	public String deleteAllowance(@PathVariable("id") long id, @RequestParam("empId") long empId) {
	    EmpAllowanceMaster existingAllowance = empAllowanceService.findById(id);
	    try {

	        if (existingAllowance == null) {
	            // Handle the case when allowance with ID not found.
	        } else {
	            empAllowanceService.deleteEmpAllowance(id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // Redirect to the main page that displays all details for the employee (getEmployeeAllowances)
	    return "redirect:/getEmpAllowances/"+empId;
	}

}
