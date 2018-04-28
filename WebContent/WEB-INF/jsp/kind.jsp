<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/kind.css" />
		<title>Town Of English 种类</title>
	</head>
	<body>
	<%@ include file="menu.jsp" %>
	<div class="kong">
		
	</div>
	<div class="w content">
		<div class="kindleft">
			<div class="hotProductCategory">
				<dl>
					<dt>
						<a >真题</a>
					</dt>
						<s:iterator var="al" value="alList">
								<dd>
									<a href="${pageContext.request.contextPath}/alevel_findBytestalevel.action?alid=<s:property value="#al.alid"/>"><s:property value="#al.level"/></a>
								</dd>
						</s:iterator>
					</dl>			
					
					<dl>
						<dt>
							<a >文章难度</a>
						</dt>
							<s:iterator var="al" value="alList">
								<dd>
									<a href="${pageContext.request.contextPath}/alevel_findByalevel.action?alid=<s:property value="#al.alid"/>"><s:property value="#al.level"/></a>
								</dd>
							</s:iterator>
					</dl>
					<dl>
						<dt>
							<a >文章类型</a>
						</dt>
							<s:iterator var="at" value="atList">
								<dd>
									<a href="${pageContext.request.contextPath}/atype_findAtypeArticle.action?atid=<s:property value="#at.atid"/>"><s:property value="#at.type"/></a>
								</dd>
							</s:iterator>
						</dl>
			</div>
		</div>
		    
		<div class="kindright"> 
		    <div class="firstb">
			    <s:iterator var="article" value="articles">
					<div class="article1">
							<div class="article1left">
								<img src="${pageContext.request.contextPath}/article/<s:property value="#article.img"/>" />
							</div>
							<div class="article1right">
								<div class="articlemain">
									<a href="${pageContext.request.contextPath}/article_findByAtid.action?aid=<s:property value="#article.aid"/>"><s:property value="#article.title"/></a>	
								</div>
								<div class="articlebody">
									<a ><s:property value="#article.content"/></a>
								</div>							
							</div>						
					</div>
				</s:iterator>
		    
			    	<s:iterator var="test" value="tests">
						<div class="t">
							<a href="${pageContext.request.contextPath}/article_findtestByaid.action?aid=<s:property value="#test.aid"/>"><s:property value="#test.title"/></a>				
						</div>
					</s:iterator>
				</div>
			</div>	
	  </div>
		<div class="tail">
		<p>版权所有&nbsp;&nbsp;相关法律&nbsp;&nbsp;帮助中心</p>
					<p>用户反馈</p>
	</div>
	<!--尾部完毕-->
	
	</body>
</html>
