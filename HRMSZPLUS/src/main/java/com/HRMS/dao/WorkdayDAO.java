package com.HRMS.dao;

import org.springframework.data.repository.CrudRepository;

import com.HRMS.model.WorkdayMaster;

public interface WorkdayDAO extends CrudRepository<WorkdayMaster, Integer> {
	

}
