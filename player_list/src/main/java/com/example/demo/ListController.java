package com.example.demo;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ListController {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(groupKey="fallback",commandKey="fallback",fallbackMethod="hystrixFallBack")
	@RequestMapping("/info")
	public List<PlayerInformation> getAllPlayerInfo()
	{
		@SuppressWarnings("unchecked")
		List<PlayerInformation> playerList = restTemplate.getForObject("http://player-info-service/info", List.class);
		return playerList;
	}
	
	@RequestMapping("/info/{pid}")
	public PlayerInformation getPlayerInfo(@PathVariable int pid)
	{
		System.out.println("pid : "+pid);
		
		PlayerInformation player = restTemplate.getForObject("http://player-info-service/info/"+pid, PlayerInformation.class);
		System.out.println(player);
		return player;
		
	}
	
	
	@RequestMapping("/rating/{pid}")
	public PlayerRating getPlayerRating(@PathVariable("pid") int pid)
	{
		PlayerRating player=restTemplate.getForObject("http://player-rating-service/rating/"+pid, PlayerRating.class);
		return player;
	}
	
	public List<PlayerInformation> hystrixFallBack()
	{
		return Collections.emptyList();
	}

}
