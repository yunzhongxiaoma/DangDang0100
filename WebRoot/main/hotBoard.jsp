<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
		<h2 class="t_xsrm">
			新书热卖榜
		</h2>
		<div id="NewProduct_1_o_t" onmouseover="">
<ul>
	<s:iterator value="goods">
	<li><a href="${pageContext.request.contextPath}/user/toGoodsDetails?GID=<s:property  value="GID" />" target="_blank"><s:property value="name"/></a></li>
	</s:iterator>
</ul>
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>