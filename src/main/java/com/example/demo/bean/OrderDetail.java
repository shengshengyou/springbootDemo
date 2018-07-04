package com.example.demo.bean;

/**
 * 订单明细类
 * 
 * @author Administrator
 *
 */
public class OrderDetail {

	/**
	 * 订单明细ID
	 */
	private Integer orderDetailId;

	private Integer orderId;

	private Integer goodsId;

	private Integer ordeNumber;
	
	private Double everyTotal;

	public Double getEveryTotal() {
		return everyTotal;
	}

	public void setEveryTotal(Double everyTotal) {
		this.everyTotal = everyTotal;
	}

	/**
	 * 商品价格
	 */
	private String orderPrice;

	public String goodsName;

	private String goodsUrl;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsUrl() {
		return goodsUrl;
	}

	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getOrdeNumber() {
		return ordeNumber;
	}

	public void setOrdeNumber(Integer ordeNumber) {
		this.ordeNumber = ordeNumber;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

}
