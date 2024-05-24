package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

	
	@GetMapping("/login")
	public String login(){
		return "Login.jsp";
	}
	
	@GetMapping("/signup")
	public String signup(){
		return "Signup.jsp";
	}
	
	@GetMapping("/fp")
	public String forgetPassword(){
		return "ForgetPassword.jsp";
	}
	
}
