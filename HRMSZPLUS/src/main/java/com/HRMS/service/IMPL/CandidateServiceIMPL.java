	package com.HRMS.service.IMPL;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.HRMS.dao.CandidateDAO;
import com.HRMS.model.CandidateMaster;
import com.HRMS.service.CandidateService;
import com.HRMS.utility.FileCompressionUtils;

@Service
public class CandidateServiceIMPL implements CandidateService {

	@Autowired
	private CandidateDAO candidateDao;

	@Override
	public List<CandidateMaster> getAllCandidateService() {
		try {

			List<CandidateMaster> allCandidates = (List<CandidateMaster>) candidateDao.findAll();
			return allCandidates;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CandidateMaster getCandidateById(int candidateId) {
		try {
			return candidateDao.findById((long) candidateId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteCandidate(int candidateId) {
		try {
			candidateDao.deleteById((long) candidateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CandidateMaster addCandidate(CandidateMaster candidate) {
			
			try {
				CandidateMaster save = candidateDao.save(candidate);
				return save;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
			
		
	}
	
	 @Override
	    public CandidateMaster saveCandidate(CandidateMaster candidate, MultipartFile file) throws IOException {
	        Date currentDate = new Date();
	        String currentDateAsString = currentDate.toString();
	        byte[] compressedResume = FileCompressionUtils.compressData(file); // Compress file data

	        CandidateMaster candidateMaster = new CandidateMaster(
	                4, // Provide default or appropriate value for demandId
	                currentDateAsString, // Provide appropriate date for appliedDate
	                candidate.getCandidateFirstName(),
	                candidate.getCandidateLastName(),
	                "", // Provide appropriate value for candidateAddress
	                "", // Provide appropriate value for candidateGender
	                candidate.getCandidateEmail(),
	                candidate.getCandidateMobileNo(),
	                candidate.getJobId(),
	                file.getOriginalFilename(),
	                file.getContentType(),
	                compressedResume // Use compressed resume data
	        );

	        return candidateDao.save(candidateMaster);
	    }

	
}


