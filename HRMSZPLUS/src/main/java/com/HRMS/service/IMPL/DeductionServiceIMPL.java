package com.HRMS.service.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.HRMS.dao.DeductionDao;
import com.HRMS.model.DeductionMaster;
import com.HRMS.service.DeductionService;

public class DeductionServiceIMPL implements DeductionService {
    
	@Autowired
	private DeductionDao deductionDao;
	
	@Override
	public List<DeductionMaster> getAllDeduction() {
		try {
			return (List<DeductionMaster>) deductionDao.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public DeductionMaster saveDeduviton(DeductionMaster deductionmaster) {
		DeductionMaster deductionMaster =null;
		try {
			deductionMaster = deductionDao.save(deductionMaster);
			return deductionMaster;
		} catch (Exception e) {
			e.printStackTrace();
			return deductionMaster;
		}
	}

	@Override
	public DeductionMaster findDeductionById(int id) {
		try {
			return deductionDao.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DeductionMaster updateDeduction(DeductionMaster deductionMaster) {
		DeductionMaster deducMaster=null;
		try {
			deducMaster=deductionDao.save(deductionMaster);
			return deducMaster;
		} catch (Exception e) {
			e.printStackTrace();
			return deducMaster;
		}
		
		
	}

	@Override
	public void deleteDeduction(int id) {
		try {
			deductionDao.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("failed to delet deduction. Please try again later.");
		}
		
	}

}
