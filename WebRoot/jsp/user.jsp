<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>


		编号<input type="text" name="user.id" value="${user.id}">
		<br>
		 姓名:<input type="text" name="user.name" value="${user.name}"/>
		<br>
		电话:<input type="text" name="user.phone" value="${user.phone}"/>
</body>
</html>
