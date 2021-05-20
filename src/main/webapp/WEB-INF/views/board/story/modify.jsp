<%@page import="com.simin.siru.model.domain.Story"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member_modify = (Member)session.getAttribute("member");
	Story story = (Story)request.getAttribute("story");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/board/common/regist.css">
<script src="/resources/js/board/story/modify.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
    <div id="wrapper">
        <form id="write_form">
            <button id="regist_button" type="button">수정</button> 
            <input name="story_id" type="hidden" value="<%=story.getStory_id() %>"/>
			<input name="title" type="text" value="<%=story.getTitle() %>"/>
            <textarea name="content" cols="20" rows="10"><%=story.getContent() %></textarea>
        </form>
    </div>
</body>
</html>