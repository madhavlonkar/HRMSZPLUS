package com.HRMS.service.IMPL;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.DesignationDAO;
import com.HRMS.model.DesignationMaster;
import com.HRMS.service.DesignationService;

@Service
public class DesignationServiceIMPL implements DesignationService{

	
	private static final Logger log = LoggerFactory.getLogger(DesignationServiceIMPL.class);

	
	@Autowired
	private DesignationDAO designationdao;
	
	@Override
	public List<DesignationMaster> findAllDesignations() {
		
		try {
			List<DesignationMaster> designations=(List<DesignationMaster>) designationdao.findAll();
			return designations;
			
		} catch (Exception e) {
			log.error("No Designation to Retrieve");
			e.printStackTrace();
			return null;
			
		}
	}

}
