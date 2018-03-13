package com.dangdang.dao;

import com.dangdang.entity.Order;
import com.dangdang.entity.OrderDetall;

public interface OrderDetallDAO {
	// 订单项表入库
	public void save(OrderDetall orderDetall);
}
