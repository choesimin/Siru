<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member_information = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/my/information.css">
</head>
<body>
	<%@ include file="../common/nav_bar.jsp"%>
	<%@ include file="../common/write_button.jsp"%>
    <div id="wrapper">
    	<h2>내 정보</h2>
    	<table id="information">
    		<tr>
    			<td><%=member_information.getNickname() %></td>
    			<td>
					<button>변경</button>
    			</td>
    		</tr>
    		<tr>
    			<td><%=member_information.getId() %></td>
    			<td>
					<button>변경</button>
    			</td>
    		</tr>
    		<tr>
    			<td>********</td>
    			<td>
					<button>변경</button>
    			</td>
    		</tr>
    		<tr>
    			<td><%=member_information.getEmail() %></td>
    			<td>
					<button>변경</button>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><%=member_information.getDate() %> 부터 시작하셨습니다.</td>
    		</tr>
    	</table>
    </div>
</body>
</html>