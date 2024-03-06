package com.HRMS.audit;


import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class HRMSInfo implements InfoContributor{
	
	@Override
	 public void contribute(Info.Builder builder) {
        Map<String, String> hrmsMap = new HashMap<String, String>();
        hrmsMap.put("App Name", "HRMS");
        hrmsMap.put("App Description", "Human Resource Management System");
        hrmsMap.put("Version", "1.0.0");
        hrmsMap.put("Contact Email", "gururajyadav.07@gmail.com");
        hrmsMap.put("Contact Mobile", "+9637439059");
        builder.withDetail("HRMS-info", hrmsMap);
    }	

}