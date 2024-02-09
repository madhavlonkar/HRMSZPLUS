package com.HRMS.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HRMS.model.CandidateMaster;

public interface CandidateDAO extends JpaRepository<CandidateMaster, Long>{

	
	 Optional<CandidateMaster> findByCandidateFirstNameAndCandidateLastName(String firstName, String lastName);
}
