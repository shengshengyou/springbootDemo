package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.junit.validator.PublicClassValidator;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;

import com.example.demo.bean.User;
import com.example.demo.bean.*;

/*
 * 基于配置的方式
 */
@Mapper
public interface UserInfoMapper1 {
	
	/*
	 * 添加用户,测试用
	 */
	public void insertUserInfo(User userInfo);
	
	/*
	 * 根据分页/条件查询用户信息
	 */
	public List<UserInfo> getUserInfoList(UserInfo userInfo);
	
	/*
	 * 根据条件查询用户总数
	 */
	public Long getUserInfoCount(UserInfo userInfo);
	
	
	/*
	 * 添加用户
	 */
	public void addUserInfo(UserInfo userInfo);
	
	/**
	 * 根据条件查询用户信息
	 * @param userInfo
	 */
	public UserInfo getUserInfo(UserInfo userInfo);
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 */
	public void updateUserInfo(UserInfo userInfo);
	
	/**
	 * 删除用户信息
	 * @param userInfo
	 */
	public void deleteUserInfo(UserInfo userInfo);
}

