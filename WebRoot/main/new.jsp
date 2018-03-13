<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<s:iterator value="goods">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/user/toGoodsDetails?GID=<s:property  value="GID" />" target='_blank'><img
						src='<s:property value="picaddress"/>' border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/user/toGoodsDetails?GID=<s:property  value="GID" />" target="_blank"><s:property value="name"/></a><a href="#" target="_blank"></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥<!-- 36.00 --><s:property value="originalPrice"/>
		</div>
		<div class="price">
			当当价：￥<!-- 7.20 --><s:property value="dangdangPrice"/>
		</div>
	</div>
	</s:iterator>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>