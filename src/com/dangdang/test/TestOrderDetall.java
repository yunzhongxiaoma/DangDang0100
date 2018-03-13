package com.dangdang.test;

import org.junit.Test;

import com.dangdang.dao.OrderDetallDAO;
import com.dangdang.entity.OrderDetall;
import com.dangdang.util.MyBatisUtil;

public class TestOrderDetall {
	@Test
	public void testSave(){
		try {
			OrderDetallDAO odd = (OrderDetallDAO) MyBatisUtil.getMapper(OrderDetallDAO.class);
			//调用DAO层
			odd.save(new OrderDetall(1, 2, 100, 1, 22));
//					 new OrderDetall(id, number, total, orderid, gid)
			MyBatisUtil.commit();
		} catch (Exception e) {
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
		
	}
}
