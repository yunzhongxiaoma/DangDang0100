package com.dangdang.action;

import com.dangdang.entity.BuyAddress;
import com.dangdang.entity.Order;
import com.dangdang.entity.User;
import com.dangdang.service.OrderService;
import com.dangdang.service.OrderServiceImpl;
import com.dangdang.util.Struts2ScopeUtil;
import com.dangdang.vo.Cart;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private BuyAddress address;
	//确认订单信息
	public String confirmOrder() {
		return "address";
	}
	
	//创建订单
	public String createOrder() {
		User user = (User) Struts2ScopeUtil.getSessionAttribute("user");
		Cart cart = (Cart) Struts2ScopeUtil.getSessionAttribute("Cart");
		OrderService os = new OrderServiceImpl();
		//调用service层方法
		Order order = os.orderOrder(address,user,cart);
		
		cart = null;
		Struts2ScopeUtil.setSessionAttribute("cart", cart);
		Struts2ScopeUtil.setSessionAttribute("order", order);
		return "orderOk";
	}

	
	/*----------getter/setter-------------*/
	public BuyAddress getAddress() {
		return address;
	}

	public void setAddress(BuyAddress address) {
		this.address = address;
	}
}
