package com.example.demo.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.PageBean;

/*
 * 后台用户管理的核心控制器
 */
@Controller
@RequestMapping("/back/userinfo/")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 显示主页
	 */
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	/*
	 * 显示主页的main
	 */
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	/*
	 * 根据分页和条件查询用户信息
	 */
	@RequestMapping("list")
	public String list(UserInfo userInfo,Model model,Integer page) {
		PageBean<UserInfo> pageBean=userInfoService.getUserInfoList(userInfo, page);
		model.addAttribute("pageBean", pageBean);
		return "back/userinfo/userinfo_list";
	}
}
