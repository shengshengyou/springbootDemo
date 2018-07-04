package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperInfoTest {
	
	@Autowired
	private UserInfoMapper1 userInfoMapper1;
	
	@Test
	public void testGetUserInfoList() {
		UserInfo userInfo=new UserInfo();
		userInfo.setStart(1);
		userInfo.setLength(3);
		
		List<UserInfo> users=userInfoMapper1.getUserInfoList(userInfo);
		for(UserInfo u:users ) {
			System.out.println("u.name="+u.getUserName());
		}
	}
	
	@Test
	public void testGetUserInfoCount() {
		UserInfo userInfo=new UserInfo();
		userInfo.setStart(1);
		userInfo.setLength(3);
		userInfo.setUserName("张");
		
		Long count=userInfoMapper1.getUserInfoCount(userInfo);
		System.out.println("count="+count);
	}
}
