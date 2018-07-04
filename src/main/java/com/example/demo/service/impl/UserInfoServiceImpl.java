package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoMapper;
import com.example.demo.dao.UserInfoMapper1;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.Const;
import com.example.demo.utils.PageBean;
import com.example.demo.utils.PageUtil;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserInfoMapper1 userInfoMapper1;
	
	@Override
	public void insertUserInfo(User userInfo) {
		userInfoMapper.insertUserInfo(userInfo);
	}

	@Override
	public void insertUserInfo1(User userInfo) {
		userInfoMapper1.insertUserInfo(userInfo);
	}

	@Override
	public PageBean<UserInfo> getUserInfoList(UserInfo userInfo, Integer page) {
		int allRow = getUserInfoCount(userInfo).intValue();//总记录数
		int totalPage = PageUtil.countTotalPage(allRow, Const.PAGE_SIZE);//总页数
		int currentPage = PageUtil.countCurrentPage(page);//当前第几页
		int start = PageUtil.countStart(Const.PAGE_SIZE, currentPage);//起始记录数
		if(page >= 0){
			userInfo.setStart(start);//起始记录数
			userInfo.setLength(Const.PAGE_SIZE);//每页显示的记录数
		}else{
			userInfo.setStart(-1);//不分页
			userInfo.setLength(-1);//不分页
		}
		List<UserInfo> users = userInfoMapper1.getUserInfoList(userInfo);//记录集合
		
		PageBean<UserInfo> pageBean = new PageBean<>();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(users);
		pageBean.setPageSize(Const.PAGE_SIZE);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public Long getUserInfoCount(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper1.getUserInfoCount(userInfo);
	}
}
