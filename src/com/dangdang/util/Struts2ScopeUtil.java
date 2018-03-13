package com.dangdang.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;


//简化值栈操作session作用域及application作用域的使用
public class Struts2ScopeUtil {
     
	// 向request作用域中存值
	public static void setRequesetAttrition(String Ognl, Object value) {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		valueStack.setValue("#request." + Ognl, value);
	}
	//向request作用域中取值
	public static Object getRequestAttrition(String Ognl) {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		return valueStack.findValue("#request." + Ognl);
	}

	// 向session作用域中存值
	public static void setSessionAttribute(String OGNL, Object value) {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		valueStack.setValue("#session." + OGNL, value);
	}

	// 从Session作用域中取值
	public static Object getSessionAttribute(String OGNL) {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		return valueStack.findValue("#session." + OGNL);
	}

	// 向application作用域中存值
	public static void setApplicationAttribute(String OGNL, Object value) {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		valueStack.setValue("#application." + OGNL, value);
	}

	// 从application作用域中取值
	public static Object getApplicationAttribute(String OGNL) {
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		return valueStack.findValue("#application." + OGNL);
	}
}
