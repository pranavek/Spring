package com.coupon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coupon.config.CouponApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CouponApplication.class)
@WebAppConfiguration
public class CouponApplicationTests {

	@Test
	public void contextLoads() {
	}

}
