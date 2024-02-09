package com.HRMS.service;

import java.util.List;

import com.HRMS.model.JobTitleMaster;

public interface JobTitleService {
	
	List<JobTitleMaster> findAllJobTitle();
	JobTitleMaster addJobTitle(JobTitleMaster JobTitle);
	JobTitleMaster findById(int id);
	void deleteJobTitle(int id);
	

}
