package com.HRMS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.HRMS.controller.LoginController;
import com.HRMS.model.LoginMaster;
import com.HRMS.service.LoginService;
import com.HRMS.service.OtpLoginService;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LoginControllerTest {
    @InjectMocks
    private LoginController loginController;
    
    @Mock
    private LoginMaster loginMaster;

    @Mock
    private LoginService loginService;
    
    @Mock
    private OtpLoginService otpLoginService;

    @BeforeEach
    public void setUp() {
        // Initialize your LoginController instance.
        loginController = new LoginController();
    }

    @Test
	    public void testUsernameRegex() {
	        // Define the regular expression for username validation.
	        String usernameRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	
	        // Test with valid and invalid usernames
	        assertTrue(loginController.validateUsername("validUsername123@example.com", usernameRegex));
	        assertTrue(loginController.validateUsername("anotherValid@my-website.co", usernameRegex));
	        assertTrue(loginController.validateUsername("1234@domain.name", usernameRegex));
	
	        // Invalid usernames
	        assertTrue(!loginController.validateUsername("invalidUsername", usernameRegex));
	        assertTrue(!loginController.validateUsername("example.com", usernameRegex));
	        assertTrue(!loginController.validateUsername("user@.com", usernameRegex));
	        
	        
	        System.out.println(loginController.validateUsername("validUsername123@example.com", usernameRegex));
	        System.out.println(loginController.validateUsername("anotherValid@my-website.co", usernameRegex));
	        System.out.println(loginController.validateUsername("1234@domain.name", usernameRegex));
	        System.out.println(loginController.validateUsername("invalidUsername", usernameRegex));
	        System.out.println(loginController.validateUsername("example.com", usernameRegex));
	        System.out.println(loginController.validateUsername("user@.com", usernameRegex));
	       
	    }

    @Test
    public void testPasswordRegex() {
        // Define the regular expression for password validation.
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&#]{8,}$";

        // Test with valid and invalid passwords
        System.out.println(loginController.validatePassword("ValidPassword123$", passwordRegex));
        System.out.println(loginController.validatePassword("StrongP@ssw0rd", passwordRegex));
        System.out.println(loginController.validatePassword("Secure123!#", passwordRegex));

        // Invalid passwords
        System.out.println(loginController.validatePassword("weakpassword", passwordRegex));
        System.out.println(loginController.validatePassword("Short1@", passwordRegex));
        System.out.println(loginController.validatePassword("noSpecialChars1234", passwordRegex));
        System.out.println();

    }
}
