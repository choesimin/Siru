<%@page import="com.simin.siru.model.domain.Story"%>
<%@page import="com.simin.siru.model.common.Pager"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Story> story_list = (List<Story>)request.getAttribute("story_list");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/my/common/list.css">
<link rel="stylesheet" type="text/css" href="/resources/css/common/pager.css">
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
	<%@ include file="../../common/write_button.jsp"%>
    <div id="wrapper">
        <h2 id="board_title">내 이야기</h2>
        <div id="board">
        	<%
        		int number = pager.getNumber();
        		int currentPosition = pager.getCurrentPosition();
        	%>
        	<%for (int i = 0; i < pager.getPageSize(); i++) { %>
        	<%if (number < 1) {break;} %>
        	<%
        		Story story = story_list.get(currentPosition);
        		currentPosition++;
        		number--;
        	%>
            <a class="post" href="/user/board/story/detail?story_id=<%=story.getStory_id() %>">
            	<span class="title"><%=story.getTitle() %></span>
            	<span class="date"><%=story.getDate() %></span>
            </a>
            <%} %>
        </div>
        
        
		<div id="page_box">
			<%if (pager.getCurrentPage() > pager.getBlockSize()) { %>
			<a href="/user/my/story/list?currentPage=1">
				<span class="page"><<</span>
			</a>
			<a href="/user/my/story/list?currentPage=<%=pager.getFirstPage() - 1 %>">
				<span class="page"><</span>
			</a>
			<%} %>

			<%for (int i = pager.getFirstPage(); i <= pager.getLastPage(); i++) { %>
			<%if (i > pager.getTotalPage()) {break;} %>
			<a href="/user/my/story/list?currentPage=<%=i %>">
				<span class="page <%if (pager.getCurrentPage() == i) { %>page_active<%} %>">
				<%=i %>
				</span>
			</a>
			<%} %>

			<%if (pager.getCurrentPage() <= pager.getTotalPage() - (pager.getTotalPage() % pager.getBlockSize())) { %>
			<a href="/user/my/story/list?currentPage=<%=pager.getLastPage() + 1 %>">
				<span class="page">></span>
			</a>
			<a href="/user/my/story/list?currentPage=<%=pager.getTotalPage() %>">
				<span class="page">>></span>
			</a>
			<%} %>
		</div>
    </div>
</body>
</html>