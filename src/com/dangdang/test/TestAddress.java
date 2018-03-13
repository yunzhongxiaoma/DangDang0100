package com.dangdang.test;

import org.junit.Test;

import com.dangdang.dao.AddressDAO;
import com.dangdang.entity.BuyAddress;
import com.dangdang.entity.User;
import com.dangdang.util.MyBatisUtil;

public class TestAddress {
	@Test
	public void testSave(){
		try {
			AddressDAO ad = (AddressDAO) MyBatisUtil.getMapper(AddressDAO.class);
			User u = new User("erw", "sdf", "ds", 0);
			ad.save(new BuyAddress("ZhangSir", "河南郑州金水区文化路欣欣小区", "450000", "16634323224", "16634323224", 0, 0, 75, u));
//					new BuyAddress(username, posthome, postcode, telephone, mobilephone, addrstatus, isDefault, uId, user)
			//未实现
//			ad.save(new BuyAddress("ZhangSir", null, "450000", "16634323224", "16634323224", 0, 75));
			MyBatisUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
	}
}
