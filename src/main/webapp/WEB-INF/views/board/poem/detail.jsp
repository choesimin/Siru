<%@page import="com.simin.siru.model.domain.Poem"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Poem poem = (Poem)request.getAttribute("poem");
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/board/common/detail.css">
<script src="/resources/js/board/poem/detail.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
	<%@ include file="../../common/write_button.jsp"%>

    <div id="wrapper">
        <div id="post">
        	<h2><%=poem.getTitle() %></h2>
        	<p id="date"><%=poem.getDate() %></p>
        	<p id="writer"><%=poem.getMember().getNickname() %></p>
        	<div class="clear_fix"></div>
        	<pre id="content">
<%=poem.getContent() %>
        	</pre>

			<%if ((member != null) && (member.getMember_id() == poem.getMember().getMember_id())) { %>
			<button type="button" id="delete_button">삭제</button>
			<button type="button" id="modify_button">수정</button>
			<%} %>
			<button type="button" id="like_button"<%if (member != null) { %> onclick="likePost()"<%} %>>공감 <span id="like_count"></span></button>
        </div>

		<input type="hidden" id="poem_id" value="<%=poem.getPoem_id() %>">

		<%if (member != null) { %>
		<input type="hidden" id="member_id" value="<%=member.getMember_id() %>">
		<%} %>
	</div>
</body>
</html>
