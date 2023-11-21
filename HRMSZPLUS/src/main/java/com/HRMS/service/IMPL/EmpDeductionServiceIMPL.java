package com.HRMS.service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.EmpDeductionDAO;
import com.HRMS.model.EmpDeductionMaster;
import com.HRMS.service.EmpDeductionService;

@Service
public class EmpDeductionServiceIMPL implements EmpDeductionService {

	@Autowired
	EmpDeductionDAO empDedDao;

	@Override
	public EmpDeductionMaster findById(long id) {
		try {
			return empDedDao.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<EmpDeductionMaster> getEmployeeDeductionsById(long id) {
		List<EmpDeductionMaster> deductions;
		try {
			deductions = empDedDao.findByEmployeeEmpId(id);
		} catch (Exception e) {
			e.printStackTrace();
			deductions = new ArrayList<>();
		}
		return deductions;
	}

	@Override
	public void deleteEmpDeduction(Long id) {
		try {
			empDedDao.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Failed todelete empDeduction with ID" + id + ".please try again later.");
		}
	}

	@Override
	public EmpDeductionMaster saveEmployee(EmpDeductionMaster empDeduction) {
		try {
			return empDedDao.save(empDeduction);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
