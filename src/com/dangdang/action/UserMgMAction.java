package com.dangdang.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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
	private String validateCode;	//注册验证码
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

    // AJAX请求判断用户注册邮箱是否重复
    public String checkEmail() {
        // System.out.println("后台取到的email：" + email);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //业务判断
        if ("".equals(email)) {
            out.print("请输入邮箱");
        } else if (!email.contains("@") || !email.contains(".")) {
            out.print("请输入正确的邮箱格式");
        }else {
            UserService us = new UserServiceImpl();
            boolean ExistedEmail = us.checkEmail(email);
            if (ExistedEmail) {
                out.print("该邮箱注册过本网站了，请换个邮箱注册或使用该邮箱登陆");
            } else {
                out.print("您的邮箱合法");
            }
        }
        return null;
    }
	
	//注册
	public String reg() {
        HttpServletRequest request = ServletActionContext.getRequest();
        validateCode = request.getParameter("validateCode");
//        String code = (String) ActionContext.getContext().getSession().get("code");
//	    String validateCode = (String) Struts2ScopeUtil.getRequestAttrition("validateCode");
	    String code = (String) Struts2ScopeUtil.getSessionAttribute("code");
	    if (!code.equalsIgnoreCase(validateCode)) {
	        Struts2ScopeUtil.setRequesetAttrition("wrongValidateCode", "所输验证码错误");
	        return "again";
	    }

		User u = new User(email, nickname, password, 1);
		UserService us = new UserServiceImpl();
		//调用dao层，把user插入数据库
		us.register(u);
		//生成邮箱校验码
		UUID emailYanZheng = UUID.randomUUID();
		Struts2ScopeUtil.setSessionAttribute("emailYanZheng", emailYanZheng);
		Struts2ScopeUtil.setSessionAttribute("user", u);
		return "validateEmail";
	}
	
	//验证邮箱，解冻用户状态
	public String validateEmailCode(){
	    ValueStack stack = ActionContext.getContext().getValueStack();
		Object object = Struts2ScopeUtil.getSessionAttribute("emailYanZheng");
		if (object != null) {
			String emailYanZhengSession = object.toString();
			if (emailYanZhengSession!=null && !"".equals(emailYanZheng)) {
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
				}else {
	                stack.set("nullMessege", "验证码错误");
	                return "again";
                }
			}else {
				stack.set("nullMessege", "是不是忘填验证码啦");
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
    public String getValidateCode() {
        return validateCode;
    }
    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

}
