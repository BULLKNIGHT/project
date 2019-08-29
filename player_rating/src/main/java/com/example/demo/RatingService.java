package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RatingService {
	
	private List<PlayerRating> ratingList= new ArrayList<PlayerRating>(Arrays.asList(
			new PlayerRating(1,8),
			new PlayerRating(2,9),
			new PlayerRating(3,10),
			new PlayerRating(4,8),
			new PlayerRating(5,9)
			));

	public List<PlayerRating> getAllRating()
	{
		return ratingList;
	}
	
	public PlayerRating getRatingByPid(int pid)
	{
		PlayerRating player=new PlayerRating();
		for(PlayerRating o : ratingList)
			if(o.getPid()==pid)
			{
				player=o;
				break;
			}
		return player;
		
	}
}
