package com.HRMS.service.IMPL;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.WorkdayDAO;
import com.HRMS.model.WorkdayMaster;
import com.HRMS.service.WorkdayService;

@Service
public class WorkdayServiceIMPL implements WorkdayService{
	
	@Autowired
	private WorkdayDAO workdaydao;

	@Override
	public List<WorkdayMaster> getAllWorkdays() {
		try {
			return (List<WorkdayMaster>) workdaydao.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public WorkdayMaster saveWorkday(WorkdayMaster workdaymaster) {
       WorkdayMaster workmaster = null;
		
		try {
			workmaster = workdaydao.save(workdaymaster);
			return workmaster;
		}catch(Exception e)
		{
			e.printStackTrace();
		   return workmaster;
		}
	}

	@Override
	public WorkdayMaster findWorkdayById(int id) {
		try {
			return workdaydao.findById(id).get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public WorkdayMaster updateWorkday(WorkdayMaster workdaymaster) {
      WorkdayMaster workmaster = null;
		
		try {
			workmaster= workdaydao.save(workdaymaster);
			return workmaster;
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return workmaster;
		}
	}

	@Override
	public void deleteWorkday(int id) {
		try
		{
			workdaydao.deleteById(id);
		}catch(Exception e)
		{
			throw new RuntimeException("Failed to delete workday. Please try again later.");
		}
	}

}
