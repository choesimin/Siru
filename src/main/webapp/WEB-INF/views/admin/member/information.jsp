<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member_information = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/my/information.css">
<script src="/resources/js/my/information.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
	<%@ include file="../../common/write_button.jsp"%>
    <div id="wrapper">
    	<h2 id="information_guide">회원 정보</h2>
    	<div id="information">
    		<input type="hidden" id="member_id" value="<%=member_information.getMember_id() %>"/>
    	
			<input type="text" maxlength="20" id="nickname" class="only_hangul"/>

			<input type="text" maxlength="20" id="id" class="no_space no_special only_alphabet"/>

			<input type="password" id="password" maxlength="20" placeholder="비밀번호" class="no_space only_alphabet"/>
			<input type="password" id="repassword" maxlength="20" placeholder="비밀번호 확인" class="no_space only_alphabet"/>

			<input type="text" maxlength="40" id="email" class="no_space only_alphabet"/>

			<p id="start_day"><%=member_information.getDate() %> 부터 시작하셨습니다.</p>

			<div id="button_box">	
				<button onclick="getInformation()">원래대로</button>
				<button onclick="changeInformation()">변경</button>
			</div>
    	</div>
    </div>
</body>
</html>