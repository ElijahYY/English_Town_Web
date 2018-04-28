<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="headname">
		<div class="tilew w">
			<div class="titlename colorblue fl">&nbsp;&nbsp;Town&nbsp;&nbsp;Of </div>
			<div class="titlename colorgray fl">&nbsp;&nbsp;English</div>
			<ul class="fr">
				<li class="fl"><a href="${ pageContext.request.contextPath}/index.action">首页</a></li>
				<li class="fl"><a href="${pageContext.request.contextPath}/atype_findallarticle.action">文章</a></li>
				<li class="fl"><a href="${pageContext.request.contextPath}/atype_findalltest.action">真题</a></li>
				<s:if test="#session.existuser == null">
					<li class="fl"><a id ="username" href="${ pageContext.request.contextPath}/user_loginPage.action">登陆</a></li>
					<li class="fl"><a href="${ pageContext.request.contextPath}/user_registPage.action">注册</a></li>
				</s:if>
				<s:else>
					<li  class="fl"><a id ="username" href="${pageContext.request.contextPath }/user_userinformation.action"><s:property value="#session.existuser.username"/></a></li>
					<li class="fl"><a href="${pageContext.request.contextPath }/user_quit.action">退出</a></li>
				</s:else>
			</ul>
	    </div>
	</div>	