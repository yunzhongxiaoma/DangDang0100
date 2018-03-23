package com.dangdang.service;


import com.dangdang.dao.UserDAO;
import com.dangdang.entity.User;
import com.dangdang.util.MyBatisUtil;

public class UserServiceImpl implements UserService{
	//登陆
	public User login(String email,String password){
		UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
		User user = ud.queryUserEmailAndPassword(email, password);
		//0代表true代表正常，1代表false代表冻结
		if (user == null || user.getAccountstate() == 1) {
			return null;
		} else {//正常状态
			return user;
		}
	}
	
	//注册
	@Override
	public void register(User user) {
		try{
			UserDAO  ud = (UserDAO)MyBatisUtil.getMapper(UserDAO.class);
			//调用DAO	
			ud.save(user);
			//控制事务
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
	}
	
//	验证邮箱通过后更改用户状态
	@Override
	public User modifyUserStatus(Integer id) {
		try{
			UserDAO  ud = (UserDAO)MyBatisUtil.getMapper(UserDAO.class);
			//调用DAO	层2个方法
			User user1 = ud.queryUserById(id);
//			System.out.println("修改前"+user1);
			
			//解冻账户
			user1.setAccountstate(0);
			
			ud.update(user1);
			
			User user = ud.queryUserById(id);
//			System.out.println("修改后"+user);
			//控制事务
			MyBatisUtil.commit();
			return user;
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
		}
		return null;
    }

    // 检查用户注册邮箱是否重复
    @Override
    public boolean checkEmail(String email) {
        // TODO Auto-generated method stub
        UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
        return ud.queryEmail(email);
    }
	
}
