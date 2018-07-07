package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.User;

@Mapper
public interface UserInfoMapper {
	
	@Insert(value ="insert into userinfo(name) values(#{name})")
	public void insertUserInfo(User userInfo);
	
}

