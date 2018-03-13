<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
			<!--用户路径开始-->			
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/main/main.jsp'>当当图书</a> >> 
			
					<s:if test="categoryList.size == 1">
						<font style='color: #cc3300'>
							<strong>
									<s:property value="categoryList[0].name" />
							</strong> 
						</font>
					</s:if>
					<s:else>
							<s:property value="categoryList[0].name" />
						 >> 
						<font style='color: #cc3300'>
							<strong>
								<s:property value="categoryList[1].name" />
							</strong> 
						</font>
					</s:else>
			<!--用户路径结束-->