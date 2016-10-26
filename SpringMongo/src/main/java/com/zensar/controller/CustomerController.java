package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Customer;
import com.zensar.service.CustomerService;

/**
 * 
 * @author pranavek
 *
 */

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping("first/{firstName}")
	public Customer findCustomerByFirstName(@PathVariable("firstName") String firstName){
		return customerService.findByFirstName(firstName);
	}
	
	@RequestMapping("last/{lastName}")
	public List<Customer> findCustomerByLastName(@PathVariable("lastName") String lastName){
		return customerService.findByLastName(lastName);
	}
	
	
	

}
