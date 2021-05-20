<%@page import="com.simin.siru.model.domain.Poem"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member_modify = (Member)session.getAttribute("member");
	Poem poem = (Poem)request.getAttribute("poem");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/board/common/regist.css">
<script src="/resources/js/board/poem/modify.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
    <div id="wrapper">
        <form id="write_form">
            <button id="regist_button" type="button">수정</button> 
            <input name="poem_id" type="hidden" value="<%=poem.getPoem_id() %>"/>
			<input name="title" type="text" value="<%=poem.getTitle() %>"/>
            <textarea name="content" cols="20" rows="10"><%=poem.getContent() %></textarea>
        </form>
    </div>
</body>
</html>