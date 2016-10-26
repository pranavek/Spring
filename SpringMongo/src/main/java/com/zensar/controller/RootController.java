package com.zensar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author pranavek
 *
 */

@RestController
public class RootController {

	@RequestMapping("/")
	public String index(){
		return "Hello World!";
	}
	
	
}
