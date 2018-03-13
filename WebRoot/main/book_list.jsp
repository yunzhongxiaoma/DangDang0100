<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js">
		</script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<!--用户路径开始-->	
		<div class='your_position'>
			<s:action name="userDirectoryPath" executeResult="true" namespace="/main"/>
		</div>
		<!--用户路径结束-->
		
		<div class="book">
			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
						<s:iterator value="category">
							<li>
								<div>
									<div class=second_fenlei>
										<a href="subCategroyView?parentid=<s:property value="id"/>" >
										&middot;全部(<s:property value="amount"/>)
										</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<li>
								<div>
									<s:iterator value="secondCategory">
										<div class=second_fenlei>
												&middot;
										</div>
										<div>
											<!-- 武侠小说 -->
											<a href="subCategroyView?parentid=<s:property value="parentid"/>&cateid=<s:property value="id"/>">
		 										<s:property value="name"/>&nbsp;
		 										(<!-- 10 --><s:property value="amount"/>)
		 									</a>
										</div>
									</s:iterator>
								</div>
							</li>
						    <div class="clear"></div>
							<!--2级分类结束-->
						</s:iterator>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="page.getHasPrivousPage()">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
										href="${pageContext.request.contextPath}/main/subCategroyView
												?parentid=<s:property value="parentid"/>
												&cateid=<s:property value="cateid"/>
												&page.pageIndex=<s:property value="page.pageIndex-1"/>">
									<img src='../images/page_up.gif' /> </a>
								</div>
							</s:if>	
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_up_gray.gif' />
								</div>
							</s:else>
							
							<div class='list_r_title_text3b'>
								第
								<s:property value="page.pageIndex"/>
								页
								/
								共
						   		<s:property value="page.getPageCount()"/>
								页
							</div>
							
							<s:if test="page.getHasNextPage()">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
										href="${pageContext.request.contextPath}/main/subCategroyView
											?parentid=<s:property value="parentid"/>
											&cateid=<s:property value="cateid"/>
											&page.pageIndex=<s:property value="page.pageIndex+1"/>">
										<img src='../images/page_down.gif' />
									</a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_down_gray.gif' />
								</div>
							</s:else>
							<!--分页导航结束-->
						</div>
					</div>
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<s:iterator value="goods">
							<div class="list_r_list">
								<span class="list_r_list_book"><a name="link_prd_img" href='${pageContext.request.contextPath}/user/toGoodsDetails?GID=<s:property  value="GID" />'>
									<img src="<s:property value="picaddress"/>" /> </a> </span>
								<h2>
									<a name="link_prd_name" href="${pageContext.request.contextPath}/user/toGoodsDetails?GID=<s:property  value="GID" />" target="_blank">
										<!-- 精通JavaEE轻量级框架整合方案 -->
										<s:property value="name"/>
									</a>
								</h2>
								<h3>
									顾客评分：<s:property value="score"/>
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'><s:property value="author"/></a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'><s:property value="publisher"/></a>
								</h4>
								<h4>
									出版时间：<!-- 2009-01-01 -->
									<s:property value="publishingTime"/>
								</h4>
								<h5>
									<!-- 描述：这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！ -->
									<s:property value="describe"/>
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥<s:property value="originalPrice"/></span>
									<span class="red">￥<s:property value="dangdangPrice"/></span>
									节省：￥<s:property value="originalPrice-dangdangPrice"/>
								</h6>
								<span class="list_r_list_button" /> 
								<!-- 购买 -->
								<a href="${pageContext.request.contextPath}/cart/addCart?GID=<s:property value="GID"/>"> 
									<img src='../images/buttom_goumai.gif' />
								</a>
								<span id="cartinfo"></span>
							</div>
						</s:iterator>
						<div class="clear"></div>

						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>
				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
