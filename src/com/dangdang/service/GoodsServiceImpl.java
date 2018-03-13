package com.dangdang.service;

import java.util.List;

import com.dangdang.dao.GoodsDAO;
import com.dangdang.entity.Goods;
import com.dangdang.util.MyBatisUtil;
import com.dangdang.vo.Page;

public class GoodsServiceImpl  implements GoodsService{
	//查询所有商品
	/*
	@Override
	public List<Goods> selectAll() {
		GoodsDAO gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> Goodss = gd.selectAllGoodss();
		MyBatisUtil.closeSqlSession();
		return  Goodss;
	}
	*/
    
    
	// 通过id查询商品
	@Override
	public Goods findProductById(Integer gid) {
		GoodsDAO gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
		Goods goods = gd.queryProductById(gid);
		MyBatisUtil.closeSqlSession();
		return  goods;
	}

	/*-----------首页展示--------------*/
	// 编辑推荐
	@Override
	public List<Goods> findEditorAdivisor() {
		GoodsDAO gd = (GoodsDAO) MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> Goodss = gd.queryEditorAdvisor();
		MyBatisUtil.closeSqlSession();
		return Goodss;
	}

	//热销图书
	@Override
	public List<Goods> findHotProducts() {
		GoodsDAO gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> Goodss = gd.queryHotProducts();
		MyBatisUtil.closeSqlSession();
		return  Goodss;
	}
	
	//新书热卖
	@Override
	public List<Goods> findNewHotProduct() {
		GoodsDAO gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> Goodss = gd.queryHotProducts();
		MyBatisUtil.closeSqlSession();
		return  Goodss;
	}
	
	//最新上架
	@Override
	public List<Goods> findNewProducts() {
		GoodsDAO gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> Goodss = gd.queryHotProducts();
		MyBatisUtil.closeSqlSession();
		return  Goodss;
	}
	
	/*-----------分类浏览（列表）--------------*/
	//查某类商品
	@Override
	public List<Goods> findProductByCatgroy(Integer parentid, Integer cateid, Page page) {
		GoodsDAO gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
		List<Goods> Goodss = gd.queryProductByCatgroy(parentid, cateid, page.getFirstResult(), page.getLastResult());
		MyBatisUtil.closeSqlSession();
		return  Goodss;
	}
	
	// 查某类商品数量
	@Override
	public Integer countByCatgroy(Integer parentid, Object cateid) {
		GoodsDAO gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
		Integer totalCount = gd.queryCountByCatgroy(parentid, cateid);
		MyBatisUtil.closeSqlSession();
		return totalCount;
	}
	
}
