<%@page import="com.simin.siru.model.common.Pager"%>
<%@page import="java.util.List"%>
<%@page import="com.simin.siru.model.domain.Poem"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Poem> poem_list = (List<Poem>)request.getAttribute("poem_list");
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
        <h2 id="board_title">작품 관리</h2>
        <div id="board">
        	<%
        		int number = pager.getNumber();
        		int currentPosition = pager.getCurrentPosition();
        	%>
        	<%for (int i = 0; i < pager.getPageSize(); i++) { %>
        	<%if (number < 1) {break;} %>
        	<%
        		Poem poem = poem_list.get(currentPosition);
        		currentPosition++;
        		number--;
        	%>
            <a class="post" href="/user/board/poem/modify/form?poem_id=<%=poem.getPoem_id() %>">
            	<span class="title"><%=poem.getTitle() %></span>
            	<span class="date"><%=poem.getDate() %></span>
            </a>
            <%} %>
        </div>
        
		<div id="page_box">
			<%if (pager.getCurrentPage() > pager.getBlockSize()) { %>
			<a href="/admin/poem/list?currentPage=1">
				<div class="page"><<</div>
			</a>
			<a href="/admin/poem/list?currentPage=<%=pager.getFirstPage() - 1 %>">
				<div class="page"><</div>
			</a>
			<%} %>

			<%for (int i = pager.getFirstPage(); i <= pager.getLastPage(); i++) { %>
			<%if (i > pager.getTotalPage()) {break;} %>
			<a href="/admin/poem/list?currentPage=<%=i %>">
				<div class="page <%if (pager.getCurrentPage() == i) { %>page_active<%} %>">
				<%=i %>
				</div>
			</a>
			<%} %>

			<%if (pager.getCurrentPage() <= pager.getTotalPage() - (pager.getTotalPage() % pager.getBlockSize())) { %>
			<a href="/admin/poem/list?currentPage=<%=pager.getLastPage() + 1 %>">
				<div class="page">></div>
			</a>
			<a href="/admin/poem/list?currentPage=<%=pager.getTotalPage() %>">
				<div class="page">>></div>
			</a>
			<%} %>
		</div>
    </div>
</body>
</html>