package com.HRMS.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.HRMS.model.CandidateMaster;
import com.HRMS.service.CandidateService;

@Controller
public class CandidateController {

	private static final Logger log = LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/getAllCandidates")  // hr
	public String getAllCandidates(Model model) {

		List<CandidateMaster> allCandidate = candidateService.getAllCandidateService();
		model.addAttribute("allCandidates", allCandidate);
		return "/candidate/DEMO";
	}
	
	@GetMapping("/getCandidate/{id}")  //hr
	public String getCandidate(@PathVariable("id") int candidateId,Model model)
	{
		CandidateMaster candidateById = candidateService.getCandidateById(candidateId);
		model.addAttribute("Candidate", candidateById);
		return "/a";
	}
	
	@GetMapping("/candidate/new")  // new candidate
	public String createNewForm(Model model)
	{
		
		model.addAttribute("candidate",new CandidateMaster());
		
		return "Candidate/newCandidate";
	}
	
	@PostMapping("/candidate")
	public String addCandidate(@ModelAttribute("candidate") CandidateMaster candidate,
	                           @RequestParam("resumeFile") MultipartFile resumeFile,
	                           @RequestParam("profilePhoto") MultipartFile profilePhoto) {

	    if (!resumeFile.isEmpty()) {
	        String originalFileName = candidate.getCandidateName().charAt(0) + "_" + candidate.getCandidateName() + "_" + resumeFile.getOriginalFilename();
	        String directoryPath = "resumes/";

	        try {
	            Files.createDirectories(Paths.get(directoryPath));
	            String filePath = directoryPath + originalFileName;
	            Path path = Paths.get(filePath);
	            Files.write(path, resumeFile.getBytes());
	            candidate.setResumePath(filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "redirect:/candidates";
	        }
	    }

	    if (!profilePhoto.isEmpty()) {
	        String originalFileName = profilePhoto.getOriginalFilename();
	        String directoryPath = "profilePhotos/";

	        try {
	            Files.createDirectories(Paths.get(directoryPath));
	            String filePath = directoryPath + originalFileName;
	            Path path = Paths.get(filePath);
	            Files.write(path, profilePhoto.getBytes());
	            candidate.setProfileImageData(filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "redirect:/candidates";
	        }
	    }

	    CandidateMaster addedCandidate = candidateService.addCandidate(candidate);

	    if (addedCandidate != null) {
	        return "redirect:/candidates";
	    } else {
	        return "redirect:/candidates";
	    }
	}


}
