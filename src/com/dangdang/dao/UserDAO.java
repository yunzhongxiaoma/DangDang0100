package com.dangdang.dao;

import org.apache.ibatis.annotations.Param;

import com.dangdang.entity.User;

public interface UserDAO {
	// 登陆查询用户名密码
	public User queryUserEmailAndPassword(@Param("email") String email,@Param("password") String password);

	// 注册
	public void save(User user);

	// 注册根据邮箱查
	public User queryUserById(Integer id);

	// 更新用户状态
	public void update(User user);
}
