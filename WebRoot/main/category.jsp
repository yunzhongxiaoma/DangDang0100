<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- 查询结果造成本页<s:iterator>结构，运行测试类TestCategory.java的方法testQueryCategroyByParentId --%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
			  <!-- 遍历 -->
			  <s:iterator value="categoryList">
				<h3>
					[<a href="${pageContext.request.contextPath}/main/subCategroyView?parentid=<s:property value="id"/>" >
						<!-- 小说 --><s:property value="name"/>
					</a>]
				</h3>
				<ul class="ul_left_list">

					<!--2级分类开始-->
					<!-- 二层遍历 -->
					<s:iterator value="secondCategory">
						<li>
							<a href='book_list.jsp'>
								<!-- 武侠小说 -->
								<a href="${pageContext.request.contextPath}/main/subCategroyView?parentid=<s:property value="parentid"/>&cateid=<s:property value="id"/>">
									<s:property value="name"/>
								</a>
							</a>
						</li>
					</s:iterator>
					<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			  </s:iterator>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>