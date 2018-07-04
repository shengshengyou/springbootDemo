package com.example.demo.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back/userinfo/")
public class UserInfoController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("main")
	public String main() {
		return "main";
	}
}
