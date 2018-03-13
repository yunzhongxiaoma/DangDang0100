<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />
		</div>
		
		<s:if test="#session.Cart == null">
			<div id="div_no_choice"><!--  class="objhide" -->
				<!-- <div class="choice_title"></div> -->
				<div class="no_select">
					您还没有挑选商品，<a href='../main/main.jsp'> 继续挑选商品>></a>
				</div>
			</div>
		</s:if>
		<s:else>
			<div id="div_choice" class="choice_merch">
				<h2 id="cart_tips">
					您已选购以下商品
				</h2>
				<div class="choice_bord">
				<!-- ---------------MY---begin----------------- -->						
					<table class="tabl_buy" id="tbCartItemsNormal">
						<tr class="tabl_buy_title">
							<td class="buy_td_6">
								<span>&nbsp;</span>
							</td>
							<td>
								<span class="span_w1">商品名</span>
							</td>
							<td class="buy_td_5">
								<span class="span_w2">市场价</span>
							</td>
							<td class="buy_td_4">
								<span class="span_w3">当当价</span>
							</td>
							<td class="buy_td_1">
								<span class="span_w2">数量</span>
							</td>
							<td class="buy_td_2">
								<span>变更数量</span>
							</td>
							<td class="buy_td_3">
								<span>小计</span>
							</td>
							<td class="buy_td_1">
								<span>删除</span>
							</td>
						</tr>
						<tr class='objhide' over="no">
							<td colspan="8">
								&nbsp;
							</td>
						</tr>
						
	                    <!-- 购物列表开始 -->
						<s:iterator value="#session.Cart.cartMap">
							<tr class='td_no_bord'>
								<td style='display: none'>
									9317290
								</td>
								<td class="buy_td_6">
									<span class="objhide"><img /> </span>
								</td>
								<td>
									<!-- Java框架大全 -->
									<a href="#"><s:property value="value.goods.name"/></a>
								</td>
								<td class="buy_td_5">
									<%-- <span class="c_gray">180</span> --%>
									<span class="c_gray"> ￥<s:property value="value.goods.originalPrice"/></span>
								</td>
								<td class="buy_td_4">
									&nbsp;&nbsp;
									<span> ￥<s:property value="value.goods.dangdangPrice"/></span>
								</td>
								<td class="buy_td_1">
									&nbsp;&nbsp;<s:property value="value.amount"/>
								</td>
								
								<td >
										<input id="amount" value="<s:property value="value.amount"/>" class="del_num" type="text" size="3" maxlength="4" />
										<a href="
											javascript:" onclick="location='modifyCart?GID=<s:property  value="value.goods.GID"/>&amount='+document.getElementById('amount').value">
											变更
										</a>
								</td>
								<td class="buy_td_3"><!-- 小计 -->
									<s:property value="value.smallprice"/>
								</td>
								<td>
									<a href="deleteCart?GID=<s:property  value="value.goods.GID"/>">删除</a>
								</td>
							</tr>
						</s:iterator>
						<!-- 购物列表结束 -->
					</table>
					
					<div class="choice_balance">
						<div class="select_merch">
							<a href='../main/main.jsp'> 继续挑选商品>></a>
						</div>
						<div class="total_balance">
							<div class="save_total">
								您共节省：
								<span class="c_red"> ￥<span id="total_economy">
									<s:property value="#session.Cart.saveMoney"/>
								</span></span>
								
								<span id='total_vip_economy' class='objhide'> 
									( 其中享有优惠： <span class="c_red"> ￥<span id='span_vip_economy'>
										0.00	</span> </span>
									) 
								</span>
								
								<span style="font-size: 14px">|</span>
								<span class="t_add">商品金额总计：</span>
								<span class="c_red_b"> 
									￥<span id='total_account'>
										<s:property value="#session.Cart.totalprice"/>
									</span>
								</span>
								
							</div>
							<div id="balance" class="balance">
								<a name='checkout' href='../order/order_info.jsp' > 
									<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
								</a>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</s:else>
		<!-- 用户删除恢复区 -->

		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>
				<s:iterator value="#session.deleteCart.cartMap">
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#"><!-- Java基础 -->
								<s:property value="value.goods.name"/>
							</a>
						</td>
						<td width="106" class=buy_td_5>
							市场价：￥<s:property value="value.goods.originalPrice"/>
						</td>
						<td width="134" class=buy_td_4>
							当当价：<span>￥<s:property value="value.goods.dangdangPrice"/></span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="recoverCart?GID=<s:property  value="value.goods.GID"/>">
								恢复
							</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
				</s:iterator>

					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>

				</tbody>
			</table>
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>