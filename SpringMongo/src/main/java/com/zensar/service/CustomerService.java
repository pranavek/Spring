package com.zensar.service;

import java.util.List;

import com.zensar.model.Customer;

/**
 * 
 * @author pranavek
 *
 */

public interface CustomerService {
	
	public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
