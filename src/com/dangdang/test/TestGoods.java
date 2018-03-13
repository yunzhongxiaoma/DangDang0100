package com.dangdang.test;

import java.util.List;

import org.junit.Test;

import com.dangdang.dao.GoodsDAO;
import com.dangdang.dao.UserDAO;
import com.dangdang.entity.Goods;
import com.dangdang.entity.User;
import com.dangdang.util.MyBatisUtil;


public class TestGoods {
	/*
    //查询所有商品
	@Test
	public  void   testSelectAllGoodss(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		java.util.List<Goods> goods = gd.selectAllGoodss();
		System.out.println(goods);		
		MyBatisUtil.closeSqlSession();
	}
	*/
    
	//通过id查询商品
	@Test
	public  void   testSelectByID(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		Goods goods = gd.queryProductById(1);
		System.out.println(goods);		
		MyBatisUtil.closeSqlSession();
	}
	
	//编辑推荐
	@Test
	public  void   testQueryEditorAdvisor(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> list = gd.queryEditorAdvisor();
		System.out.println(list);		
		MyBatisUtil.closeSqlSession();
	}
	
	//热销图书
	@Test
	public  void  testHotProduct(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> list = gd.queryHotProducts();
		System.out.println(list);		
		MyBatisUtil.closeSqlSession();
	}
	
	//新书热卖
	@Test
	public  void  testQueryNewHotProduct(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> list = gd.queryHotProducts();
		System.out.println(list);		
		MyBatisUtil.closeSqlSession();
	}
	
	//最新上架
	@Test
	public  void  testQueryNewProducts(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> list = gd.queryNewProducts();
		System.out.println(list);		
		MyBatisUtil.closeSqlSession();
	}
	
	//查某类商品
	@Test
	public  void  testQueryProductByCatgroy(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> list = gd.queryProductByCatgroy(2, null, 1, 2);
//		List<Goods> list1 = gd.queryProductByCatgroy(2, null, null, null);
		List<Goods> list1 = gd.queryProductByCatgroy(1, null, 2, 3);
//		System.out.println(list);
		System.out.println("--------------");	
		System.out.println(list1);	
		MyBatisUtil.closeSqlSession();
	}
	
	//查某类商品总数
	@Test
	public  void  testQueryCountByCatgroy(){
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		Integer count = gd.queryCountByCatgroy(2, null);
		Integer count1 = gd.queryCountByCatgroy(2, 13);
		System.out.println(count);	
		System.out.println("--------------");	
		System.out.println(count1);	
		MyBatisUtil.closeSqlSession();
	}
}
