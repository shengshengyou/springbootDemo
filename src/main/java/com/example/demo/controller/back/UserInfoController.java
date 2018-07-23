package com.example.demo.controller.back;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping("importusers")
	public String importUsers(@RequestParam MultipartFile users,Model model) {
		System.out.println("users = " + users);
		try {
			userInfoService.addUsers(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list(new UserInfo(),model,1);
	}
	
	@RequestMapping("exportusers")
	public String exportUsers(UserInfo userInfo,HttpServletResponse response){
		PageBean<UserInfo> pageBean = userInfoService.getUserInfoList(userInfo, -1);//不分页
		List<UserInfo> users = pageBean.getList();
		try {
			File file = userInfoService.createDownloadFile(users);
			FileInputStream fis = new FileInputStream(file);
			response.setContentType("application/force-download");
			response.addHeader("Content-disposition", "attachment;fileName=users-export.xls");//设置下载的文件名
			OutputStream os = response.getOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = fis.read(buf)) != -1){
				os.write(buf, 0, len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/*
	 * 加载添加用户的页面
	 */
	@RequestMapping("loadadd")
	public String loadAdd() {
		return "back/userinfo/userinfo_add";
	}
	
	@RequestMapping("add")
	public String add(UserInfo userInfo,Model model){
		try {
			userInfoService.addUserInfo(userInfo);
			model.addAttribute("result", "添加用户成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "添加用户失败");
		}
		return "back/userinfo/userinfo_info";
	}
	
	/**
	 * 验证用户账号唯一
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("validatephone")
	@ResponseBody
	public String validatePhone(UserInfo userInfo){
		boolean flag = userInfoService.validatePhone(userInfo);
		if(flag){
			return "ok";
		}else{
			return "not ok";
		}
	}
	
	/**
	 * 加载待修改的用户信息
	 * @param userInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate")
	public String loadUpdate(UserInfo userInfo ,Model model){
		UserInfo puser = userInfoService.loadUpdateUserInfo(userInfo);
		model.addAttribute("userinfo", puser);
		return "back/userinfo/userinfo_update";
	}
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String updateUserInfo(UserInfo userInfo,Model model){
		try {
			userInfoService.updateUserInfo(userInfo);
			model.addAttribute("result", "修改用户信息成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("result", "修改用户信息失败");
		}
		return "back/userinfo/userinfo_info";
	}
	
	/**
	 * 删除用户信息
	 * @param userInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("delete")
	public String deleteUserInfo(UserInfo userInfo,Model model){
		try {
			userInfoService.deleteUserInfo(userInfo);
			model.addAttribute("result", "删除用户信息成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("result", "删除用户信息失败");
		}
		return "back/userinfo/userinfo_info";
	}
}
