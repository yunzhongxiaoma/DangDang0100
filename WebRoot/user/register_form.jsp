<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript">
		function checkEmail() {
			var input = document.getElementById("txtEmail");
			var email = input.value;
	
			var xhr;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();
			} else {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhr.open("POST", "${ pageContext.request.contextPath}/user/checkEmail");
			xhr.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xhr.send("email=" + email);
	
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var messege = xhr.responseText;
					var span = document.getElementById("email.info");
					span.innerHTML = messege;
				}
			}
		}
	</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/user/reg" id="f" >
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="email" type="text" id="txtEmail" class="text_input" onblur="checkEmail()"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="name.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
					<script type="text/javascript">
						function checkPsw() {
							var pwd1 = document.getElementById("txtPassword").value;
							var pwd2 = document.getElementById("txtRepeatPass").value;
							if (pwd1 != pwd2) {
								document.getElementById("unsameWarn").style.display = "block";
								return false;
							}else {
								document.getElementById("unsameWarn").style.display = "none";
								return true;
							}
						}
					</script>
					<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="password" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input" onblur="checkPsw()"/>
								
							<font id="unsameWarn" style="display: none; color: red;">两次输入密码不一致</font>
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img src="../common/code.jsp?+Math.random()" alt="验证码" style="CURSOR:pointer" class="yzm_img" id='imgVcode'>
							<input name="validateCode" type="text" id="txtVerifyCode" 	class="yzm_input" />
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									
									<span id="number.info" style="color:red"></span>
									<a href="${ pageContext.request.contextPath}/user/register_form.jsp" >看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in" id="submit">
				<%-- <s:property value="%{ #request.wrongValidateCode}"/> --%>
				<font color="red">${wrongValidateCode }</font> 
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

