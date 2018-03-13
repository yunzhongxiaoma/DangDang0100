package com.dangdang.vo;

import com.dangdang.entity.Goods;

//购物车项
public class OrderItem {
	private Goods  goods;
	private Integer amount;
	private double smallprice;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public double getSmallprice() {
		return smallprice;
	}

	public void setSmallprice(double smallprice) {
		this.smallprice = smallprice;
	}

	public OrderItem(Goods goods, Integer amount, double smallprice) {
		super();
		this.goods = goods;
		this.amount = amount;
		this.smallprice = smallprice;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CartItem [goods=" + goods + ", amount=" + amount
				+ ", smallprice=" + smallprice + "]";
	}

}
