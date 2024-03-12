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

import com.HRMS.model.ClientMaster;
import com.HRMS.model.EmployeeMaster;
import com.HRMS.model.ProjectMaster;
import com.HRMS.service.ClientService;
import com.HRMS.service.EmployeeService;
import com.HRMS.service.ProjectService;

@Controller
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/projects")
    public String getAllProjects(Model model) {
        try {
            List<ProjectMaster> projects = projectService.getAllProjects();
            model.addAttribute("projects", projects);
        } catch (Exception e) {
            logger.error("Failed to retrieve projects.", e);
            // Handle exception appropriately, e.g., show an error page.
            return "errorPage";
        }
        return "Project/projectMaintenance";
    }

    @GetMapping("/project/new")
    public String newProjectForm(Model model) {
        model.addAttribute("project", new ProjectMaster());
        List<EmployeeMaster> managers = employeeService.getManagers(); // Fetch list of managers from service
        List<ClientMaster> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);
        model.addAttribute("managers", managers); // Add managers to the model
        return "Project/newProject";
    }

    @PostMapping("/project/save")
    public String saveNewProject(@ModelAttribute("project") ProjectMaster project) {
        try {
            projectService.saveProject(project);
        } catch (Exception e) {
            logger.error("Failed to save project.", e);
            // Handle exception appropriately, e.g., show an error message.
            return "errorPage";
        }
        return "redirect:/projects";
    }

    @GetMapping("/project/edit/{id}")
    public String editProjectForm(@PathVariable("id") int id, Model model) {
        try {
        	List<EmployeeMaster> managers = employeeService.getManagers();
            ProjectMaster project = projectService.findProjectById(id);
            if (project == null) {
                logger.error("Project with ID " + id + " not found.");
                // Handle the case where project is not found, e.g., show a not found page.
                return "notFoundPage";
            }
            model.addAttribute("managers", managers);
            model.addAttribute("project", project);
        } catch (Exception e) {
            logger.error("Failed to retrieve project for editing.", e);
            // Handle exception appropriately.
            return "errorPage";
        }
        return "Project/editProject";
    }

    @PostMapping("/project/update/{id}")
    public String updateProject(@PathVariable("id") int id, @ModelAttribute("project") ProjectMaster project) {
        try {
            project.setProjectId(id);
            projectService.updateProject(project);
        } catch (Exception e) {
            logger.error("Failed to update project.", e);
            // Handle exception appropriately.
            return "errorPage";
        }
        return "redirect:/projects";
    }

    @GetMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable("id") int id) {
        try {
            ProjectMaster existingProject = projectService.findProjectById(id);
            if (existingProject == null) {
                logger.error("Project with ID " + id + " not found.");
                // Handle the case where project is not found, e.g., show a not found page.
                return "notFoundPage";
            }
            projectService.deleteProject(id);
        } catch (Exception e) {
            logger.error("Failed to delete project.", e);
            // Handle exception appropriately.
            return "errorPage";
        }
        return "redirect:/projects";
    }
}
