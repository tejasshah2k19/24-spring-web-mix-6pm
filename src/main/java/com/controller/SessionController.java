package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	
	@GetMapping("/login")
	public String login(){
		return "Login";//jsp name no extension
	}
	
	@GetMapping("/signup")
	public String signup(){
		return "Signup";//jsp name 
	}
	
	@GetMapping("/fp")
	public String forgetPassword(){
		return "ForgetPassword";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(UserBean userBean,Model model) {
		 //read -> temp class-> bean  -> data set 
		System.out.println("firstName => "+userBean.getFirstName());
		System.out.println("email => "+userBean.getEmail());
		System.out.println("password => "+userBean.getPassword());
		 
		model.addAttribute("user",userBean);//dataName,dataValue
		//Model 
		return "Home";
	}
	
}





