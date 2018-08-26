package com.example.demo.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	
	/*
	 * 解析文件，批量添加用户
	 */
	public void addUsers(MultipartFile users) throws Exception;
	
	/*
	 * 生成带下载的excel文件
	 */
	public File createDownloadFile(List<UserInfo> users) throws Exception;
	
	
	/*
	 * 添加用户信息
	 */
	public void addUserInfo(UserInfo userInfo) throws Exception;
	
	/*
	 * 验证唯一性
	 */
	public boolean validatePhone(UserInfo userInfo);
	/*
	 * 加载用户信息更新页面
	 */
	public UserInfo loadUpdateUserInfo(UserInfo userInfo);
	
	/*
	 * 更新用户信息
	 */
	public void updateUserInfo(UserInfo userInfo) throws Exception;
	
	/*
	 * 删除用户信息
	 */
	public void deleteUserInfo(UserInfo userInfo) throws Exception;
}
