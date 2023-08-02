package com.HRMS.service.IMPL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.LoginDAO;
import com.HRMS.model.LoginMaster;
import com.HRMS.service.LoginService;
import com.HRMS.service.OtpLoginService;

@Service
public class LoginServiceIMPL implements LoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceIMPL.class);

	@Autowired
	private LoginDAO logindao;
	
	@Override
	public LoginMaster checklogin(LoginMaster loginmaster) {

		LoginMaster user = logindao.findByUsername(loginmaster.getUsername());
		if (user == null) {
			log.error("No UserFound With Name : " + loginmaster.getUsername());
			return null;
		}

		try {
			if (user.getUsername().equals(loginmaster.getUsername())) {
				if (user.getPassword().equals(loginmaster.getPassword())) {
					
					return user;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error("Username And Password Does Not Match");
			e.printStackTrace();
			return null;
		}

		return null;

	}

}
