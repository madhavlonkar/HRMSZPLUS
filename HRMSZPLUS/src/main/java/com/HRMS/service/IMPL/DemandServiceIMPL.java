package com.HRMS.service.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.DemandDAO;
import com.HRMS.model.DemandMaster;
import com.HRMS.service.DemandService;

@Service
public class DemandServiceIMPL implements DemandService {

	
	@Autowired
	private DemandDAO demandDAO;
	
	@Override
	public DemandMaster saveDemand(DemandMaster demand) {
		try {
			return demandDAO.save(demand);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DemandMaster> getAllDemands() {
		try {
			return (List<DemandMaster>) demandDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
