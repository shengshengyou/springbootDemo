package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface GoodsInfoService {
	/**
	 * 向文件服务器发送图片
	 * @param file
	 * @return 返回地址
	 */
	public String doPutToFileServer(MultipartFile file);
}
