package com.dangdang.action;

import java.util.List;

import com.dangdang.entity.Goods;
import com.dangdang.service.CartService;
import com.dangdang.service.CartServiceImpl;
import com.dangdang.service.GoodsService;
import com.dangdang.service.GoodsServiceImpl;
import com.dangdang.util.BigdecimalUtil;
import com.dangdang.util.Struts2ScopeUtil;
import com.dangdang.vo.Cart;
import com.dangdang.vo.Page;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 替换request作用域传递数据
	private List<Goods> goods;
	private Goods goodsSingle;
	// 接收参数
	private Integer GID;
	private Integer parentid;
	private Integer cateid;
	private Page page;
/*
	// 查询所有
	public String selectAll() {
		GoodsService gs = new GoodsServiceImpl();
		goods = gs.selectAll();
		return "showAll";
	}
*/
	
	// 通过id查询商品
	public String toGoodsDetails(){
		GoodsService gs = new GoodsServiceImpl();
		goodsSingle = gs.findProductById(GID);
		return "productDetail";
	}
	
	/*-----------首页展示开始--------------*/
	//编辑推荐
	public String editorAdvisor(){
		GoodsService gs = new GoodsServiceImpl();
		goods = gs.findEditorAdivisor();
		return "main";
	}
	//热销图书
	public String hotProduct(){
		GoodsService gs = new GoodsServiceImpl();
		goods = gs.findHotProducts();
		return "main";
	}
	//新书热卖
	public String newHotProduct(){
		GoodsService gs = new GoodsServiceImpl();
		goods = gs.findNewHotProduct();
		return "main";
	}
	//最新上架
	public String newProduct(){
		GoodsService gs = new GoodsServiceImpl();
		goods = gs.findNewProducts();
		return "main";
	}
	
	/*-----------分类浏览开始--------------*/
	//浏览某类商品
	public String subCategoryGoodsShow(){
		GoodsService gs = new GoodsServiceImpl();
		//若page对象为null，页号PageIndex初始化设置为1
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		//设置每页显示多少条数据，每页2条数据
		page.setPageSize(2);
		Integer totalCount = gs.countByCatgroy(parentid, cateid);
		//设置页数和总条数
		page.setTotalCount(totalCount);
		goods = gs.findProductByCatgroy(parentid, cateid, page);
		return "book_list";
	}
	
	
	/*----------getter/setter-------------*/
	public Goods getGoodsSingle() {
		return goodsSingle;
	}
	
	public void setGoodsSingle(Goods goodsSingle) {
		this.goodsSingle = goodsSingle;
	}
	
	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public Integer getGID() {
		return GID;
	}

	public void setGID(Integer gID) {
		GID = gID;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getCateid() {
		return cateid;
	}

	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}

}
