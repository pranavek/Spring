package com.prnv.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prnv.model.Stub;


@RestController
public class RootController {
	
	
	@RequestMapping(
			value="/{type}",produces={ MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody Stub index(@PathVariable("type") String type){
		System.out.println("Hello Pranav!");
		Stub s = new Stub();
		s.setName("Pranav");
		s.setValue(1);
		return s;
	}

	
	
	
	
}
