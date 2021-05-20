<%@page import="com.simin.siru.model.common.Pager"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Member> member_list = (List<Member>)request.getAttribute("member_list");
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
        <h2 id="board_title">회원 관리</h2>
        <div id="board">
        	<%
        		int number = pager.getNumber();
        		int currentPosition = pager.getCurrentPosition();
        	%>
        	<%for (int i = 0; i < pager.getPageSize(); i++) { %>
        	<%if (number < 1) {break;} %>
        	<%
        		Member member = member_list.get(currentPosition);
        		currentPosition++;
        		number--;
        	%>
            <a class="post" href="/admin/member/information?member_id=<%=member.getMember_id() %>">
            	<span class="title"><%=member.getNickname() %></span>
            	<span class="date"><%=member.getDate() %></span>
            </a>
            <%} %>
        </div>
        
        
		<div id="page_box">
			<%if (pager.getCurrentPage() > pager.getBlockSize()) { %>
			<a href="/admin/member/list?currentPage=1">
				<div class="page"><<</div>
			</a>
			<a href="/admin/member/list?currentPage=<%=pager.getFirstPage() - 1 %>">
				<div class="page"><</div>
			</a>
			<%} %>

			<%for (int i = pager.getFirstPage(); i <= pager.getLastPage(); i++) { %>
			<%if (i > pager.getTotalPage()) {break;} %>
			<a href="/admin/member/list?currentPage=<%=i %>">
				<div class="page <%if (pager.getCurrentPage() == i) { %>page_active<%} %>">
				<%=i %>
				</div>
			</a>
			<%} %>

			<%if (pager.getCurrentPage() <= pager.getTotalPage() - (pager.getTotalPage() % pager.getBlockSize())) { %>
			<a href="/admin/member/list?currentPage=<%=pager.getLastPage() + 1 %>">
				<div class="page">></div>
			</a>
			<a href="/admin/member/list?currentPage=<%=pager.getTotalPage() %>">
				<div class="page">>></div>
			</a>
			<%} %>
		</div>
    </div>
</body>
</html>