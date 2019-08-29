package com.example.demo;

public class PlayerInformation {

	private int pid;
	private String pname;
	private String desc;
	
	
	public PlayerInformation() {
		super();
	}
	public PlayerInformation(int pid, String pname, String desc) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.desc = desc;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "PlayerInformation [pid=" + pid + ", pname=" + pname + ", desc=" + desc + "]";
	}
	
	
	
	
	
}
