package com.example.demo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.UserInfo;
import com.example.demo.utils.PageBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {
	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void getUserInfoListTest(){
		UserInfo user = new UserInfo();
		user.setUserName("张");
		//user.setUserPhone("10");
		int page = 0;
		
		PageBean<UserInfo> pageBean = userInfoService.getUserInfoList(user, page);
		System.out.println("当前共有" + pageBean.getAllRow() + "条记录");
		System.out.println("当前是第" + pageBean.getCurrentPage() + "页");
		System.out.println("总共有" + pageBean.getTotalPage() + "页");
		
		List<UserInfo> users = pageBean.getList();
		for(UserInfo userInfo : users){
			System.out.println("userinfo.name = " + userInfo.getUserName());
		}
	}
}
