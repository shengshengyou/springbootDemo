package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.User;
import com.example.demo.service.UserInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShopApplicationTests {

	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testInsertInfo() {
		User userInfo=new User();
		userInfo.setName("张三");
		
		userInfoService.insertUserInfo(userInfo);
	}
	
	@Test
	public void testInsertInfo1() {
		User userInfo=new User();
		userInfo.setName("赵五");
		
		userInfoService.insertUserInfo1(userInfo);
	}
}
