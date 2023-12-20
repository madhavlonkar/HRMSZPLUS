package com.HRMS.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HRMS.model.DemandMaster;
import com.HRMS.model.DesignationMaster;
import com.HRMS.model.ProjectMaster;
import com.HRMS.service.DemandService;
import com.HRMS.service.DesignationService;
import com.HRMS.service.ProjectService;

@Controller
public class DemandController {

	@Autowired
	private DesignationService designationService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private DemandService demandService;

	@GetMapping("/openDemands")
	public String getAllOpenDemands(Model model) {
		List<DemandMaster> allDemands = demandService.getAllDemands();
		model.addAttribute("allDemands", allDemands);
		return "Demands/openDemands";
	}

	@GetMapping("/demandDetail")
	public String getDemandDetails(Model model) {

		return "Demands/DemandDetailsWithCandidatesList";
	}

	@GetMapping("/createDemand")
	public String createDemandForm(Model model) {
		List<DesignationMaster> AllDesignations = designationService.findAllDesignations();
		List<ProjectMaster> allProjects = projectService.getAllProjects();

		model.addAttribute("AllDesignations", AllDesignations);
		model.addAttribute("allProjects", allProjects);

		DemandMaster demand = new DemandMaster();
		model.addAttribute("demand", demand);
		return "Demands/createDemand";
	}

	@PostMapping("/createDemand")
	public String createDemand(@ModelAttribute("demand") DemandMaster demand, Model model) {
		LocalDate currentDate = LocalDate.now();
		Date sqlDate = Date.valueOf(currentDate);
		
		DesignationMaster designationById = designationService.findById(demand.getPosition().getDesignationId());
		demand.setPosition(designationById);
		
		ProjectMaster projectById = projectService.getProjectById(demand.getProject().getProjectId());
		demand.setProject(projectById);

		demand.setDemandDate(sqlDate);
		demand.setStatus("Opened");

		DemandMaster savedDemand = demandService.saveDemand(demand);
//		return savedDemand;
		return "redirect:/openDemands";

	}
}
