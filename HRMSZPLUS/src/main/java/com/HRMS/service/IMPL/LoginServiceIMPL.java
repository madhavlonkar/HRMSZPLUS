package com.HRMS.service.IMPL;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
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

	@Autowired
	private OtpLoginService otploginservice;

	@Override
	public LoginMaster checklogin(LoginMaster loginmaster) {

		LoginMaster user = logindao.findByUsername(loginmaster.getUsername());
		if (user == null) {
			log.error("No UserFound With Name : " + loginmaster.getUsername());
			return null;
		}

		try {
			boolean passwordMatches = BCrypt.checkpw(loginmaster.getPassword(), user.getPassword());

			System.out.print("1SSSSSSSSSSSSSSS");

			if (user.getUsername().equals(loginmaster.getUsername())) {
				if (passwordMatches) {

					return user;
				} else {
					otploginservice.recordFailedAttempt(user.getUsername());
					return null;
				}
			} else {

				return null;
			}
		} catch (Exception e) {
			log.error("Username And Password Does Not Match");
			e.printStackTrace();
			return null;
		}

//		return null;

	}

	@Override
	public boolean newUser(LoginMaster loginmaster) {

		try {
			loginmaster.setUserId(2);

			String hashedPassword = BCrypt.hashpw(loginmaster.getPassword(), BCrypt.gensalt());
			loginmaster.setPassword(hashedPassword);
			logindao.save(loginmaster);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<LoginMaster> getAllUser() {
		try {
			List<LoginMaster> alluser = (List<LoginMaster>) logindao.findAll();
			return alluser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public LoginMaster findUserLoginsById(int id) {

		LoginMaster findById = logindao.findById(id).get();
		return findById;
	}

	@Override
	public void updateLogins(LoginMaster loginmaster) {
		try {

			String hashedPassword = BCrypt.hashpw(loginmaster.getPassword(), BCrypt.gensalt());
			loginmaster.setPassword(hashedPassword);
			logindao.save(loginmaster);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		try {
			logindao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
