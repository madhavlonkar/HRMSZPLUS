package com.HRMS.service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.EmpAllowanceDAO;
import com.HRMS.model.EmpAllowanceMaster;
import com.HRMS.service.EmpAllowanceService;

@Service
public class EmpAllowanceServiceIMPL implements EmpAllowanceService {

	@Autowired
	private EmpAllowanceDAO empAllowanceDAO;
	
	
	@Override
	public EmpAllowanceMaster findById(long id) {
		try
		{
			return empAllowanceDAO.findById(id).orElse(null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
  
	@Override
	public List<EmpAllowanceMaster> getEmployeeAllowancesById(long id) {
	    List<EmpAllowanceMaster> allowances;
	    try {
	        allowances = empAllowanceDAO.findByEmployeeEmpId(id);
	    } catch (Exception e) {
	        // Handle the exception appropriately
	        e.printStackTrace();
	        allowances = new ArrayList<>(); // Initialize the list to avoid returning null
	    }
	    return allowances;
	}

	@Override
	public void deleteEmpAllowance(Long id) {
	    try {
	        empAllowanceDAO.deleteById(id);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to delete empAllowance with ID " + id + ". Please try again later.");
	    }
	}

	@Override
	public EmpAllowanceMaster saveEmployee(EmpAllowanceMaster empallowance) {
		try {
			return empAllowanceDAO.save(empallowance);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public EmpAllowanceMaster getAllowanceById(long id) {
		try
		{
			return empAllowanceDAO.findById(id).get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	

}
