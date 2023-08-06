package com.HRMS.dao;

import org.springframework.data.repository.CrudRepository;

import com.HRMS.model.OtpLoginMaster;

public interface OtpLoginDAO extends CrudRepository<OtpLoginMaster, Integer>{

	public OtpLoginMaster findByName(String Username);
}
