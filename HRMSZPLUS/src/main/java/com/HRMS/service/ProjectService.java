package com.HRMS.service;

import java.util.List;

import com.HRMS.model.ProjectMaster;

public interface ProjectService {

    List<ProjectMaster> getAllProjects();

    ProjectMaster findProjectById(int id);

    void saveProject(ProjectMaster project);

    void updateProject(ProjectMaster project);

    void deleteProject(int id);
}
