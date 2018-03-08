<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

<s:iterator value="fieldErrors">
			<font color=red> <s:property value="value[0]" />
			</font>
			<br>
		</s:iterator>
		
	<s:form action="register" method="post">
用户名:<input type="text" name="user.name" /><br>
密码:<input type="password" name="user.psd" /><br>
确认密码:<input type="password" name="rePsd" /><br>
	    
		<s:submit value="同意并注册帐号" />
			已有账号?<a href="${basePath}toLogin.action">去登录</a>
	</s:form>
</body>
</html>
