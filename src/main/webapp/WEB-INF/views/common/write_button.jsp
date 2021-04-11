<%@ page import="com.simin.siru.model.domain.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member_write = (Member)session.getAttribute("member");
%>
<%if (member_write != null) { %>
<a href="/user/board/common/regist" id="write_button">글쓰기</a>
<%} else { %>
<a href="/user/home#start" id="write_button">글쓰기</a>
<%} %>