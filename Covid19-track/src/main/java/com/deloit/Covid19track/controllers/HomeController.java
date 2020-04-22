package com.deloit.Covid19track.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deloit.Covid19track.Services.Covid19DataService;
import com.deloit.Covid19track.models.LocationStats;

@Controller
public class HomeController {
	
	@Autowired
	Covid19DataService covid19DataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = covid19DataService.getAllStats();
		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPreDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalCases);
		model.addAttribute("newCases", totalNewCases);
		return "home";
	}

}
