package com.dangdang.dao;

import com.dangdang.entity.BuyAddress;

public interface AddressDAO {
	// 地址入库
	public void save(BuyAddress address);
}
