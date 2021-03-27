<%@page import="com.simin.siru.model.domain.Story"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.simin.siru.model.domain.Member"%>
<%
	Member member_home = (Member)session.getAttribute("member");
	List<Story> story_list = (List<Story>)request.getAttribute("story_list");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/home.css">
<script src="/resources/js/home.js"></script>
</head>
<body>
	<%@ include file="./common/nav_bar.jsp"%>
	<%@ include file="./common/write_button.jsp"%>
	<div id="wrapper">
		<div id="main">
			<div id="talk">
				<h2><span class="color_yellow font_weight_bolder">시</span>가<br/>머무는 곳</h2>
				<p><span class="color_yellow">열</span>심히 해보쟈</p>
			</div>
			<div id="poem">
				<h2 class="color_yellow">하루</h2>
				<p>흙과 섞이어 자연으로 누울<br/>
				내가 보이는데<br/>
				흔적을 구하려는 옳지 않음이<br/>
				옳음처럼 나를 결박합니다<br/>
				띠를 두른 흙냄새가<br/>
				목을 감아도<br/>
				묶어서 던져 버리지 못하는<br/>
				오늘은 옳지 않음의 반복입니다</p>
				<span>- 김초혜 <일기> -</span>
			</div>
		</div>
		<div id="best">
			<h2>0개의 작품, <%=story_list.size() %>개의 이야기.</h2>
			<div id="best_poem">
				<h3>공감 作</h3><a href="/poem" class="float_right">...</a>
				<table>
					<tr>
						<td><a href="#">this is..</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#">this is  of something..</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#"> of something..</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#">this this is title of something..</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#">this is title of something..</a><span>User ID</span></td>
					</tr>
				</table>
			</div>
			<div id="best_story">
				<h3>공감 이야기</h3><a href="/story" class="float_right">...</a>
				<table>
					<tr>
						<td><a href="#">this is title of something..</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#">this is title of..</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#">this is .</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#">this is title g..</a><span>User ID</span></td>
					</tr>
					<tr>
						<td><a href="#">ttitle of something..</a><span>User ID</span></td>
					</tr>
				</table>
			</div>
		</div>
		<div id="intro">
			<div id="birth">
				<h4>시루는..</h4>
				<p>
					2020년 겨울에 탄생한 시루는 <br/>
					읽고 쓰기를 좋아하는 대학생들이 모여 만들었습니다.<br/>
					<br/>
					어느 누구든 마음 속엔 작가가 살고 있습니다.<br/>
					마음 속의 작가가 활약할 수 있도록<br/>
					무대를 마련하고 싶었습니다.<br/>
					<br/>
					일상의 대화조차 명작이 될 수 있는 것처럼,<br/>
					글이라는 도구로 당신을 그려보세요.
				</p>
			</div>
			<div id="menual">
				<h4>시루 사용법</h4>
				<p>
					시루의 첫 화면은 언제나 글 한편이 차지합니다.<br/>
					한 편의 시를 보며, 하루를 정리하세요.<br/>
					<br/>
					생각이 든다면<br/>
					어떤 글이라도 상관 없습니다.<br/>
					<br/> 
					"글쓰기"를 눌러서 시작하세요.<br/>
					상세한 방법은 버튼 안에 숨겨져있으니 걱정 마세요.<br/>
					<br/>
					시루는 언제나 작가님 당신을 환영합니다.<br/>
				</p>
			</div>
		</div>
		<%if (member_home == null) { %>
		<div id="start">
			<h3>시작하세요.</h3>
			<form id="login">
				<h4 align="center" id="login_guide" class="font_size_25 margin_bottom_30">로그인</h4>
				<input type="text" placeholder="아이디" maxlength="20" id="id_login" class="no_space only_alphabet">
				<input type="password" placeholder="비밀번호" maxlength="20" id="password_login" class="no_space only_alphabet">
				<button id="login_button" type="button">시작</button>
				<div id="find_area">
					<a href="javascript:showFindId()">아이디 찾기</a> | <a href="javascript:showChangePassword()">비밀번호 변경</a>
					<div id="find_id">
						<p id="find_guide">이메일을 입력하세요.</p>
						<input type="text" placeholder="이메일" maxlength="40" id="email_find" class="no_space only_alphabet">
						<button type="button" onclick="findId()">찾기</button>
					</div>
					<div id="change_password">
						<p id="change_guide">아이디와 이메일을 입력하고 비밀번호를 변경하세요.</p>
						<input type="text" placeholder="아이디" maxlength="20" id="id_change" class="no_space only_alphabet">
						<input type="text" placeholder="이메일" maxlength="40" id="email_change" class="only_alphabet">
						<input type="password" placeholder="새로운 비밀번호" maxlength="20" id="password_change" class="no_space only_alphabet">
						<input type="password" placeholder="비밀번호 확인" maxlength="20" id="repassword_change" class="no_space only_alphabet">
						<button type="button" onclick="changePassword()">변경</button>
					</div>
				</div>
			</form>
			<form id="regist">
				<h4 align="center" class="font_size_25 margin_bottom_30" id="regist_guide">가입</h4>
				<input type="text" placeholder="(필수) 아이디 (6~20)" maxlength="20" id="id_regist" class="no_space only_alphabet">
				<input type="password" placeholder="(필수) 비밀번호 (6~20)" maxlength="20" id="password_regist" class="no_space only_alphabet">
				<input type="password" placeholder="(필수) 비밀번호 확인" maxlength="20" id="repassword_regist" class="no_space only_alphabet">
				<input type="text" placeholder="(필수) 닉네임 (한글 1~20)" maxlength="20" id="nickname_regist" class="only_hangul">
				<input type="text" placeholder="(선택) 이메일" maxlength="40" id="email_regist" class="no_space only_alphabet">
				<button id="regist_button" type="button">등록</button>
			</form>
		</div>
		<%} else { %>
		
		<%} %>
	</div>
</body>
</html>

