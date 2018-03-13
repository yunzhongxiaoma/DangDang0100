package com.dangdang.entity;

public class OrderDetall {
	private Integer id;
	private Integer number;
	//小计，相当CartItem的smallprice
	private double total;
	private Integer orderid;
	private Integer gid;
	
	public OrderDetall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetall(Integer id, Integer number, double total,
			Integer orderid, Integer gid) {
		super();
		this.id = id;
		this.number = number;
		this.total = total;
		this.orderid = orderid;
		this.gid = gid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	@Override
	public String toString() {
		return "OrderDetall [id=" + id + ", number=" + number + ", total="
				+ total + ", orderid=" + orderid + ", gid=" + gid + "]";
	}
	
	
}
