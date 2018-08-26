package com.example.demo.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.GoodsInfoService;

/*
 * 商品管理的控制器
 */
@Controller
@RequestMapping("/back/goodsinfo/")
public class GoodsInfoController {

	@Autowired
	private GoodsInfoService goodsInfoService;
	
	@RequestMapping("loadadd")
	public String loadAdd(){
		return "back/goodsinfo/goodsinfo_add";
	}
	
	/**
	 * 上传商品预览图片
	 * @return
	 */
	@RequestMapping("uploadimg")
	public @ResponseBody String uploadImg(@RequestParam MultipartFile upload){
		//System.out.println("upload = " + upload);
		String url = goodsInfoService.doPutToFileServer(upload);
		return url;
	}
}
