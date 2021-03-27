function registComment() {
	var member_id = $("#member_id");
	var story_id = $("#story_id");
	var comment = $("#comment");
	
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
			}
		});
	} else {
		comment.focus();
	}
}

function getCommentList() {
	var comment_list = $("#comment_list");
	var story_id = $("#story_id");
	
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
				tag += "<tr>";
				tag += "<td>";
				tag += responseJson[i].member.nickname;
				tag += "</td>";
				tag += "<td>";
				tag += responseJson[i].content;
				tag += "</td>";
				tag += "<td>";
				tag += responseJson[i].date;
				tag += "</td>";
				tag += "</tr>";
			}
			
			comment_list.html(tag);
		}
	});
}

$(function() {
	getCommentList();
	
	$("#regist_button").on("click", function() {
		registComment();
	});
});


