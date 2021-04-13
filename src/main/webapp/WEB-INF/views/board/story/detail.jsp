<%@page import="com.simin.siru.model.domain.Story"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Story story = (Story)request.getAttribute("story");
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/board/common/detail.css">
<script src="/resources/js/board/story/detail.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
	<%@ include file="../../common/write_button.jsp"%>

    <div id="wrapper">
        <div id="post">
        	<h2><%=story.getTitle() %></h2>
        	<p id="date"><%=story.getDate() %></p>
        	<p id="writer"><%=story.getMember().getNickname() %></p>
        	<div class="clear_fix"></div>
        	<pre id="content">
<%=story.getContent() %>
        	</pre>

			<%if ((member != null) && (member.getMember_id() == story.getMember().getMember_id())) { %>
			<button type="button" id="delete_button">삭제</button>
			<button type="button" id="modify_button">수정</button>
			<%} %>
			<button type="button" id="like_button"<%if (member != null) { %> onclick="likePost()"<%} %>>공감 <span id="like_count"></span></button>
        </div>

		<input type="hidden" id="story_id" value="<%=story.getStory_id() %>">

        <div id="comment_area">
        	<%if (member != null) { %>
			<input type="hidden" id="member_id" value="<%=member.getMember_id() %>">
        	<div id="comment_regist">
				<textarea placeholder="댓글 남기기." id="comment_regist_area"></textarea>
				<button id="comment_regist_button">댓글</button>
        	</div>
        	<%} %>
        	<div id="comment_list"></div>

		</div>

        <div style="height: 100px;"></div>
	</div>
</body>
</html>
