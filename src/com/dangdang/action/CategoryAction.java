package com.dangdang.action;

import java.util.List;

import com.dangdang.dao.CategoryDAO;
import com.dangdang.entity.Category;
import com.dangdang.service.CategoryService;
import com.dangdang.service.CategoryServiceImpl;
import com.dangdang.util.MyBatisUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	private static final long serialVersionUID = 8922818178124881353L;
	// 替换request作用域传递数据
	private List<Category> categoryList;
	private Category category;
	//接收参数
	private Integer cateid;
	private Integer parentid;
	
	//首页展示所有类别
	public String showFirstCategroy() {
		CategoryService cs = new CategoryServiceImpl();
		categoryList = cs.findAllFirstCategroy();
		return "main";
	}

	//分类浏览根据id查询某个一级类别
	public String subCategroyView(){
		CategoryService cs = new CategoryServiceImpl();
		category = cs.findFirstCategroyByParentId(parentid);
		return "book_list";
	}
	
	//获取用户路径  查询一级类别和二级类别  
	public String userDirectoryPath(){
		CategoryService cs = new CategoryServiceImpl();
		categoryList = cs.findFirstCategroyAndSecondCategroy(parentid, cateid);
		return "book_list";
	}
	
	
	/*		getter、setter			*/
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
	
}
