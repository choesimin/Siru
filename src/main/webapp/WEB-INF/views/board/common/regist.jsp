<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member_regist = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/board/common/regist.css">
<script src="/resources/js/board/common/regist.js"></script>
</head>
<body>
	<%@ include file="../../common/nav_bar.jsp"%>
    <div id="wrapper">
        <form id="write_form">
            <div id="mode">
                <div id="poem_mode">작품</div>
                <div id="story_mode">이야기</div>
            </div>
            <button id="regist_button" type="button">글 올리기</button> 
            <input name="member_id" type="hidden" value="<%=member_regist.getMember_id() %>"/>
            <input type="hidden"/>
			<input name="title" type="text" placeholder="제목"/>
            <textarea name="content" cols="20" rows="10" placeholder=" 시루에는 두 가지 게시판이 있습니다.&#10; 왼쪽 상단의 '작품' 과 '이야기' 중 하나를 선택해서 글을 써보세요.&#10;&#10;[ 작품 ]&#10; 작품을 게시하는 공간입니다.&#10; 시, 소설, 수필, 일기 어떤 종류의 글도 상관없습니다.&#10; 떠오르는 감정들을 여러 방식으로 표현해보세요.&#10; 혹은 함께 알고 싶은 작품을 올려주세요.&#10;&#10;[ 사는 이야기 ]&#10; 일상을 공유하는 공간입니다.&#10; 댓글을 사용할 수 있어 서로 의견을 나눌 수 있습니다."></textarea>
        </form>
    </div>
</body>
</html>