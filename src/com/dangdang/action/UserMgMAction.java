package com.dangdang.action;


import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.dangdang.entity.User;
import com.dangdang.service.UserService;
import com.dangdang.service.UserServiceImpl;
import com.dangdang.util.Struts2ScopeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserMgMAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String password;	//密码
	private String email;		//用户名即邮箱
	private String nickname;	//昵称
	private String emailYanZheng;	//邮箱验证码
	private User user;
	
    //登陆
	public String login(){
		ActionContext stack = ActionContext.getContext();
		UserServiceImpl us = new UserServiceImpl();
		//调用业务
		user = us.login(email, password);
		//如果没有从数据库查到数据或账户冻结，user为null
		if (user == null) {
			stack.put("loginMessage", "您的账户已冻结或密码错误！");
			return "loginerror";
		}else {
			Struts2ScopeUtil.setSessionAttribute("user", user);
			
			//地址标志位
			Object flag = Struts2ScopeUtil.getSessionAttribute("addressFlag");
			if ( flag != null) {
				if ((boolean) flag) {
					Struts2ScopeUtil.setSessionAttribute("addressFlag", false);
					return "address";
				}
			}
			return "loginsuccess";
			
		}
	}
	
	//注册
	public String reg(){
		User u = new User(email, nickname, password, 1);
		UserService us = new UserServiceImpl();
		//调用dao层
		us.register(u);
		
		UUID emailYanZheng = UUID.randomUUID();
		Struts2ScopeUtil.setSessionAttribute("emailYanZheng", emailYanZheng);
		Struts2ScopeUtil.setSessionAttribute("user", u);
		return "verifyForm";
	}
	
	//验证邮箱，解冻用户状态
	public String validateEmailCode(){
		Object object = Struts2ScopeUtil.getSessionAttribute("emailYanZheng");
		if (object != null) {
			String emailYanZhengSession = object.toString();
			if (emailYanZhengSession!=null && emailYanZheng!=null) {
			    // 相等则验证成功
				if (emailYanZheng.equals(emailYanZhengSession)) {
					User userlock = (User) Struts2ScopeUtil.getSessionAttribute("user");
					if (userlock != null) {
						//调用DAO层
						UserService us = new UserServiceImpl();
						User user = us.modifyUserStatus(userlock.getId());
						// 将解锁后的用户存入session
						Struts2ScopeUtil.setSessionAttribute("user", user);
					}
				}
			}else {
				ValueStack stack = ActionContext.getContext().getValueStack();
				stack.set("nullMessege", "未获取到验证码，请返回重试");
				return "again";
			}
		}
		//地址标志位
		Object flag = Struts2ScopeUtil.getSessionAttribute("addressFlag");
		if ( flag != null) {
			if ((boolean) flag) {
				Struts2ScopeUtil.setSessionAttribute("addressFlag", false);
				return "address";
			}
		}
		return "regSuccess";
	}
	
	//退出登录
	public String LogoutAction(){
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
/*--------getter/setter--------------*/
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmailYanZheng() {
		return emailYanZheng;
	}

	public void setEmailYanZheng(String emailYanZheng) {
		this.emailYanZheng = emailYanZheng;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
