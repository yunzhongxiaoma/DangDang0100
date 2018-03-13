package com.dangdang.service;

import java.util.List;

import com.dangdang.dao.CategoryDAO;
import com.dangdang.entity.Category;
import com.dangdang.entity.Goods;
import com.dangdang.util.MyBatisUtil;

public class CategoryServiceImpl implements CategoryService{
	
	//查询所有一级类别
	@Override
	public List<Category> findAllFirstCategroy() {
		CategoryDAO cd = (CategoryDAO) MyBatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = cd.queryAllFirstCategory();
		return list;
	}

	//获取分类浏览目录
	@Override
	public Category findFirstCategroyByParentId(Integer parentid) {
		CategoryDAO cd = (CategoryDAO) MyBatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.queryFirstCategroyByParentId(parentid);
//		List<Goods> goodList = cd.queryGoodsByCatgroy(parentid,ssc,page);
		return category;
	}

	//获取用户路径
	@Override
	public List<Category> findFirstCategroyAndSecondCategroy(Integer parentid,
			Integer d_cateid) {
		CategoryDAO cd = (CategoryDAO) MyBatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = cd.queryFirstCategroyAndSecondCategroy(parentid, d_cateid);
		return list;
	}
	
/*
	@Override
	public Category findCategroyByCateId(Integer cateid) {
		CategoryDAO cd = (CategoryDAO) MyBatisUtil.getMapper(CategoryDAO.class);
	 	Category category = cd.queryCategroyByCateId(cateid);
		return category;
	}
*/
	
	
	
}
