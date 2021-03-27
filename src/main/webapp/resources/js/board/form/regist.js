var flag = null;

$(function(){
	$("#poem_mode").mousedown(function() {
		$("#poem_mode").css("background-color","#fbbd0d");
		$("#poem_mode").css("color","#2d2c2e");
		$("#poem_mode").css("font-weight","bold");
		$("#story_mode").css("background-color","transparent");
		$("#story_mode").css("color","#faf5e6");
		$("#story_mode").css("font-weight","normal");
		flag = true;
	});
	
	$("#story_mode").mousedown(function() {
		$("#story_mode").css("background-color","#fbbd0d");
		$("#story_mode").css("color","#2d2c2e");
		$("#story_mode").css("font-weight","bold");
		$("#poem_mode").css("background-color","transparent");
		$("#poem_mode").css("color","#faf5e6");
		$("#poem_mode").css("font-weight","normal");
		flag = false;
	});
	
	$("#regist_button").click(function() {
		var title = $("input[name='title'");
		var content = $("textarea[name='content'");
	
		if (title.val() != "" && content.val() != "") {
			if (flag == true) {
				alert("poem mode");
			} else if (flag == false) {
					$("#write_form").attr({
						action : "/user/board/story/regist",
						method : "post"
					});
					$("#write_form").submit();
			} else {
				$("#regist_button").html("선택 필수");
			}
		} else if (title.val() == "") {
			title.focus();
		} else if (content.val() == "") {
			content.focus();
		}
	});
});