package com.coupon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coupon.entity.CurrentUser;
import com.coupon.entity.User;
import com.coupon.service.UserService;

@Service
public class CurrentUserDetailsServiceImpl implements UserDetailsService {

	


	@Autowired
	private UserService userService;

	@Override
	public CurrentUser loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
        return new CurrentUser(user);
	}
	
}
