package com.HRMS.service.IMPL;

import java.sql.Timestamp;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRMS.dao.OtpLoginDAO;
import com.HRMS.model.OtpLoginMaster;
import com.HRMS.service.OtpLoginService;

@Service
public class OtpLoginServiceIMPL implements OtpLoginService {

	private static final Logger log = LoggerFactory.getLogger(OtpLoginServiceIMPL.class);

	@Autowired
	private OtpLoginDAO otplogindao;

	@Override
	public boolean isOtpAlreadyPresent(String username) {

		if (otplogindao.findByName(username) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyOtp(String username, int enteredOtp) {

		OtpLoginMaster otp = otplogindao.findByName(username);

		if (otp != null && otp.getPin() == enteredOtp) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void generateAndSaveOtp(String username) {
		OtpLoginMaster existingOtp = otplogindao.findByName(username);

		if (existingOtp == null) {

			Random random = new Random();
			int pin = random.nextInt(9000) + 1000;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			OtpLoginMaster otp = new OtpLoginMaster();
			otp.setName(username);
			otp.setPin(pin);
			otp.setTs(timestamp);

			otplogindao.save(otp);
		}

	}

}
