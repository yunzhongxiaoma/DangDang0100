package com.dangdang.interceptor;

import com.dangdang.entity.User;
import com.dangdang.util.Struts2ScopeUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor {
	//	确认订单信息和提交送货地址前
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user  = (User)Struts2ScopeUtil.getSessionAttribute("user");
		if(user == null || user.getId() == null){
			//地址标志位
			Struts2ScopeUtil.setSessionAttribute("addressFlag", true);
			return "login";
		}
		invocation.invoke();
		return null;
	}

}
