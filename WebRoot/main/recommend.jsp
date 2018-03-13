<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
		<div class=second_c_02_b1>
			<s:iterator value="goods">
				<div class=second_c_02_b1_1>
					<a href="${pageContext.request.contextPath}/user/toGoodsDetails?GID=<s:property  value="GID" />" target='_blank'><img src='<s:property value="picaddress"/>' width="76" height="109" border=0 /> </a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href="${pageContext.request.contextPath}/user/toGoodsDetails?GID=<s:property  value="GID" />" target="_blank"><!-- 书名 --><s:property value="name"/> </a>
					</h3>
					<h4>
						作者：<s:property value="author"/> 著
						<br />
						出版社：<s:property value="publisher"/> &nbsp;&nbsp;&nbsp;&nbsp;
						出版时间：<!-- 2006-7-1 --><s:property value="publishingTime"/> 
					</h4>
					<h5>
						简介：<s:property value="briefContent"/>
					</h5>
					<h6>
						定价：￥<!-- 36.00 --><s:property value="originalPrice"/>&nbsp;&nbsp;
						当当价：￥<!-- 23.40 --><s:property value="dangdangPrice"/>
					</h6>
					<div class=line_xx></div>
				</div>
			</s:iterator>
			
			</div>
			
		</div>
	</div>