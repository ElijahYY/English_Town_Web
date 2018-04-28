<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Town Of English 文章</title>
		<link rel="stylesheet" href="./css/article.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ar.js"></script>
	<script type="text/javascript">
	function addRecord(){
			var username = document.getElementById("username").innerHTML;
			if(username=="登陆"){
				alert("请先登录");
			}else{
				var wordp = document.getElementsByClassName("dancip");
				var resp = document.getElementsByClassName("jieship");
				var word = wordp[0].innerHTML;
				var res = resp[0].innerHTML;
				//Ajax传统方式进行校验。
				//1.创建异步交互对象。
				var xhr = createXmlHttp();
				//2.设置监听-触发回掉函数
				xhr.onreadystatechange =function(){
					if(xhr.readyState==4){
						if(xhr.status==200){
							alert(xhr.responseText);
						}
					}
				}
				//3.打开链接
				//请求方式，请求路径，是否异步。
				xhr.open("GET","${pageContext.request.contextPath}/newWord_addRecord.action?time="+new Date().getTime()+"&word="+word+"&res="+res+"&aid=<s:property value="existarticle.aid"/>",true);
				//4.发送
				xhr.send(null);
				
			}
		}
	//保存记录
	function saverecord() {
    	var username = document.getElementById("username").innerHTML;
		if(username=="登陆"){
			alert("请先登录");
		}else{
			//储存时间
			var shijian=document.getElementById("mytime")
    		var biji=document.getElementById("textarea")
	    	
	    	var rtime = shijian.innerHTML
	    	//存储笔记
	    	
	    	var content = biji.value
	    	//结束计时
	    	clearTimeout(t);
			var uid = <s:property value="#session.existuser.uid"/>
			//Ajax传统方式进行校验。
			//1.创建异步交互对象。
			var xhr = createXmlHttp();
			//2.设置监听-触发回掉函数
			xhr.onreadystatechange =function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						alert(xhr.responseText);
					}
				}
			}
			//3.打开链接
			//请求方式，请求路径，是否异步。
			xhr.open("GET","${pageContext.request.contextPath}/record_addRecord.action?sendtime="+new Date().getTime()+"&uid="+uid+"&content="+content+"&rtime="+rtime+"&aid=<s:property value="existarticle.aid"/>",true);
			//4.发送
			xhr.send(null);
			
		}
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
	<div class=" w main">
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-5 column">
			<div class="page-header">
				<h1>
					<s:property value="existarticle.title"/> 
				</h1>
			</div>
			<div class="row clearfix">
				<div class="col-md-10 column">
				</div>
				<div class="col-md-2 column">
					 <span class="label label-primary"><s:property value="atype.type"/></span>
				</div>
			</div>
		</div>
		<div class="col-md-7 column">
			<img src="${pageContext.request.contextPath}/article/<s:property value="existarticle.img"/>" />
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<p>
				<s:iterator var="conlists" value="conlist">
					<span class="word" >
						<s:property value="#conlists"/>
					</span>
				</s:iterator>
			</p>
		</div>
	</div>
</div>
</div>
<div class="shengci">
		<div class="fanyi">
				<div class="danci">
					<p class="dancip">
						单词:
					</p>
				</div>
				<div class="jieshi">
					<p class="jieship">
						解释:
					</p>
				</div>
			</div>
			
			<div class="anniu">
				<div class="tianjia">
					 <button type="button" class="btn btn-default btn-block btn-success" onclick="addRecord()">添加<tton>
				</div>
			</div>
			<div class="container" >
	<div class="row clearfix">
		
		<div class="col-md-3 column"style="padding:0px;width: 250px;">
			<div class="panel panel-default">
				<div class="panel-heading">
					
				<span class="label label-primary" >笔记</span>
                  <h1 id="mytime">00:00:00</h1>
				<div class="panel-body">
					<textarea rows="10" cols="20" id="textarea" style="resize: none;"></textarea>
				
				</div>
				<div class="panel-footer"style="padding:0px;">
					<button type="button" class="btn btn-default btn-block btn-primary" id="butn" onclick="saverecord()">打卡</button>
				</div>
			</div>
		</div>
	</div>
</div>
			
</div>

	</body>
</html>
