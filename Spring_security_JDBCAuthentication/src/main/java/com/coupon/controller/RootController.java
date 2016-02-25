package com.coupon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping("/")
	 String rootMapping(){
		return "index";
	}
	
	@RequestMapping("/login")
	 String login(){
		return "login";
	}
	
}
