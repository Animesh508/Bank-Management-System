package com.bankmanagmentsystem.www.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {
	
	public String welcome(@RequestParam(name = "customer", required= false, defaultValue = "(customer)") String customer, Model model){
		model.addAttribute("customer", customer);
		return "welcome";
	}

}
