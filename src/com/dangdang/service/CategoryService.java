package com.dangdang.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dangdang.entity.Category;

public interface CategoryService{
	//查询所有一级类别
	public List<Category>  findAllFirstCategroy();
	//根据id查询一级类别
	public Category findFirstCategroyByParentId(Integer parentid);
	//查询一级类别和二级类别  获取用户路径
	public List<Category> findFirstCategroyAndSecondCategroy(Integer parentid, Integer d_cateid);
}
