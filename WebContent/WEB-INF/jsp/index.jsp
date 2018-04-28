<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
		<title>Town Of English</title>
	</head>
	
	<body>		
	<%@ include file="menu.jsp" %>
	<div class="kong">
		
	</div>
	<!--头部完毕-->	
	<div class="w content">

		<div class="main">
			<div class="banner">
				<img class="img1" src="${pageContext.request.contextPath}/img/1.jpg"/>
			</div>
			<div class="second">
				<div class="shead">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;热门分类</p>
				</div>
				  <div class="sbody">
					<!-- 插入一级分类 -->
					<s:iterator var="at" value="#session.atlist">
						<div class="Square">
				  			<span class="Squaretext">
				  				<a href="${pageContext.request.contextPath}/atype_findAtypeArticle.action?atid=<s:property value="#at.atid"/>"><s:property value="#at.type"/></a>
				  			</span>
						</div>
					</s:iterator>
				</div>
				
			</div>
			<div class="first">
				<div class="firsta">
 					<p>推荐文章</p><a class="more" href="#">更多推荐></a>						
				</div>
				<div class="firstb" >
					<s:iterator var="article" value="arList">
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
					
				</div>				
			</div>

		</div>
		<div class="Advertisement">
			<div class="people">
				<div class="head">
					<s:if test="#session.existuser == null">
						<img src="${pageContext.request.contextPath}/header/0.jpg"/>
					</s:if>
					<s:else>
						<img src="${pageContext.request.contextPath}/header/<s:property value="#session.existuser.img"/>"/>
					</s:else>
				</div>
				<div class="name">
					<a><s:property value="#session.existuser.username"/></a>
				</div>
				<div class="information">
					<table border="1" cellspacing="" cellpadding="">
						<tr>
							<th>&nbsp;&nbsp;正确率&nbsp;&nbsp;<br /><span id="">
								<s:property value="#session.existuser.correctrate"/>%
							</span></th>
							<th>连续打卡<br /><s:property value="#session.existuser.cuseday"/>  天<br /><span id="">
								
							</span></th>
							<th>打卡天数<br /><s:property value="#session.existuser.useday"/>  天<br /><span id="">
								
							</span></th>
						</tr>
					</table>
				</div>
			</div>
			<div class="RankingList">
				<div class="Rankingname">
					<p>排行榜</p>
				</div>
				<div class="Rankingone">
					<div class="onehade">
						<p>连续打卡天数排行榜</p>
					</div>
					<div class="onebody">
						<ul>
						<s:iterator var="userl" value="uList">
							<li><s:property value="#userl.username"/></li>
						</s:iterator>
						</ul>
					</div>
					
					
				</div>
				<div class="Rankingone">
					<div class="onehade">
						<p>正确率排行榜</p>
					</div>
					<div class="onebody">
						<ul>
							<s:iterator var="ur" value="urList">
							<li><s:property value="#ur.username"/></li>
						</s:iterator>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--主题内容完毕-->
	<div class="tail">
		<p>版权所有&nbsp;&nbsp;相关法律&nbsp;&nbsp;帮助中心</p>
					<p>用户反馈</p>
	</div>
	<!--尾部完毕-->
	</body>
</html>
