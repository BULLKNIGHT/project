package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

	private List<PlayerInformation> infoList= new ArrayList<PlayerInformation>(Arrays.asList(
			new PlayerInformation(1,"Rohit","Batsman"),
			new PlayerInformation(2,"Virat","Batsman"),
			new PlayerInformation(3,"Dhoni","Wicketkeeper"),
			new PlayerInformation(4,"jadega","Allrounder"),
			new PlayerInformation(5,"Bumrah","Bowler")
			));
	
	public List<PlayerInformation> getAllInfo()
	{
		return infoList;
	}
	
	public PlayerInformation getInfoByPid(int pid)
	{
		PlayerInformation player=new PlayerInformation();
		for(PlayerInformation o : infoList)
			if(o.getPid()==pid)
			{
				player=o;
				break;
			}
		return player;
	}
}