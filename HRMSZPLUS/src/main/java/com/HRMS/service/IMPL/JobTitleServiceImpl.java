package com.HRMS.service.IMPL;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.HRMS.dao.JobTitleDAO;
import com.HRMS.model.JobTitleMaster;
import com.HRMS.service.JobTitleService;

public class JobTitleServiceImpl implements JobTitleService {
	
	private static final Logger log = LoggerFactory.getLogger(JobTitleServiceImpl.class);
	
	@Autowired
	private JobTitleDAO jobTitleDAO;

	@Override
	public List<JobTitleMaster> findAllJobTitle() { 
     try {
		return(List<JobTitleMaster>) jobTitleDAO.findAll();
	} catch (DataAccessException e) {
		log.error("Failed to retrive Jobtitles:", e.getMessage());
		e.printStackTrace();
		return null;
	}
       
	}

	@Override
	public JobTitleMaster addJobTitle(JobTitleMaster JobTitle) {
		try {
			return jobTitleDAO.save(JobTitle);
		}catch (DataAccessException e) {

			log.error("Failed to Save JobTitle ",e.getMessage());
			return null;
		}
	}

	@Override
	public JobTitleMaster findById(int id) {
		Optional<JobTitleMaster>  jobTitle = jobTitleDAO.findById(id);
		if(jobTitle.isPresent()) {
			return jobTitle.get();
		}else {
			log.error("JobTitle with Id {} not found.", id);
			return null;
			
		}
	}

	@Override
	public void deleteJobTitle(int id) {
	    try {
			 jobTitleDAO.deleteById(id);
		} catch (DataAccessException e) {
			log.error("Failed to delete JobTitle eith id:"+id, e.getMessage());
			e.printStackTrace();
		}
		
	}

}
