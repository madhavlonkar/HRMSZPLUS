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
import com.HRMS.model.DeductionMaster;
import com.HRMS.model.EmpAllowanceMaster;
import com.HRMS.model.EmpDeductionMaster;
import com.HRMS.model.EmployeeMaster;
import com.HRMS.service.DeductionService;
import com.HRMS.service.EmpDeductionService;
import com.HRMS.service.EmployeeService;

@Controller
public class EmpDeductionController {
	
	@Autowired
	private DeductionService deductionservice;
	
	@Autowired
	private EmpDeductionService empDeductionService;
	

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmpDeduction")
	public String showEmployeeIdForm() {
		return  "EmpDeduction/EmpDeductionID";
	}
	
	@GetMapping("/getEmpDeductions/{id}")
	public String getEmployeeDeduction(@PathVariable("id") long id, Model model,
			RedirectAttributes redirectAttributes) {

		EmployeeMaster employee = employeeService.findById(id);

		if (employee != null) {
			// If the employee exists, retrieve their allowances
			List<EmpDeductionMaster> employeeDeductions = empDeductionService.getEmployeeDeductionsById(id);

			model.addAttribute("employee", employee);
			model.addAttribute("employeeDeductions", employeeDeductions);

			return "EmpDeduction/EmpDeductionMaintenance";// Assuming "employeeAllowances" is your HTML template
																// for displaying allowances.
		} else {
			// Handle the case when the employee does not exist
			model.addAttribute("errorMessage", "Employee not found");
			return "EmpDeduction/EmpDeductionMaintenance"; // You should have an error template for displaying the
																// error message.
		}
	}
	
	@GetMapping("empDeduction/new/{empid}")
	public String createNewForm(@PathVariable("empid") long empid ,Model model)
	{
		EmpDeductionMaster empdeduction =new EmpDeductionMaster();
		List<DeductionMaster> deductions = deductionservice.getAllDeduction();
		EmployeeMaster employee = new EmployeeMaster();
	    employee.setEmpId(empid);
	    
		empdeduction.setEmployee(employee);
		model.addAttribute("empdeduction", empdeduction);
		model.addAttribute("Alldeductions", deductions);
		return "EmpDeduction/EmpDeductionAdd";
	}
	
	@PostMapping("/empDeduction")
	public String assignDeduction(@ModelAttribute("empdeduction") EmpDeductionMaster empdeduction,
	        @RequestParam("empId") long empId) {
	    // Set the employee for the EmpAllowanceMaster object
	    EmployeeMaster employee = employeeService.findById(empId);
	    empdeduction.setEmployee(employee);
	    empDeductionService.saveEmployee(empdeduction);
	    

	    // Redirect to the main page that displays all details for the employee
	    return "redirect:/getEmpDeductions/" + empId;
	}
	
	
	@GetMapping("/empDeduction/edit/{empid}")
	public String editEmpDeduction(@PathVariable("empid") long empid ,Model model) {
          
		EmpDeductionMaster empdeduction =new EmpDeductionMaster();
		List<DeductionMaster> deductions = deductionservice.getAllDeduction();
		EmployeeMaster employee = new EmployeeMaster();
        employee.setEmpId(empid);
	    
		empdeduction.setEmployee(employee);
		model.addAttribute("empDeduction", empdeduction);
		model.addAttribute("Alldeduction", deductions);

		return "/EmpDeduction/EmpDeductionEdit";
	}



	@GetMapping("/empDeduction/delete/{id}")
	public String deleteDeduction(@PathVariable("id") long id, @RequestParam("empId") long empId) {
	    EmpDeductionMaster existingDeduction = empDeductionService.findById(id);
	    try {

	        if (existingDeduction == null) {
	            // Handle the case when allowance with ID not found.
	        } else {
	            empDeductionService.deleteEmpDeduction(id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // Redirect to the main page that displays all details for the employee (getEmployeeAllowances)
	    return "redirect:/getEmpDeductions/"+empId;
	}
}
