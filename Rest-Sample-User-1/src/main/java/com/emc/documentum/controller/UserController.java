package com.emc.documentum.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emc.documentum.model.UserModel;
import com.emc.documentum.wrappers.DCRestAPIWrapper;

@Controller
public class UserController {

	@Autowired
	DCRestAPIWrapper dcAPI;

	@RequestMapping("/getCurrentUser")
	public String getUser(Model model) {

		UserModel user = dcAPI.getUserInfo("dmadmin", "password");

		model.addAttribute("user", user);

		return "user";
	}

}
