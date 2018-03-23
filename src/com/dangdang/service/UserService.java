package com.dangdang.service;

import com.dangdang.entity.User;

public interface UserService {
	//登陆
	public User login(String email,String password);
	//注册 ,返回邮箱验证码
	public void register(User  user);
	//解冻用户状态
	public User modifyUserStatus(Integer uid);
    //用户注册邮箱是否重复
    public boolean checkEmail(String email);
}
