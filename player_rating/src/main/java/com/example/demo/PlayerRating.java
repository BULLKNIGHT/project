package com.example.demo;

public class PlayerRating {
	
	private int pid;
	private int rating;
	
	public PlayerRating() {
		super();
	}

	public PlayerRating(int pid, int rating) {
		super();
		this.pid = pid;
		this.rating = rating;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
