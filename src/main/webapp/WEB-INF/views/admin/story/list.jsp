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
    <div id="wrapper">
        <h2 id="board_title">이야기 관리</h2>
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
            <a class="post" href="/user/board/story/modify/form?story_id=<%=story.getStory_id() %>">
            	<span class="title"><%=story.getTitle() %></span>
            	<span class="date"><%=story.getDate() %></span>
            </a>
            <%} %>
        </div>
        
		<div id="page_box">
			<%if (pager.getCurrentPage() > pager.getBlockSize()) { %>
			<a href="/admin/story/list?currentPage=1">
				<div class="page"><<</div>
			</a>
			<a href="/admin/story/list?currentPage=<%=pager.getFirstPage() - 1 %>">
				<div class="page"><</div>
			</a>
			<%} %>

			<%for (int i = pager.getFirstPage(); i <= pager.getLastPage(); i++) { %>
			<%if (i > pager.getTotalPage()) {break;} %>
			<a href="/admin/story/list?currentPage=<%=i %>">
				<div class="page <%if (pager.getCurrentPage() == i) { %>page_active<%} %>">
				<%=i %>
				</div>
			</a>
			<%} %>

			<%if (pager.getCurrentPage() <= pager.getTotalPage() - (pager.getTotalPage() % pager.getBlockSize())) { %>
			<a href="/admin/story/list?currentPage=<%=pager.getLastPage() + 1 %>">
				<div class="page">></div>
			</a>
			<a href="/admin/story/list?currentPage=<%=pager.getTotalPage() %>">
				<div class="page">>></div>
			</a>
			<%} %>
		</div>
    </div>
</body>
</html>