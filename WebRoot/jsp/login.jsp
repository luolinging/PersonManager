<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登陆</title>
</head>


<script language="javascript">
	var XMLHttpReq = false;
	//创建XMLHttpRequest对象       
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) { //Mozilla 浏览器
			XMLHttpReq = new XMLHttpRequest();
		} else if (window.ActiveXObject) { // IE浏览器
			try {
				XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
	}
	//发送请求函数
	function sendRequest(url) {
		createXMLHttpRequest();
		XMLHttpReq.open("GET", url, true);
		XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
		XMLHttpReq.send(null); // 发送请求
	}
	// 处理返回信息函数
	function processResponse() {
		if (XMLHttpReq.readyState == 4) { // 判断对象状态
			if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
				var res = XMLHttpReq.responseXML.getElementsByTagName("res")[0].firstChild.data;
				// var res=XMLHttpReq.responseText;
				window.alert(res);
				sendRequest('/jsp/header.jsp');
			} else { //页面不正常
				window.alert("您所请求的页面有异常。");
			}
		}
	}
	// 身份验证函数
	function userCheck() {
		var uname = document.myform.name.value;
		var psw = document.myform.password.value;
		if (uname == "") {
			window.alert("用户名不能为空。");
			document.myform.name.focus();
			return false;
		} else {
			sendRequest('login.action?name=' + name + '&password=' + password);
			return true;
		}
	}
</script>


<body>
	<form action="login" method="post" name="myform" onsubmit="return userCheck()">
	用户名:<input type="text" name="name" />
		<br>
	密码:<input type="password" name="psd" />
		<br>
		<input type="submit" value="登录" onclick="userCheck()">
		<a href="${basePath}register.jsp">注册</a>
	</form>
</body>
</html>
