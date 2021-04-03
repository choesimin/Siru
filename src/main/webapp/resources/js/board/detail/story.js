function modifyStory() {
	var story_id = $("#story_id").val();

	location.href = "/user/board/form/modify/story?story_id=" + story_id;
}

function deleteStory() {
	if (confirm("글을 지우시겠습니까?")) {
		var story_id = $("#story_id").val();

		location.href = "/user/board/story/delete?story_id=" + story_id;
	}
}

function likePost() {
	var member_id = $("#member_id");
	var story_id = $("#story_id");

	if (checkMemberLike() == true) {
		$.ajax({
			url : "/rest/story/like/cancel",
			method : "post",
			data : {
				member_id : member_id.val(),
				story_id : story_id.val()
			},
			success : function() {
				getLike();
			}
		});
	} else {
		$.ajax({
			url : "/rest/story/like",
			method : "post",
			data : {
				member_id : member_id.val(),
				story_id : story_id.val()
			},
			success : function() {
				getLike();
			}
		});
	}
}

function getLike() {
	var story_id = $("#story_id").val();
	var like_count = $("#like_count");
	
	$.ajax({
		url : "/rest/story/like/count?story_id=" + story_id,
		method : "get",
		success : function(responseData) {
			like_count.html(responseData);

			chooseLikeButtonColor();
		}
	});
}

function checkMemberLike() {
	var flag = false;

	var member_id = $("#member_id");
	var story_id = $("#story_id");
	
	$.ajax({
		url : "/rest/story/like/check",
		async : false,
		method : "post",
		data : {
			member_id : member_id.val(),
			story_id : story_id.val()
		},
		success : function(responseData) {
			flag = responseData;
		}
	});
	
	return flag;
}

function chooseLikeButtonColor() {
	var like_button = $("#like_button");
	
	if (checkMemberLike() == true) {
		like_button.css("color", "#fbbd0d");
		like_button.css("border", "1px solid #fbbd0d");
	} else {
		like_button.css("color", "#faf5e6");
		like_button.css("border", "1px solid #faf5e64d");
	}
}






function showCommentRegistButton() {
	$("#comment_regist_button").css("display", "block");
}

function hideCommentRegistButton() {
	$("#comment_regist_button").css("display", "none");
}

function registComment() {
	var member_id = $("#member_id");
	var story_id = $("#story_id");
	var comment = $("#comment_regist_area");
	
	if (comment.val() != "") {
		$.ajax({
			url : "/rest/comment/regist",
			data : {
				member_id : member_id.val(),
				story_id : story_id.val(),
				content : comment.val()
			},
			method : "post",
			success : function() {
				comment.val("");
				getCommentList();
				hideCommentRegistButton();
			}
		});
	} else {
		comment.focus();
	}
}

function deleteComment(obj) {
	if (confirm("댓글을 지우시겠습니까?")) {
		var comment_id = obj.value;
		
		$.ajax({
			url : "/rest/comment/delete?comment_id=" + comment_id,
			method : "get",
			success : function() {
				getCommentList();
			}
		});
	}
}

function modifyComment() {

}

function getComment(comment_id) {

	return commentJson;
}



function getCommentList() {
	var comment_list = $("#comment_list");
	var story_id = $("#story_id");
	var member_id = $("#member_id");
	
	$.ajax({
		url : "/rest/comment/list",
		data : {
			story_id : story_id.val()
		},
		method : "get",
		success : function(responseData) {
			var responseJson = JSON.parse(responseData);
			var tag = "";

			for (var i = 0; i < responseJson.length; i++) {
				tag += "<div class=\"comment\">";
				
				tag += "<div style=\"width: 100%\" class=\"clear_fix\">";
				if (responseJson[i].member.member_id == member_id.val()) {
					tag += "<button type=\"button\" value=\"" + responseJson[i].comment_id + "\" onclick=\"deleteComment(this)\" class=\"comment_delete_button\">×</button>";
					tag += "<button type=\"button\" value=\"" + responseJson[i].comment_id + "\" onclick=\"showCommentModifingArea(this)\" class=\"comment_modify_button\">±</button>";
				}
				tag += "<h3>" + responseJson[i].member.nickname + "</h3>";
				tag += "</div>";

				tag += "<p class=\"comment_date\">" + responseJson[i].date + "</p>";

				tag += "<div class=\"comment_content_wrapper\">"
				tag += "<pre class=\"comment_content\">" + responseJson[i].content + "</pre>";
				tag += "</div>"

				tag += "</div>";
				
			}
			
			comment_list.html(tag);
		}
	});
}

function showCommentModifingArea(obj) {
	var comment_id = obj.value;
	var comment_content_wrapper = obj.parentElement.parentElement.querySelector(".comment_content_wrapper");

	var tag = "";
	tag += "<div class=\"comment_modifing\">";
	tag += "<textarea class=\"comment_modifing_area\"></textarea>";
	tag += "<button class=\"comment_modifing_button\">수정</button>";
	tag += "<button onclick=\"cancelCommentModifing(obj)\" class=\"comment_modifing_cancel_button\">취소</button>";
	tag += "</div>";
	
	console.log(comment_content_wrapper);
	comment_content_wrapper.innerHTML = tag;
}

function cancelCommentModifing(obj) {
	var comment_id = obj.value;

}



$(function() {
	getCommentList();
	getLike();
	
	$("#modify_button").on("click", function() {
		modifyStory();
	});

	$("#delete_button").on("click", function() {
		deleteStory();
	});
	
	$("#comment_regist_button").on("click", function() {
		registComment();
	});
	
	$("#comment_regist_area").focusin(function() {
		showCommentRegistButton();
	});

});


