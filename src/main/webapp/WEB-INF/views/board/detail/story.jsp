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
<link rel="stylesheet" type="text/css" href="/resources/css/board/detail/story.css">
<script src="/resources/js/board/detail/story.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
	<%@ include file="../../common/write_button.jsp"%>
    <div id="wrapper">
        <div id="writing">
        	<h2><%=story.getTitle() %></h2>
        	<p id="writer"><%=story.getMember().getNickname() %></p>
        	<br/>
        	<p id="regdate"><%=story.getDate() %></p>
        	<br/>
        	<p id="content">
        		<%=story.getContent() %>
        	</p>
        </div>

		<input type="hidden" id="story_id" value="<%=story.getStory_id() %>">

        <table id="comment_table">
        	<%if (member != null) { %>
        	<tr>
        		<td>
					<input type="hidden" id="member_id" value="<%=member.getMember_id() %>">
        		</td>
        		<td>
        			<textarea id="comment"></textarea>
        		</td>
        		<td>
        			<button id="regist_button">등록</button>
        		</td>
        	</tr>
        	<%} %>
        	<tbody id="comment_list"></tbody>
        </table>
	</div>
</body>
</html>
