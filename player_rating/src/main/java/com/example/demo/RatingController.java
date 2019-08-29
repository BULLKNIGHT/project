package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@RequestMapping("/rating")
	public List<PlayerRating> getAllRating()
	{
		return ratingService.getAllRating();
	}
	
	@RequestMapping("/rating/{pid}")
	public PlayerRating getRatingByPid(@PathVariable("pid") int pid)
	{
		return ratingService.getRatingByPid(pid);
	}
}
