package com.HRMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRMS.model.LoginMaster;
import com.HRMS.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@GetMapping("/login")
	public String showLoginPage(Model model,HttpSession httpsession) {
		httpsession.invalidate();
		model.addAttribute("login", new LoginMaster());
		return "/Login/login";
	}

	@PostMapping("/login")
	public String checkLogin(@ModelAttribute("login") LoginMaster loginmaster, Model model, HttpSession session) {
		LoginMaster checklogin = loginservice.checklogin(loginmaster);
		if (checklogin != null) {

			session.setAttribute("loggedInUsername", checklogin.getUsername());
			return "redirect:/otp";
			
		} else {
			model.addAttribute("login", new LoginMaster());
			model.addAttribute("errorMessage", "Incorrect username or password.");
			return "/Login/login";
		}

	}

}
