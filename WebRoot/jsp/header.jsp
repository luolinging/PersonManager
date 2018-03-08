<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登陆</title>
</head>

<body>

	<c:choose>
		<c:when test="${not empty sessionScope.user}">
				<br> 当前用户为<s:property value="name" />
				<a href="${basePath}getUser.action?id=${user.id}">${user.name}</a>		
				<a href="${basePath}logout.action?id=${user.id}">注销</a> <br> <br>
		</c:when>
		<c:otherwise>
			<li><a href="${basePath}toLogin.action">登录</a></li>
			<li><a href="${basePath}register.jsp">注册</a></li>
		</c:otherwise>
	</c:choose>

</body>
</html>
