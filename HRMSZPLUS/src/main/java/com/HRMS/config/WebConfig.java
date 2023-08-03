package com.HRMS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.HRMS.interceptor.SessionValidationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Create an instance of SessionValidationInterceptor
        SessionValidationInterceptor sessionValidationInterceptor = new SessionValidationInterceptor();

        // Add the custom interceptor and specify the URL patterns to apply it to
        registry.addInterceptor(sessionValidationInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login", "/logout", "/otp"); // Exclude login and logout URLs from session check
    }
}
