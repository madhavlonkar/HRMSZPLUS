package com.HRMS.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionValidationInterceptor extends WebRequestHandlerInterceptorAdapter {

    public SessionValidationInterceptor(WebRequestInterceptor requestInterceptor) {
		super(requestInterceptor);
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Check if the session is still valid   FinalloggedInUsername
        if (request.getSession().getAttribute("FinalloggedInUsername") == null) {
            // Session is expired or not present, redirect to the login page
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        // Session is valid, allow the request to proceed
        return true;
    }
}
