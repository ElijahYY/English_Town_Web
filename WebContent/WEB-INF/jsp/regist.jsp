<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/one.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/two.css" />
		<title>Town Of English</title>
		<script type="text/javascript">
		function checkUserName(){
			var email = document.getElementById("email").value;
			//Ajax传统方式进行校验。
			//1.创建异步交互对象。
			var xhr = createXmlHttp();
			//2.设置监听-触发回掉函数
			xhr.onreadystatechange =function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						document.getElementById("span1").innerHTML=xhr.responseText;
					}
				}
			}
			//3.打开链接
			//请求方式，请求路径，是否异步。
			xhr.open("GET","${pageContext.request.contextPath}/user_findByEmail.action?time="+new Date().getTime()+"&email="+email,true);
			//4.发送
			xhr.send(null);
			
		}
		function createXmlHttp(){
			var xmlHttp;
			try{
				xmlHttp = new XMLHttpRequest();
			}catch(e){
				try{
					xmlHttp = new ActiveXObjext("Msxm12.XMLHTTP");
				}catch(e){
					try{
						xmlHttp = new ActiveXObjext("Microsoft.XMLHTTP");
					}catch(e){
					}
				}
			}
			return xmlHttp;
		}
		</script>
	</head>
	
	<body>		
	<%@ include file="menu.jsp" %>
	<div class="kong">
		
	</div>
		<div class = "img" >
			<img src="./img/AD0IwNS9BxACGAAg89bd0QUoz8Ly8QQwgA843gI.jpg">
		</div>
		<div class = "minfo">
			<div class="mminfo">
			<form id ="registForm" action="${pageContext.request.contextPath }/user_regist.action" method="post">
				<table >
					<tr><th>注册信息</th></tr>
					<tr>
						<td>账号(邮箱):</td>
						<td><input type="text" name="email" id="email" value="" onblur="checkUserName()" />
							<span id="span1"></span>
							<span> <s:fielderror fieldName="email"/> </span>
						</td>
						<td>*</td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="password" id="" value="" />
						<span> <s:fielderror fieldName="password"/> </span>
						</td>
						<td>*</td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input type="password" name="repassword" id="" value="" /></td>
						<td>*</td>
					</tr>
					<tr>
						<td>昵称:</td>
						<td><input type="text" name="username" id="" value="" />
							<span> <s:fielderror fieldName="username"/> </span>
						</td>
						<td>*</td>
					</tr>
					<tr>
						<td>个性签名:</td>
						<td><textarea rows="10" cols="30" name="signature"></textarea></td>
						<td></td>
					</tr>
					<tr>
						<td>注册:</td>
						<td><input type="submit" name="" id="" value="注 册" /></td>
						<td></td>
					</tr>
				</table>
				</form>
			</div>
			
		</div>
		<div class="weibu">
			<span class="weibusp1">
				粤网文[2017]6138-1456号 新出网证（粤）字010号 网络视听许可证1904073号 增值电信业务经营许可证：粤B2-20090059 B2-20090028 
			</span>
			<span class="weibusp2">
				新闻信息服务许可证 粤府新函[2001]87号 违法和不良信息举报电话：0755-83765566-9 粤公网安备 44030002000001号
			</span>
			<span class="weibusp3">
				Copyright 1998 - 2018 Tencent. All Rights Reserved
			</span>
		</div>
		
	</body>
</html>
    