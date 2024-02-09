package com.HRMS.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HRMS.model.AllowanceMaster;
import com.HRMS.model.CandidateMaster;
import com.HRMS.service.CandidateService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

	private static final Logger log = LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/getAllCandidates")  // hr
	public String getAllCandidates(Model model) {

		List<CandidateMaster> allCandidate = candidateService.getAllCandidateService();
		model.addAttribute("allCandidates", allCandidate);
		return "/Candidate/newCandidate";
	}
	
	@GetMapping("/getCandidate/{id}")  //hr
	public String getCandidate(@PathVariable("id") int candidateId,Model model)
	{
		CandidateMaster candidateById = candidateService.getCandidateById(candidateId);
		model.addAttribute("Candidate", candidateById);
		return "/candidate/newCandidate";
	}
	
	@GetMapping("/new")  // new candidate
	public String createNewForm(Model model)
	{
		
		model.addAttribute("candidate",new CandidateMaster());
		
		return "Candidate/newCandidate";
	}
	
//	@PostMapping("/add")
//	public String addCandidate(@ModelAttribute("candidate") @Validated CandidateMaster candidate,
//	                           @RequestParam("resumeFile") MultipartFile resumeFile,
//	                           BindingResult bindingResult,
//	                           RedirectAttributes redirectAttributes) {
//
//	    if (bindingResult.hasErrors()) {
//	        // If there are validation errors, redirect to the form with error messages
//	        return "Candidate/newCandidate";
//	    }
//
//	    if (resumeFile != null && !resumeFile.isEmpty()) {
//	        try {
//	            byte[] resumeBytes = resumeFile.getBytes();
//	            candidate.setResume(resumeBytes);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            redirectAttributes.addFlashAttribute("error", "Error uploading resume");
//	            return "redirect:/candidates"; // Redirect to candidates page with error message
//	        }
//	    } else {
//	        redirectAttributes.addFlashAttribute("error", "Resume file is empty");
//	        return "redirect:/candidates"; // Redirect to candidates page with error message
//	    }
//
//	    // Proceed with saving the candidate data
//	    CandidateMaster addedCandidate = candidateService.addCandidate(candidate);
//	    if (addedCandidate != null) {
//	        return "redirect:/candidates"; // Redirect to candidates page after successful addition
//	    } else {
//	        redirectAttributes.addFlashAttribute("error", "Failed to add candidate");
//	        return "redirect:/candidates"; // Redirect to candidates page with error message
//	    }
//	}
	@PostMapping("/add")
    public String addCandidate(@ModelAttribute CandidateMaster candidateMaster
    		,@RequestParam("resume") MultipartFile file
    		) throws IOException {
        CandidateMaster savedCandidate = candidateService.saveCandidate(candidateMaster,file);
        return "redirect:/candidates";
    }

//@RequestParam("resume") MultipartFile file, 
	
//	@PostMapping("/add")
//	public String addCandidate(@ModelAttribute("candidateMaster")  CandidateMaster candidateMaster,
//	                           @RequestParam("resume") MultipartFile resume,
//	                           RedirectAttributes redirectAttributes) {
//		 try {
//		        byte[] resumeBytes = file.getBytes();
//		        candidateMaster.setResume(resumeBytes);
//		        
//		        // Other logic for saving the candidate or processing the form
//		        
//		        return "redirect:/success"; // Redirect to a success page
//		    } catch (IOException e) {
//		        // Handle file processing error
//		        redirectAttributes.addFlashAttribute("error", "Error processing file");
//		        return "redirect:/error"; // Redirect to an error page
//		    }


}
