package com.example.microserviceRegistration.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.microserviceRegistration.model.UserList;


@Controller
public class BootController {



	@RequestMapping("/registration")
	public String register(Model model, UserList userList) {
		model.addAttribute("userList", userList);
		return "registration";

	}

	@RequestMapping("/save")
	public String save(UserList userList) {
		return "login";

	}

	@RequestMapping("/login")
	public ModelAndView log(Model model, UserList userList) {
		model.addAttribute("userList", userList);
		return new ModelAndView("redirect:" + "http://localhost:9192/login");
		

	}

	



}
