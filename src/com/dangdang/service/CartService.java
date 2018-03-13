package com.dangdang.service;


import java.util.List;

import com.dangdang.vo.Cart;

public interface CartService {
   //添加购物车
	public Cart addCart(Integer GID,Cart oldCart);
	//修改购物车
	public Cart updateCart(Integer GID,Integer count,Cart oldCart);
	//删除购物车
	public List<Cart> deleteCart(Integer GID,Cart oldCart,Cart deleteCart);
	//恢复购物车
	public List<Cart> recoverCart(Integer GID,Cart oldCart,Cart deleteCart);
}
