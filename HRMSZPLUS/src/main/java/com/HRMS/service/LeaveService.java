package com.HRMS.service;

import java.util.List;

import com.HRMS.model.LeaveMaster;

public interface LeaveService {

	List<LeaveMaster> getAllLeaves();
	
	LeaveMaster saveLeave(LeaveMaster leavemaster);
	
	LeaveMaster findLeaveById(int id);
	
	LeaveMaster updateLeave(LeaveMaster leavemaster);
	
	void deleteLeave(int id);
}
