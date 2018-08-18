package com.example.demo.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 商品管理的控制器
 */
@Controller
@RequestMapping("/back/goodsinfo/")
public class GoodsInfoController {

	@RequestMapping("loadadd")
	public String loadAdd(){
		return "back/goodsinfo/goodsinfo_add";
	}
	
	
}
