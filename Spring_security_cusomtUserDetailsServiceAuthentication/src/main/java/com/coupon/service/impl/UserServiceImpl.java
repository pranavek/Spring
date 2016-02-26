package com.coupon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.entity.User;
import com.coupon.repository.UserRepository;
import com.coupon.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
    public User getUserByUsername(String username) {        
        return (User)userRepository.findByUsername(username);
    }

}
