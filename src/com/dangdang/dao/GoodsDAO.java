package com.dangdang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dangdang.entity.Goods;

public interface GoodsDAO {
			/* 购物车 */
	// 查询所有商品
//	public List<Goods> selectAllGoodss();

	// 通过id查询商品
	public Goods queryProductById(Integer Goodsid);

			/* 首页展示 */
	// 编辑推荐
	public List<Goods> queryEditorAdvisor();

	// 热销图书
	public List<Goods> queryHotProducts();

	// 新书热卖
	public List<Goods> queryNewHotProduct();

	// 最新上架
	public List<Goods> queryNewProducts();

	/* 分类浏览 */
	// 查某类商品
	public List<Goods> queryProductByCatgroy(@Param("parentid") Integer parentid,
			@Param("d_cateid") Object d_cateid, @Param("start") Integer start,
			@Param("end") Integer end);

	// 查某类商品数量
	public Integer queryCountByCatgroy(@Param("parentid") Integer parentid,
			@Param("d_cateid") Object d_cateid);
}
