<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/real.css" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
		window.onload=function  () {
		   	var str
			var c=0
	    	var t
	   
		    function two_char(n) {
	            return n >= 10 ? n : "0" + n;
	        }
	        function time_fun() {
	            var sec=0;
	           t= setInterval(function () {
	                sec++;
	                var date = new Date(0, 0)
	                date.setSeconds(sec);
	                var h = date.getHours(), m = date.getMinutes(), s = date.getSeconds();
	                document.getElementById("mytime").innerText = two_char(h) + ":" + two_char(m) + ":" + two_char(s);
	            }, 1000);
	        }
		var shijian=document.getElementById("mytime")
		var jieshu=document.getElementsByClassName("btn btn-default btn-success btn-block");
		var jiexi=document.getElementsByTagName("img")
		var kaishi=document.getElementsByClassName("btn btn-default btn-warning btn-block");
	    shijian.readOnly="true"
		kaishi[0].onclick=function(){
	    	var username = document.getElementById("username").innerHTML;
			if(username=="登陆"){
				alert("请先登录");
			}else{
				kaishi[0].disabled="true"
				time_fun()
			}
		}
			jieshu[0].onclick=function  () {
				var username = document.getElementById("username").innerHTML;
				if(username=="登陆"){
					alert("请先登录");
				}else{
					clearTimeout(t);
					jiexi[jiexi.length-1].style.display="block";
					var daan=document.getElementsByTagName("select");
					str=daan[0].value.toString()+daan[1].value+daan[2].value+daan[3].value+daan[4].value
					
					//获取到答案了。
					daan[0].disabled="true"
					daan[1].disabled="true"
					daan[2].disabled="true"
					daan[3].disabled="true"
					daan[4].disabled="true"
					jieshu[0].disabled="true"
					
			        	//存储笔记
			        	
			        	//结束计时
			        	
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
					//发送uid，aid，readtime，answer
					var readtime = shijian.innerHTML;
					var answer = str
					xhr.open("GET","${pageContext.request.contextPath }/article_addtest.action?sendtime="+new Date().getTime()+"&uid="+ <s:property value="#session.existuser.uid"/> +"&answer="+answer+"&readtime="+readtime+"&aid=<s:property value="test.aid"/>",true);
					//4.发送
					xhr.send(null);
					
					}
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
		<title>真题</title>
	</head>
	<body>
	<%@ include file="menu.jsp" %>
	<div class="kong">
		
	</div>
		<div style="height: auto;width: 1000px;position: absolute;left: 300px;">
			
		<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				<s:property value ="test.title"/>
			</h3><img alt="文章" src="${pageContext.request.contextPath }/article/6KeyPeopletoKnowatYourChild'sSchool.jpg" style="width: 800px;"/>
			<img alt="试题" src="${pageContext.request.contextPath }/article/<s:property value ="test.content"/>"style="width: 800px;" />
		</div>
	</div>
	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<img alt="解析" src="${pageContext.request.contextPath }/article/<s:property value ="test.img"/>" style="width: 800px;display: none ;" />
			<span style="display: none ;" id ="answer"><s:property value="test.answer" /></span>
		</div>
	</div>
	
<div class="container" style="position: fixed;bottom: 30px;right:-800px ;">
	<div class="">
		<select>
  <option value="A">A</option>
  <option value="B">B</option>
  <option value="C">C</option>
  <option value="D">D</option>
		</select>
		
		
			
		<select>
  <option value="A">A</option>
  <option value="B">B</option>
  <option value="C">C</option>
  <option value="D">D</option>
		</select>
		
		
			
		<select>
  <option value="A">A</option>
  <option value="B">B</option>
  <option value="C">C</option>
  <option value="D">D</option>
		</select>
		
			
		<select>
  <option value="A">A</option>
  <option value="B">B</option>
  <option value="C">C</option>
  <option value="D">D</option>
		</select>
		
			
		<select>
  <option value="A">A</option>
  <option value="B">B</option>
  <option value="C">C</option>
  <option value="D">D</option>
		</select>
	</div>	
		<div class="col-md-2 column">
			 <h1 id="mytime">00:00:00</h1>
			 <button type="button" class="btn btn-default btn-warning btn-block">开始</botton>
			 <button type="button" class="btn btn-default btn-success btn-block">结束</botton>
		</div>
	</div>
</div>
	</div>

	
	</body>
</html>