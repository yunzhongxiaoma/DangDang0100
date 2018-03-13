package com.dangdang.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.dangdang.dao.AddressDAO;
import com.dangdang.dao.OrderDAO;
import com.dangdang.dao.OrderDetallDAO;
import com.dangdang.entity.BuyAddress;
import com.dangdang.entity.Order;
import com.dangdang.entity.OrderDetall;
import com.dangdang.entity.User;
import com.dangdang.util.MyBatisUtil;
import com.dangdang.vo.Cart;
import com.dangdang.vo.OrderItem;

public class OrderServiceImpl implements OrderService{
	
	//地址入库、订单入库、订单项表入库
	@Override
	public Order orderOrder(BuyAddress address, User user, Cart cart) {
		try {
			//地址入库
			address.setuId(user.getId());
			address.setAddrstatus(0);
			address.setIsDefault(0);
			//把User对象存放在Buyaddress
			address.setUser(user);
			
			AddressDAO ad = (AddressDAO) MyBatisUtil.getMapper(AddressDAO.class);
			ad.save(address);
			
			MyBatisUtil.commitForce();
			MyBatisUtil.closeSqlSession();
		} catch (Exception e) {
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
		
		//订单入库
		Order order = null;
		try {
			//生成订单号onumber
			Date date=new Date();
			String createTime=new SimpleDateFormat("yyyyMMddHHmmss").format(date);
			String onumber = createTime + UUID.randomUUID().toString();
			//把User对象、Buyaddress对象存放在Order对象里
			order = new Order(null, cart.getTotalprice(), user.getId(), onumber, user, 1, address.getAddrId()+1, address);
			//			  new Order(orderId, totalprice, uid, onumber, user, orderstatus, addrId, address)
			OrderDAO od = (OrderDAO) MyBatisUtil.getMapper(OrderDAO.class);
			od.save(order);
			
			MyBatisUtil.commitForce();
			MyBatisUtil.closeSqlSession();
		} catch (Exception e) {
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
		
		//订单项表入库
		OrderDetallDAO odd = (OrderDetallDAO) MyBatisUtil.getMapper(OrderDetallDAO.class);
		try {
			Set<Integer> keySet = cart.getCartMap().keySet();
			//遍历cartMap
			for (Integer key:keySet) {
//				System.out.println(key);  
				OrderItem orderItem = cart.getCartMap().get(key);
				
				OrderDetall orderDetall = new OrderDetall();
				
				orderDetall.setNumber(orderItem.getAmount());
				orderDetall.setTotal(orderItem.getSmallprice());
				orderDetall.setOrderid(order.getOrderId());
				orderDetall.setGid(orderItem.getGoods().getGID());
				//调用DAO层
				odd.save(orderDetall);
			} 	
			MyBatisUtil.commit();
			MyBatisUtil.closeSqlSession();
		} catch (Exception e) {
			MyBatisUtil.rollback();
			e.printStackTrace();
		}

		return order;
	}
	
}
