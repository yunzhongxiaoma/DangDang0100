package com.dangdang.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dangdang.entity.Goods;
import com.dangdang.vo.Page;

public interface GoodsService {
    //购物查询所有
//	public  List<Goods>  selectAll();

				/*首页展示*/
	// 通过id查询商品
	public  Goods  findProductById(Integer gid);
	//编辑推荐
	public  List<Goods>  findEditorAdivisor();
	//热销图书
	public  List<Goods>  findHotProducts();
	//新书热卖
	public  List<Goods>  findNewHotProduct();
	//最新上架
	public  List<Goods>  findNewProducts();
	
				/*分类浏览*/
	//查某类商品
	public List<Goods> findProductByCatgroy(Integer parentid, Integer cateid, Page page);
	//查某类商品数量
	public Integer countByCatgroy(Integer parentid, Object cateid);
	
}
