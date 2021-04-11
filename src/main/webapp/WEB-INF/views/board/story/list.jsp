<%@page import="com.simin.siru.model.common.Pager"%>
<%@page import="java.util.List"%>
<%@page import="com.simin.siru.model.domain.Story"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Story> story_list = (List<Story>)request.getAttribute("story_list");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/board/story/list.css">
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
	<%@ include file="../../common/write_button.jsp"%>
    <div id="wrapper">
        <h2 id="board_title">이야기</h2>
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
            	<h3><%=story.getTitle() %></h3>
            	<p><%=story.getMember().getNickname() %></p>
            </a>
            <%} %>
        </div>
		<div id="page_box">
			<%if (pager.getCurrentPage() > pager.getBlockSize()) { %>
			<a href="/user/board/story/list?currentPage=1">
				<div class="page"><<</div>
			</a>
			<a href="/user/board/story/list?currentPage=<%=pager.getFirstPage() - 1 %>">
				<div class="page"><</div>
			</a>
			<%} %>

			<%for (int i = pager.getFirstPage(); i <= pager.getLastPage(); i++) { %>
			<%if (i > pager.getTotalPage()) {break;} %>
			<a href="/user/board/story/list?currentPage=<%=i %>">
				<div class="page <%if (pager.getCurrentPage() == i) { %>page_active<%} %>">
				<%=i %>
				</div>
			</a>
			<%} %>

			<%if (pager.getCurrentPage() <= pager.getTotalPage() - (pager.getTotalPage() % pager.getBlockSize())) { %>
			<a href="/user/board/story/list?currentPage=<%=pager.getLastPage() + 1 %>">
				<div class="page">></div>
			</a>
			<a href="/user/board/story/list?currentPage=<%=pager.getTotalPage() %>">
				<div class="page">>></div>
			</a>
			<%} %>
		</div>
    </div>
</body>
</html>