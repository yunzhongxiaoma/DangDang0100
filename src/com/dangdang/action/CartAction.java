package com.dangdang.action;

import java.util.List;

import com.dangdang.service.CartService;
import com.dangdang.service.CartServiceImpl;
import com.dangdang.util.Struts2ScopeUtil;
import com.dangdang.vo.Cart;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	// 接收参数
	private Integer GID;
	private String amount;
	
	// 添加购物车
	public String addCart() {
		// 获取旧的购物车
		Cart oldCart = (Cart) Struts2ScopeUtil.getSessionAttribute("Cart");
		if (oldCart == null) {
			oldCart = new Cart();
		}
		// 调用添加购物车的业务
		CartService cs = new CartServiceImpl();
		Cart newCart = cs.addCart(GID, oldCart);
		Struts2ScopeUtil.setSessionAttribute("Cart", newCart);
		return "cartlist";
	}
	
	//修改购物车商品数量
	public String modifyCart(){
		// 获取旧的购物车
		Cart oldCart = (Cart) Struts2ScopeUtil.getSessionAttribute("Cart");
		if (oldCart == null) {
			oldCart = new Cart();
		}
		// 调用修改购物车的业务
		CartService cs = new CartServiceImpl();
		Integer count = Integer.valueOf(amount);
		Cart newCart = cs.updateCart(GID, count, oldCart);
		Struts2ScopeUtil.setSessionAttribute("Cart", newCart);
		return "cartlist";
	}
	
	//删除购物车项
	public String deleteCart(){
		// 获取旧的购物车
		Cart oldCart = (Cart) Struts2ScopeUtil.getSessionAttribute("Cart");
		if (oldCart == null) {
			oldCart = new Cart();
		}
		//获取旧的恢复购物车
		Cart deleteCart = (Cart) Struts2ScopeUtil.getSessionAttribute("deleteCart");
		if (deleteCart == null) {
			deleteCart = new Cart();
		}
		// 调用删除购物车项的业务
		CartService cs = new CartServiceImpl();
		List<Cart> cartList = cs.deleteCart(GID, oldCart, deleteCart);
		Struts2ScopeUtil.setSessionAttribute("Cart", cartList.get(0));
		Struts2ScopeUtil.setSessionAttribute("deleteCart",  cartList.get(1));
		return "cartlist";
	}
	
	//恢复购物车项 
	public String recoverCart(){
		// 获取旧的购物车
		Cart oldCart = (Cart) Struts2ScopeUtil.getSessionAttribute("Cart");
		if (oldCart == null) {
			oldCart = new Cart();
		}
		//获取旧的恢复购物车
		Cart deleteCart = (Cart) Struts2ScopeUtil.getSessionAttribute("deleteCart");
		if (deleteCart == null) {
			deleteCart = new Cart();
		}
		// 调用恢复购物车项的业务
		CartService cs = new CartServiceImpl();
		List<Cart> cartList = cs.recoverCart(GID, oldCart, deleteCart);
		Struts2ScopeUtil.setSessionAttribute("Cart", cartList.get(0));
		Struts2ScopeUtil.setSessionAttribute("deleteCart",  cartList.get(1));
		return "cartlist";
	}
	
	/*----------getter/setter-------------*/

	public Integer getGID() {
		return GID;
	}

	public void setGID(Integer gID) {
		GID = gID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
