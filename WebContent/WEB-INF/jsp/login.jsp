<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
		<title></title>
	</head>
	
	<body >
	<%@ include file="menu.jsp" %>
	<div class="kong">
		
	</div>
		<div class="divimg">
			<img style="width="100%" height="100%"" src="${pageContext.request.contextPath}/img/AD0IwNS9BxACGAAg89bd0QUoz8Ly8QQwgA843gI.jpg">
		</div>
		<div class="divlogin1">
			
			<div class="divlogin2">
			<form id="loginForm" action="${pageContext.request.contextPath}/user_login.action" method="post" novalidate="novalidate">
				<p>账号:</p>
				<input type="text" name="email" class="txtword" value="" />
				<strong><s:actionerror/></strong>
				<p>密码:</p>
				<input type="password" name="password" class="txtword" value="" />
				<input type="submit" name="" class="txtword" value="登录" />
			</form>
			</div>
			
		</div>
		<div class="footdiv">
			<span class="footsp1">
				粤网文[2017]6138-1456号 新出网证（粤）字010号 网络视听许可证1904073号 增值电信业务经营许可证：粤B2-20090059 B2-20090028 
			</span>
			<span class="footsp2">
				新闻信息服务许可证 粤府新函[2001]87号 违法和不良信息举报电话：0755-83765566-9 粤公网安备 44030002000001号
			</span>
			<span class="footsp3">
				Copyright 1998 - 2018 Tencent. All Rights Reserved
			</span>
		</div>
		
	</body>
</html>
