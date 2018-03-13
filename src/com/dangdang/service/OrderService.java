package com.dangdang.service;

import com.dangdang.entity.BuyAddress;
import com.dangdang.entity.Order;
import com.dangdang.entity.User;
import com.dangdang.vo.Cart;

public interface OrderService {
	//地址入库、订单入库、订单项表入库
	public Order orderOrder(BuyAddress address, User user, Cart cart);
}
