package com.dangdang.test;

import java.util.List;

import org.junit.Test;

import com.dangdang.dao.CategoryDAO;
import com.dangdang.entity.Category;
import com.dangdang.util.MyBatisUtil;

public class TestCategory {
	//查询所有一级类别
	@Test
	public  void   testQueryAllFirstCategory(){
		CategoryDAO cd = (CategoryDAO) MyBatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = cd.queryAllFirstCategory();
		System.out.println(list);
		MyBatisUtil.closeSqlSession();
	}
	
	//根据id查询一级类别
	@Test
	public  void   testQueryCategroyByParentId(){
		CategoryDAO cd = (CategoryDAO) MyBatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.queryFirstCategroyByParentId(1);
		System.out.println(category);	
		MyBatisUtil.closeSqlSession();
	}
	
	//根据id查询一级类别
	@Test
	public  void   testQueryFirstCategroyAndSecondCategroy(){
		CategoryDAO cd = (CategoryDAO) MyBatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = cd.queryFirstCategroyAndSecondCategroy(2, 15);
		List<Category> list1 = cd.queryFirstCategroyAndSecondCategroy(2, null);
		System.out.println(list);
		System.out.println("--------");
		System.out.println(list1);
		MyBatisUtil.closeSqlSession();
	}
	
	
}
