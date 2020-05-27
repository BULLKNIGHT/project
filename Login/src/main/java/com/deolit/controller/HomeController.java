package com.deolit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deolit.dao.UserRepo;
import com.deolit.model.User;

@Controller
public class HomeController {
	
	@Autowired
	UserRepo repo; 

	@RequestMapping("/")
	public String home() {
		return "Login";
	}
	
	@RequestMapping(value="/check", method=RequestMethod.GET)
	public String check(@RequestParam(value= "userName") String username, @RequestParam(value="password") String password) {
		User user = repo.findById(username).orElse(null);
		if(user == null)
			return "error";
		//System.out.println(user + " " + password);
		if(user.getPassword().equals(password))
			return "Welcome";
		else return "error";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute(name="user") User user, Model model) {
		User other = repo.findById(user.getUserName()).orElse(null);
		if(other == null) {
			repo.save(user);
			return "Login";
		}
		else return "error";
		
	}
}
