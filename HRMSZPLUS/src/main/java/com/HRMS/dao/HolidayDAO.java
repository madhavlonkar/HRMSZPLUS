package com.HRMS.dao;

import org.springframework.data.repository.CrudRepository;

import com.HRMS.model.HolidayMaster;

public interface HolidayDAO extends CrudRepository<HolidayMaster, Integer>{

}
