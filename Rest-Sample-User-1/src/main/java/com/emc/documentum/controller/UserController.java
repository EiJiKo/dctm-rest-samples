package com.emc.documentum.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emc.documentum.model.UserModel;
import com.emc.documentum.wrappers.view.DocumentumAPIWrapper;

@Controller
public class UserController {

	@Inject
	DocumentumAPIWrapper dcAPI;

	@RequestMapping("/getCurrentUser")
	public String getUser(Model model) {

		UserModel user = dcAPI.getUserInfo("dmadmin", "password");

		model.addAttribute("user", user);

		return "user";
	}

}
