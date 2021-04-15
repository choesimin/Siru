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
    	<div id="information">
    		<input type="hidden" id="member_id" value="<%=member_information.getMember_id() %>"/>
    	
			<input type="text" id="nickname" value="<%=member_information.getNickname() %>"/>

			<input type="text" id="id" value="<%=member_information.getId() %>"/>

			<input type="password" id="password" placeholder="새로운 비밀번호"/>
			<input type="password" id="repassword" placeholder="새로운 비밀번호 재입력"/>

			<input type="text" id="email" value="<%=member_information.getEmail() %>"/>

			<p id="start_day"><%=member_information.getDate() %> 부터 시작하셨습니다.</p>
			<br/>
    		<p id="information_guide">lkadsjfl;kasjflaskfjlkasdj 한년ㅇ니ㅏㅇㅎ러</p>

			<div style="text-align: center; margin-top: 30px;">	
				<button onclick="getInformation()">원래대로</button>
				<button onclick="changeInformation()">변경</button>
			</div>
    	</div>
    </div>
</body>
</html>