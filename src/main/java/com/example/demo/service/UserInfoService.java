package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.utils.PageBean;

/*
 * 用户管理的核心业务接口
 */
public interface UserInfoService {
	public void insertUserInfo(User userInfo);
	public void insertUserInfo1(User userInfo);
	
	/**
	 * 根据条件/分页信息查询用户数据
	 * @return
	 */
	public PageBean<UserInfo> getUserInfoList(UserInfo userInfo,Integer page);
	
	/**
	 * 根据条件查询用户记录数
	 * @param userInfo
	 * @return
	 */
	public Long getUserInfoCount(UserInfo userInfo);
}
