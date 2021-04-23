<%@page import="com.simin.siru.model.domain.Banner"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Banner banner = (Banner)request.getAttribute("banner");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/board/common/regist.css">
<script src="/resources/js/admin/banner/regist.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
    <div id="wrapper">
        <form id="write_form">
            <button id="regist_button" type="button">등록</button> 
            <input name="banner_id" type="hidden" value="<%=banner.getBanner_id() %>"/>
			<input name="title" type="text" value="<%=banner.getTitle() %>"/>
			<input name="writer" type="text" value="<%=banner.getWriter() %>"/>
            <textarea name="content" cols="20" rows="10"><%=banner.getContent() %></textarea>
        </form>
    </div>
</body>
</html>