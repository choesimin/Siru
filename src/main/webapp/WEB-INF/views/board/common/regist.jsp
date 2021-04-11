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
                <div id="poem_mode">作</div>
                <div id="story_mode">이야기</div>
            </div>
            <button id="regist_button" type="button">글 올리기</button> 
            <input name="member_id" type="hidden" value="<%=member_regist.getMember_id() %>"/>
            <input type="hidden"/>
			<input name="title" type="text" placeholder="제목"/>
            <textarea name="content" cols="20" rows="10" placeholder=" 시루에는 두 가지 게시판이 있습니다.&#10;왼쪽 상단의 '作' 과 '이야기' 중 하나를 선택해서 글을 써보세요.&#10;&#10; [ 作 - 작품 ]&#10; 작품을 게시하는 공간입니다.&#10;시, 소설, 수필, 일기 어떤 종류의 글도 상관없습니다.&#10;떠오르는 감정들을 그대로 풀어놓고,&#10;또는 수차례 정제해서 적어도 좋습니다.&#10;어떤 글이든 작품이 될 수 있으니까요.&#10;&#10;[ 사는 이야기 ]&#10;사람들과 일상의 이야기를 공유하는 공간입니다.&#10;즐겁거나 슬픈 일들.&#10;누군가에게 묻고 싶은 것들.&#10;남에게 말 못하던 것들.&#10;이 곳에서 털어놓으세요."></textarea>
        </form>
    </div>
</body>
</html>