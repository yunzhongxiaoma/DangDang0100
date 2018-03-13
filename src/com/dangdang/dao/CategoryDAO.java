package com.dangdang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dangdang.entity.Category;

public interface CategoryDAO {
	//查询所有一级类别
	public List<Category> queryAllFirstCategory();
	//根parentid查询一级类别
	public Category queryFirstCategroyByParentId(Integer parentid);
//	根据id查询类别
//	public Category queryFirstCategroyById(int cateid);
	//查询一级类别和二级类别  获取用户路径
	public List<Category> queryFirstCategroyAndSecondCategroy(@Param("parentid")Integer parentid, @Param("d_cateid")Integer d_cateid);
	
}
