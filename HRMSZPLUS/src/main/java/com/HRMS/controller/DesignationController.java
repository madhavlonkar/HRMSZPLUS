package com.HRMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.HRMS.model.DesignationMaster;
import com.HRMS.service.DesignationService;

@Controller
public class DesignationController {

	
	private static final Logger log = LoggerFactory.getLogger(DesignationController.class);

	@Autowired
	private DesignationService designationservice;
	
	@GetMapping("/designations")
	public String getAllDesigantions(Model model)
	{
		List<DesignationMaster> findAllDesignations = designationservice.findAllDesignations();
		if(findAllDesignations.isEmpty())
		{
			log.error("No Deisgnation Available To Retrieve");
			return "/Designation/DesignationMaintenance";
		}
		
		model.addAttribute("designations",findAllDesignations);
		return "/Designation/DesignationMaintenance";
	}
}
