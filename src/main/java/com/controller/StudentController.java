package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBoxCricketBean;

@Controller
public class StudentController {

	
	@GetMapping("/boxcricketregistration")
	public String boxRegistration() {
		return "BoxCricketReg";//jsp name 
	}
	
	@PostMapping("/savereg")
	public String saveRegistration(StudentBoxCricketBean studentBox) {
			//bean ->variable : jsp form 
		System.out.println(studentBox.getStudentName());
		System.out.println(studentBox.getPlayerType());
		System.out.println(studentBox.getFoodPreference());
		System.out.println(studentBox.getDrink());

		return "Home";
	}

}
