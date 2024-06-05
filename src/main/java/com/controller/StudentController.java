package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBoxCricketBean;

@Controller
public class StudentController {

	@GetMapping("/boxcricketregistration")
	public String boxRegistration() {
		return "BoxCricketReg";// jsp name
	}

	@PostMapping("/savereg")
	public String saveRegistration(StudentBoxCricketBean studentBox, Model model) {
		// bean ->variable : jsp form
		System.out.println(studentBox.getStudentName());
		System.out.println(studentBox.getPlayerType());
		System.out.println(studentBox.getFoodPreference());
		System.out.println(studentBox.getDrink());

		boolean isError = false;
		String alphaRegEx = "[a-zA-Z]+";//a-zA-z ? min : 1 max : n time 
		
		
		if (studentBox.getStudentName() == null || studentBox.getStudentName().trim().length() == 0) {
			isError = true;
			model.addAttribute("studentNameError","Please Enter Student Name");
		}else if(studentBox.getStudentName().matches(alphaRegEx) == false) {
			isError = true; 
			model.addAttribute("studentNameError","Please Enter Valid Student Name");
		}else {
			model.addAttribute("studentNameValue",studentBox.getStudentName());
		}

		if (studentBox.getPlayerType() == null) {
			isError = true;
			model.addAttribute("playerTypeError","Please Select PlayerType");
		}

		if (studentBox.getFoodPreference().equals("-1") == true) {
			isError = true;
			model.addAttribute("foodPreferenceError","Please Selecct FoodPreference");
		}

		if (isError == true) {
			return "BoxCricketReg";
		} else {
			// how to send data to jsp from controller ?
			model.addAttribute("reg", studentBox);// data name -> data value
			return "RegDetail";
		}
	}

	// jsp open -> url -> Get mapping
	// jsp form ->data -> Post mapping

}
