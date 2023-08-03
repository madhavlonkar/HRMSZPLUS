package com.HRMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRMS.model.HolidayMaster;
import com.HRMS.service.HolidayService;




@Controller
public class HolidayController {
	
	
	
	private static final Logger log = LoggerFactory.getLogger(HolidayController.class);

	
	@Autowired
	private HolidayService holidayService;
	
	@GetMapping("/holidays")
	public String getHolidays(Model model) {
		
		List<HolidayMaster> holidays = holidayService.getAllHolidays();
		if(holidays.isEmpty())
		{
			log.error("NO Holiday Avilable To Retrieve");
			return "/Holiday/HolidayMaintenance";
		}
		model.addAttribute("holidays",holidays);
		return "/Holiday/HolidayMaintenance";
		
	}
	
	@GetMapping("/holidays/new")
	public String createHolidayForm(Model model)
	{
		return null;
         
	}
	
	@PostMapping("/holidays")
	public String addHoliday(@ModelAttribute("holiday") HolidayMaster holidaymaster) {
		
		HolidayMaster holiday = holidayService.saveHoliday(holidaymaster);
		if(holiday == null)
		{
			log.error("Unable to Save Data");
			return "redirect:/holidays";
		}
		
		return "redirect:/holidays";
	}
	
}
