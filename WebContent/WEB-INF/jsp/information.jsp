<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Town Of English 个人信息</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/information.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/infojs.js"></script>
		<script type="text/javascript">
		function update(){
			var uid = document.getElementById("text1").value;
			var email = document.getElementById("text2").value;
			var sex = document.getElementById("text3").value;
			var username = document.getElementById("text4").value;
			var signature = document.getElementById("aihao").value;
			
			//Ajax传统方式进行校验。
			//1.创建异步交互对象。
			var xhr = createXmlHttp();
			//2.设置监听-触发回掉函数
			xhr.onreadystatechange =function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						xhr.responseText
						var txt3=document.getElementById("text3");
						var txt4=document.getElementById("text4");
						var txta=document.getElementById("aihao");
						txt3.disabled=true
						txt4.disabled=true
						txta.disabled=true
						location.replace(location.href);
					}
				}
			}
			//3.打开链接
			//请求方式，请求路径，是否异步。
			xhr.open("GET","${ pageContext.request.contextPath }/user_update.action?time="+new Date().getTime()+"&uid="+uid+"&email="+email+"&sex="+sex+"&username="+username+"&signature="+signature,true);
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
	<div class="w center">
			<div class="headimg">
			<div class="change">
				<input type="button" value="修改信息" id ="button1" />
				<br />
				<a href="${pageContext.request.contextPath }/newWord_words.action?uid=<s:property value="#session.existuser.uid"/>"><input type="button" value="生词本" id ="button2" href/></a>
			</div>
			<img src="header/<s:property value="#session.existuser.img"/>"/>	
	
			<div class="tatil">
			用户ID：<input type="text" id="text1" disabled="disabled" value=<s:property value="#session.existuser.uid"/>><br /><br />	
			邮箱：<input type="text" id="text2" disabled="disabled" value=<s:property value="#session.existuser.email"/>><br /><br />	
			性别：<input type="text" id="text3" disabled="disabled" value=<s:property  value="#session.existuser.sex" />><br /><br />	
			昵称：<input type="text" id="text4" disabled="disabled" value=<s:property  value="#session.existuser.username" />><br /><br />	
			</div>
			
			<div class="aihao">
			个性签名：<br />
			<textarea rows="5" name="signature" cols="60" id="aihao"  disabled="disabled" ><s:property value="#session.existuser.signature"/></textarea><br />	
			
			<br />
			<input type="button" name="button3" id="button3" value="确定修改" onclick="update()"/>
		    </div>
		</div>
		<div class="last">
			<div class="list">
				<p>最高打卡天数</p><br />
				<span id="">
					<s:property value="#session.existuser.useday"/>
				</span>
			</div>
			<div class="list">
				<p>最高连续打卡天数</p><br />
				<span id="">
					<s:property value="#session.existuser.hcuseday"/>
				</span>
			</div>
			<div class="list">
				<p>正确率</p><br />
				<span id="">
					<s:property value="#session.existuser.correctrate"/>%
				</span>
			</div>
		</div>
		<div class="stady">
			<p><b>学习记录</b></p>
		</div>
		
		<div class="table">
			<table class="table table-hover table-striped">
				<thead>
				
					<tr>
						<th>
							是否为真题
						</th>
						<th>
							类型
						</th>
						<th>
							文章名字
						</th>
						<th>
							浏览日期
						</th>
						<th>
							阅读时间
						</th>
						
					</tr>
				</thead>
				<tbody>
				<s:iterator var="records" value="#session.existuser.records">
					<tr>
						<td>
							<s:property value="#records.article.istest"/>
							
						</td>
						<td>
							<s:property value="#records.article.atype.type"/>
						</td>
						<td>
							<s:property value="#records.article.title"/>
						</td>
						<td>
							<s:property value="#records.time"/>
						</td>
						<td>
							<s:property value="#records.readtime"/> 分钟
						</td>
						<td>
							<a href="${pageContext.request.contextPath }/article_findByAtid.action?aid=<s:property value="#records.article.aid"/>">查看</a>
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<div class="tail">
		<p>版权所有&nbsp;&nbsp;相关法律&nbsp;&nbsp;帮助中心</p>
					<p>用户反馈</p>
	</div>
	
	</body>
</html>
