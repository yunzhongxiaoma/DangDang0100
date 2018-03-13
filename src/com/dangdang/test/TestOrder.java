package com.dangdang.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import com.dangdang.dao.AddressDAO;
import com.dangdang.dao.OrderDAO;
import com.dangdang.entity.BuyAddress;
import com.dangdang.entity.Order;
import com.dangdang.entity.User;
import com.dangdang.util.MyBatisUtil;

public class TestOrder {
	@Test
	public void testSave(){
		try {
			OrderDAO ad = (OrderDAO) MyBatisUtil.getMapper(OrderDAO.class);
			//订单号创建
			Date date=new Date();
			String createTime = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
			String onumber = createTime + UUID.randomUUID().toString();
			//调用DAO层
			ad.save(new Order(null, 23, 1, onumber, new User(), 1, 1, new BuyAddress()));
//			new Order(orderId, totalprice, uid, onumber, user, orderstatus, addrId, address)
			MyBatisUtil.commit();
		} catch (Exception e) {
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
		
	}
}
