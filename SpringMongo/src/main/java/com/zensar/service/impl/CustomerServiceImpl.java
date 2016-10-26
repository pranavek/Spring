package com.zensar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Customer;
import com.zensar.repository.CustomerRepository;
import com.zensar.service.CustomerService;

/**
 * 
 * @author pranavek
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Customer findByFirstName(String firstName) {
		return customerRepo.findByFirstName(firstName);
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		return customerRepo.findByLastName(lastName);
		
	}

}
