package com.dangdang.vo;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, OrderItem> cartMap = new HashMap<Integer, OrderItem>();
	private double totalprice;
	private double saveMoney;

	public Map<Integer, OrderItem> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<Integer, OrderItem> cartMap) {
		this.cartMap = cartMap;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public double getSaveMoney() {
		return saveMoney;
	}

	public void setSaveMoney(double saveMoney) {
		this.saveMoney = saveMoney;
	}

	public Cart(Map<Integer, OrderItem> cartMap, double totalprice,
			double saveMoney) {
		super();
		this.cartMap = cartMap;
		this.totalprice = totalprice;
		this.saveMoney = saveMoney;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [cartMap=" + cartMap + ", totalprice=" + totalprice
				+ ", saveMoney=" + saveMoney + "]";
	}

}
