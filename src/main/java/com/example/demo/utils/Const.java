package com.example.demo.utils;

/**
 * 常量类
 * @author Administrator
 *
 */
public class Const {
	/**
	 * 每页记录数
	 */
	public static final int PAGE_SIZE = 2;
	
	/**
	 * 用户类型：顾客
	 */
	public static final int USER_TYPE_CUSTOMER = 1;
	
	/**
	 * 用户类型：卖家
	 */
	public static final int USER_TYPE_ADMIN = 2;
	/**
	 * 文件服务器的地址
	 */
	public static final String FILE_SERVER_URL = "http://localhost:8080/file_server/upload/";
	/**
	 * 商品初始化状态
	 */
	public static final String GOODS_STATE_INIT = "1";
	/**
	 * 商品上架状态
	 */
	public static final String GOODS_STATE_UP = "2";
	/**
	 * 商品下架状态
	 */
	public static final String GOODS_STATE_DOWN = "3";
}
