package com.HRMS.service.IMPL;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.ProjectDAO;
import com.HRMS.model.ProjectMaster;
import com.HRMS.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public List<ProjectMaster> getAllProjects() {
        return (List<ProjectMaster>) projectDAO.findAll();
    }

    @Override
    public ProjectMaster findProjectById(int id) {
        Optional<ProjectMaster> result = projectDAO.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public void saveProject(ProjectMaster project) {
        projectDAO.save(project);
    }

    @Override
    public void updateProject(ProjectMaster project) {
        // Check if the project exists before updating
        if (projectDAO.existsById(project.getProjectId())) {
            projectDAO.save(project);
        } else {
            // Handle the case where the project does not exist
            throw new IllegalArgumentException("Project not found with ID: " + project.getProjectId());
        }
    }

    @Override
    public void deleteProject(int id) {
        projectDAO.deleteById(id);
    }
}
