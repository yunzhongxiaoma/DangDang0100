package com.dangdang.dao;

import com.dangdang.entity.Order;

public interface OrderDAO {
	// 订单入库
	public void save(Order order);
}
