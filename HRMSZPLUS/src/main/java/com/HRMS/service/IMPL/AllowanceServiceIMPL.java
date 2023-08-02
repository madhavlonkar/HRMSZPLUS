package com.HRMS.service.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.AllowanceDAO;
import com.HRMS.model.AllowanceMaster;
import com.HRMS.service.AllowanceService;

@Service
public class AllowanceServiceIMPL implements AllowanceService {

	@Autowired
	private AllowanceDAO allowancedao;

	@Override
	public List<AllowanceMaster> getAllAllowances() {
			return (List<AllowanceMaster>) allowancedao.findAll();

	}

	@Override
	public AllowanceMaster saveAllowance(AllowanceMaster allowancemaster) {
		return allowancedao.save(allowancemaster);

	}

	@Override
	public AllowanceMaster findAllowanceById(int id) {

		return allowancedao.findById(id).get();

	}

	@Override
	public AllowanceMaster updateAllowance(AllowanceMaster allowancemaster) {
		return allowancedao.save(allowancemaster);
	}

	@Override
	public void deleteAllowance(int id) {
		try {
			allowancedao.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Failed to delete allowance. Please try again later.");
		}
	}

}
