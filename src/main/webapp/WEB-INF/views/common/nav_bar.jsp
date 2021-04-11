<%@ page import="com.simin.siru.model.domain.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% 
	Member member_nav = (Member)session.getAttribute("member");
%>
<div id="nav">
	<a href="/user/home">
		<img id="logo" src="/resources/image/logo/yellow.png">
	</a>
	<span id="nav_right">
		<a href="/user/board/poem/list">작품</a>
		<a href="/user/board/story/list">이야기</a>
		<%if (member_nav == null) { %>
		<a href="/user/home#start">시작</a>
		<%} else { %>
		<a href="/user/member/logout">나가기</a>
		<%} %>
	</span>
</div>
<h1 id="siru">시루</h1>