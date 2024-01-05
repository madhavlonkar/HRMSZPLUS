package com.HRMS.service.IMPL;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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
			throw new RuntimeException("Failed to delete leave. Please try again later.");
		}
			
	}

	
	
	
	    @Override
	    public int calculateTotalLeaveDays(LeaveMaster leavemaster) {
	        try {
	            Date leaveFromDate = leavemaster.getLeaveFrom();
	            Date leaveToDate = leavemaster.getLeaveTo();

	            LocalDate leaveFrom = leaveFromDate.toLocalDate();
	            LocalDate leaveTo = leaveToDate.toLocalDate();

	            int totalLeaveDays = 0;

	            while (!leaveFrom.isAfter(leaveTo)) {
	                // Check if the current leaveFrom date is in the same month as leaveTo
	                if (leaveFrom.getMonth() == leaveTo.getMonth()) {
	                    totalLeaveDays += ChronoUnit.DAYS.between(leaveFrom, leaveTo) + 1;
	                    break; // Exit the loop since we've covered the entire period
	                } else {
	                    YearMonth yearMonth = YearMonth.from(leaveFrom);
	                    LocalDate endOfMonth = yearMonth.atEndOfMonth();
	                    long daysInMonth = ChronoUnit.DAYS.between(leaveFrom, endOfMonth) + 1;

	                    totalLeaveDays += (int) daysInMonth;

	                    leaveFrom = leaveFrom.plusMonths(1).withDayOfMonth(1);
	                }
	            }

	            return totalLeaveDays;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0; // Return 0 in case of an exception
	        }
	    }

}