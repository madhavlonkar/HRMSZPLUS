package com.HRMS.service.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.LeaveDAO;
import com.HRMS.model.LeaveMaster;
import com.HRMS.service.LeaveService;

@Service
public class LeaveServiceIMPL implements LeaveService{
	
	@Autowired
	private LeaveDAO leavedao;

	@Override
	public List<LeaveMaster> getAllLeaves() {

		try {
			return (List<LeaveMaster>) leavedao.findAll();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LeaveMaster saveLeave(LeaveMaster leavemaster) {

		LeaveMaster leamaster = null;
		
		try {
			leavemaster = leavedao.save(leavemaster);
			return leamaster;
		}catch(Exception e)
		{
			e.printStackTrace();
			return leamaster;
		}
	}

	@Override
	public LeaveMaster findLeaveById(int id) {
			try {
				return leavedao.findById(id).get();
			}catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public LeaveMaster updateLeave(LeaveMaster leavemaster) {
		
		LeaveMaster leamaster = null;
		try {
			leavemaster = leavedao.save(leavemaster);
			return leamaster;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteLeave(int id) {

		try {
			leavedao.deleteById(id);
		}catch(Exception e)
		{
			throw new RuntimeException("Failed to delete holiday. Please try again later.");
		}
			
	}
	
}
 