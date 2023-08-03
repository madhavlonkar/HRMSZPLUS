package com.HRMS.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SessionValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Check if the session is still valid
        if (request.getSession().getAttribute("otpVerifiedUser") == null) {
            // Session is expired or not present, redirect to the login page
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        // Session is valid, allow the request to proceed
        return true;
    }
}
