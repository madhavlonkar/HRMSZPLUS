package com.HRMS.dao;

import org.springframework.data.repository.CrudRepository;

import com.HRMS.model.ClientMaster;

public interface ClientDAO extends CrudRepository<ClientMaster, Integer>{

}
