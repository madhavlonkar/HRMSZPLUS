package com.HRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRMS.model.AllowanceMaster;
import com.HRMS.service.AllowanceService;

@Controller
public class AllowanceController {

	@Autowired
	private AllowanceService allowanceService;

	@GetMapping("/allowances")
	public String getAllAllowances(Model model) {

		List<AllowanceMaster> allowances = allowanceService.getAllAllowances();
		model.addAttribute("allowances", allowances);
		return "/Allowance/AllowanceMaintenance";
	}

	@GetMapping("/allowances/new")
	public String createAllowanceForm(Model model) {
		model.addAttribute("allowance", new AllowanceMaster());
		return "/Allowance/NewAllowance";
	}

	@PostMapping("/allowances")
	public String addAllowance(@ModelAttribute("allowance") AllowanceMaster allowancemaster) {
		allowanceService.saveAllowance(allowancemaster);
		return "redirect:/allowances";
	}

	
	
	@GetMapping("/allowances/edit/{id}")
	public String editAllowance(@PathVariable("id") int id, Model model) {
		AllowanceMaster allowance = allowanceService.findAllowanceById(id);
		model.addAttribute("allowance", allowance);
		return "/Allowance/EditAllowance";
	}

	@PostMapping("/allowance/{id}")
	public String updateallowance(@PathVariable("id") int id,
			@ModelAttribute("allowance") AllowanceMaster allowancemaster) {

		allowanceService.updateAllowance(allowancemaster);
		return "redirect:/allowances";
	}
	
	

	@GetMapping("/allowance/{id}")
	public String deleteAllowance(@PathVariable("id") int id) {
		allowanceService.deleteAllowance(id);
		return "redirect:/allowances";
	}

	@GetMapping("/allowances/view/{id}")
	public String viewAllowance(@PathVariable("id") int id, Model model) {
		AllowanceMaster allowance = allowanceService.findAllowanceById(id);
		if (allowance == null) {
			// Handle the case where the allowance with the given id does not exist
			return "redirect:/allowances";
		}
		model.addAttribute("allowance", allowance);
		return "/Allowance/ViewAllowance";
	}

}
