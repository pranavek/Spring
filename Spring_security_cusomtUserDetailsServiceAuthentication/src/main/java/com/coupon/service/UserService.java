package com.coupon.service;

import com.coupon.entity.User;

public interface UserService {
    User getUserByUsername(String username);  
}