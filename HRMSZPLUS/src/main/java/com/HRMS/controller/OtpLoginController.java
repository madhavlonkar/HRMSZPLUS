package com.HRMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRMS.model.LoginMaster;
import com.HRMS.model.OtpLoginMaster;
import com.HRMS.service.OtpLoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OtpLoginController {

	@Autowired
	private OtpLoginService otploginservice;

	@GetMapping("/otp")
	public String showOtpPage(Model model, HttpSession session) {
		String loggedInUsername = (String) session.getAttribute("loggedInUsername");
		
		if(otploginservice.CheckLockedUser(loggedInUsername))
		{
			model.addAttribute("AccountLocked", "Account Has Been Locked Due To Suspicious Activity");
			model.addAttribute("login", new LoginMaster());
		    return "/Login/login";
		}
		
		if (session.getAttribute("loggedInUsername") == null) {
            return "redirect:/login";
        }
		
		boolean otpAlreadyPresent = otploginservice.isOtpAlreadyPresent(loggedInUsername);
		
		if(otpAlreadyPresent)
		{
			model.addAttribute("otpAlreadyPresent", otpAlreadyPresent);
			return "/Login/otp";
		}
		
		model.addAttribute("otpsent", true);
		otploginservice.generateAndSaveOtp(loggedInUsername);
		model.addAttribute("otp", new OtpLoginMaster());
		return "/Login/otp";
	}

	@PostMapping("/otp")
	public String verifyOtp(@ModelAttribute("otp") OtpLoginMaster otploginmaster, Model model, HttpSession session) {
		String loggedInUsername = (String) session.getAttribute("loggedInUsername");
		boolean otpVerified = otploginservice.verifyOtp(loggedInUsername,otploginmaster.getPin());
		if (otpVerified) {
			
			otploginservice.resetFailedAttemp(loggedInUsername);
			session.setAttribute("otpVerifiedUser", loggedInUsername);
			System.out.print("User Logged in is :"+session.getAttribute("otpVerifiedUser"));
//			session.invalidate();
			
			return "redirect:/dashboard";
		} else {
			
			otploginservice.recordFailedAttempt(loggedInUsername);
			
			if(otploginservice.CheckLockedUser(loggedInUsername))
			{
				model.addAttribute("AccountLocked", "Account Has Been Locked Due To Suspicious Activity");
				model.addAttribute("login", new LoginMaster());
			    return "/Login/login";
			}
			// If the OTP is incorrect, show the error message on the OTP page
			model.addAttribute("errorMessage", "Incorrect OTP! Please try again.");
			return "/Login/otp";
		}
	}

}
