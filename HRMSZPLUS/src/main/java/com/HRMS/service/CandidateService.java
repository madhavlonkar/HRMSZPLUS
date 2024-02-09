package com.HRMS.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.HRMS.model.CandidateMaster;

public interface CandidateService {

	List<CandidateMaster> getAllCandidateService();
	CandidateMaster getCandidateById(int candidateId);
	void deleteCandidate(int candidateId);
	CandidateMaster addCandidate(CandidateMaster candidate);
	 CandidateMaster saveCandidate(CandidateMaster candidate,MultipartFile file) throws IOException;
}
