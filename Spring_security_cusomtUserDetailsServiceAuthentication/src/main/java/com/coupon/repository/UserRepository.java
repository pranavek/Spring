package com.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coupon.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
