package com.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EUserBean;
import com.dao.EUserDao;
import com.service.FileUploadService;

@Controller
public class EcomSessionController {

	@Autowired
	EUserDao userDao;

	@Autowired
	FileUploadService fileUploadService;

	@GetMapping("/")
	public String welcome() {
		return "EcomLogin";
	}

	@GetMapping("/esignup")
	public String signup() {
		return "EcomSignup";
	}

	@PostMapping("/esignup")
	public String signupPost(EUserBean userBean) {
		// jsp form -> controller ->
		// validation

		fileUploadService.uploadUserImage(userBean.getProfilePic(), userBean.getEmail());

		// images//profilepic//rock1@gmail.com//123.png

		userBean.setProfilePicPath(
				"images//profilepic//" + userBean.getEmail() + "//" + userBean.getProfilePic().getOriginalFilename());
		// insert
		userDao.insertUser(userBean);
		// image server upload
		// id

		// profilepic/jack@gmai.com/timestamp_aa.jpg

		// profilepic/0522461526122aa.jpg
		// profilepic/0522461527122aa.jpg

		return "EcomLogin";
	}
}
