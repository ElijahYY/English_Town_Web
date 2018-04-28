<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
  <!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Bootstrap 实例 - 模态框（Modal）插件</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script type="text/javascript">
	window.onload=function  () {
		alert("kaishi")
		var newword =document.getElementsByTagName("td") 
		var num=newword.length/2;
		alert(num);
		var yiji=document.getElementsByClassName("btn btn-success")
		var weiji=document.getElementsByClassName("btn btn-danger")
		var kaishi=document.getElementsByClassName("btn btn-primary btn-lg")
		var word=document.getElementsByClassName("modal-body")
		
		kaishi[0].onclick=function  () {
			alert("开始复习")
			var j=0
				yiji[0].onclick=function  () {
					word[0].innerHTML= newword[j].innerHTML
					//实现改变单词属性var xhr = createXmlHttp();
					//2.设置监听-触发回掉函数
					var xhr = createXmlHttp();
					xhr.onreadystatechange =function(){
						if(xhr.readyState==4){
							if(xhr.status==200){
								xhr.responseText
							}
						}
					}
					//3.打开链接
					//请求方式，请求路径，是否异步。
					xhr.open("GET","${ pageContext.request.contextPath }/word_reword.action?time="+new Date().getTime()+"&uid="+<s:property value="#session.existuser.uid"/>+"&word="+word[0].innerHTML+"&isornot="+0,true);
					//4.发送
					xhr.send(null);
					j+=2
					if(j/2==num){
						alert("打卡成功")
					}
				}
				weiji[0].onclick=function  () {
					word[0].innerHTML = newword[j].innerHTML
					//实现改变单词属性
					var xhr = createXmlHttp();
					xhr.onreadystatechange =function(){
						if(xhr.readyState==4){
							if(xhr.status==200){
								xhr.responseText
							}
						}
					}
					//3.打开链接
					//请求方式，请求路径，是否异步。
					xhr.open("GET","${ pageContext.request.contextPath }/word_reword.action?time="+new Date().getTime()+"&uid="+<s:property value="#session.existuser.uid"/>+"&word="+word[0].innerHTML+"&isornot="+1,true);
					//4.发送
					xhr.send(null);
					j+=2
					if(j/2==num){
						alert("打卡成功")
						//实现打卡记录添加
					}
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

</head>
<body>

<table class="table">
	<caption>记事本</caption>
   <thead>
      <tr>
         <th>单词</th>
         <th>解释</th>
      </tr>
   </thead>
   <tbody>
  	<s:iterator var = "w" value="newwords">
      <tr>
         <td><s:property value="#w.word"/></td>
         <td><s:property value="#w.res"/></td>
      </tr>
      </s:iterator>
      
   </tbody>
</table>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	开始复习我的生词
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					生词本复习中
				</h4>
			</div>
			
			<div class="modal-body">
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success">已记</button>
	<!-- 表示一个危险的或潜在的负面动作 -->
				<button type="button" class="btn btn-danger">未记</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>