function modifyPoem() {
	$("#poem_form").attr({
		action : "/user/board/poem/modify/form",
		method : "post"
	});
	$("#poem_form").submit();		
}

function deletePoem() {
	if (confirm("글을 지우시겠습니까?")) {
		$("#poem_form").attr({
			action : "/user/board/poem/delete",
			method : "post"
		});
		$("#poem_form").submit();	
	}
}

function likePost() {
	var member_id = $("#member_id");
	var poem_id = $("input[name=poem_id]");

	if (checkMemberLike() == true) {
		$.ajax({
			url : "/rest/poem/like/cancel",
			method : "post",
			data : {
				member_id : member_id.val(),
				poem_id : poem_id.val()
			},
			success : function() {
				getLike();
			}
		});
	} else {
		$.ajax({
			url : "/rest/poem/like",
			method : "post",
			data : {
				member_id : member_id.val(),
				poem_id : poem_id.val()
			},
			success : function() {
				getLike();
			}
		});
	}
}

function getLike() {
	var poem_id = $("input[name=poem_id]").val();
	var like_count = $("#like_count");
	
	$.ajax({
		url : "/rest/poem/like/count?poem_id=" + poem_id,
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
	var poem_id = $("input[name=poem_id]");
	
	$.ajax({
		url : "/rest/poem/like/check",
		async : false,
		method : "post",
		data : {
			member_id : member_id.val(),
			poem_id : poem_id.val()
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




$(function() {
	getLike();
	
	$("#modify_button").on("click", function() {
		modifyPoem();
	});

	$("#delete_button").on("click", function() {
		deletePoem();
	});
	
});


