package com.dangdang.entity;

public class Order {
	private Integer orderId;
	private double totalprice;
	private Integer uid;
	private String onumber;
	private User user;
	//订单状态，0交易成功，1交易未成功
	private Integer orderstatus;
	private Integer addrId;
	private BuyAddress address;
	
	public Order() {
		super();
	}


	public Order(Integer orderId, double totalprice, Integer uid,
			String onumber, User user, Integer orderstatus, Integer addrId,
			BuyAddress address) {
		super();
		this.orderId = orderId;
		this.totalprice = totalprice;
		this.uid = uid;
		this.onumber = onumber;
		this.user = user;
		this.orderstatus = orderstatus;
		this.addrId = addrId;
		this.address = address;
	}


	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getOnumber() {
		return onumber;
	}

	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public BuyAddress getAddress() {
		return address;
	}

	public void setAddress(BuyAddress address) {
		this.address = address;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalprice=" + totalprice
				+ ", uid=" + uid + ", onumber=" + onumber + ", user=" + user
				+ ", orderstatus=" + orderstatus + ", addrId=" + addrId
				+ ", address=" + address + "]";
	}

	
	
}
