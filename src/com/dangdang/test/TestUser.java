package com.dangdang.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.dangdang.dao.UserDAO;
import com.dangdang.entity.User;
import com.dangdang.util.MyBatisUtil;


public class TestUser {
	@Test
	public  void   testLogin(){
		UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
		User user = ud.queryUserEmailAndPassword("111@qq.com", "111");
		System.out.println(user);
		MyBatisUtil.closeSqlSession();
//		User [id=1, email=111@qq.com, nickname=jack, password=111, accountstate=0]
	}
	
	@Test
	public void testregister() {
		try{
			UserDAO  ud = (UserDAO)MyBatisUtil.getMapper(UserDAO.class);
			//调用DAO	
			ud.save(new User("sdfe@qq.com", "王波", "111", 1));
			//控制事务
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryUserByEmail() {
			UserDAO  ud = (UserDAO)MyBatisUtil.getMapper(UserDAO.class);
			//调用DAO	
			User user = ud.queryUserById(1);
			System.out.println(user);
	}
	
	@Test
	public void testUpdate() {
		try{
			UserDAO  ud = (UserDAO)MyBatisUtil.getMapper(UserDAO.class);
			//调用DAO	
			User u = new User(62,"sdf", "王波", "111", 0);
			System.out.println(u);
			ud.update(u);
			//控制事务
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
	}
}
